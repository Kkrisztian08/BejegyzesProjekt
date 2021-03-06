package hu.petrik;

import java.time.LocalDateTime;

public class Bejegyzes {
    private String szerzo;
    private String tartalom;
    public int likeok=0;
    private LocalDateTime letrejott=LocalDateTime.now();
    private LocalDateTime szerkeztve=LocalDateTime.now();

    public Bejegyzes(String szerzo, String tartalom){
        this.szerzo=szerzo;
        this.tartalom=tartalom;
    }
    public String getSzerzo(){
        return this.szerzo;
    }
    public String getTartalom(){
        return this.tartalom;
    }
    public void setTartalom(String tartalom){
        this.tartalom=tartalom;
        this.szerkeztve=LocalDateTime.now();
    }
    public int getLikeok(){
        return this.likeok;
    }
    public LocalDateTime getLetrejott(){
        return this.letrejott;
    }
    public LocalDateTime getSzerkeztve(){
        return this.szerkeztve;
    }
    public void like(){
            likeok++;
    }

    @Override
    public String toString() {
        return this.szerzo+" - "+this.likeok+" - "+this.letrejott+
                "\nSzerkesztve: "+this.szerkeztve+"\n"+
                this.tartalom;
    }

}

package hu.petrik;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {
    static Scanner sc=new Scanner(System.in);
    static List<Bejegyzes> bejegyzesLista= new ArrayList<Bejegyzes>();
    static Random rn=new Random();

    public static void main(String[] args) {
        Bejegyzes b1=new Bejegyzes("Évike66", "Ma elvittem Bodrit sétálni");
        Bejegyzes b2=new Bejegyzes("Lazakirály92", "Ma elmegyek bulizni és nagyon szétcsapom magam");
        bejegyzesLista.add(b1);
        bejegyzesLista.add(b2);
        UjBejegyzesHozzaAdas();
        bejegyzesLista.addAll(fajlBeolvas("bejegyzesek.txt"));
        randomLike();
        konzolraIras();
        legnepszerubb();
        Van_e();
        KevesebbTiszenotnel();
        rendezes();



    }
    public static void UjBejegyzesHozzaAdas(){
        System.out.println("Adjon meg darabszámot:");
        int darabSzam= sc.nextInt();
        for (int i = 0; i < darabSzam; i++) {
            System.out.println("Ki irta a bejegyzést?");
            String szerzo=sc.next();
            System.out.println("Mi a bejegyzés tartalma?");
            String tartalom=sc.next();
            bejegyzesLista.add(new Bejegyzes(szerzo,tartalom));
        }
    }
    public static  List<Bejegyzes> fajlBeolvas(String fajlNev){
        ArrayList<Bejegyzes> bejegyzesLista = new ArrayList<>();
        try {
            FileReader fr=new FileReader(fajlNev);
            BufferedReader br=new BufferedReader(fr);
            String sor= br.readLine();
            while (sor!=null){
                String[] adatok=sor.split(";");
                Bejegyzes bejegyzes= new Bejegyzes(adatok[0],adatok[1]);
                bejegyzesLista.add(bejegyzes);
                sor= br.readLine();
            }
            br.close();
            fr.close();
        }catch (IOException ex){
            System.out.println(ex.getMessage());
        }
        return bejegyzesLista;
    }
    public static void randomLike() {
        int listaHossza = bejegyzesLista.size();
        for (int i = 0; i < 20; i++) {
            int rndSzam = rn.nextInt(listaHossza - 0) + 0;
            bejegyzesLista.get(rndSzam).like();
        }
    }
    public static void konzolraIras(){
        String bejegyzesek = "";
        for (Bejegyzes bejegyzes: bejegyzesLista
        ) { bejegyzesek += bejegyzes + "\n";
        }
        System.out.println(bejegyzesek);
    }
    public static void Van_e(){
        System.out.println("3/b feladat:");
        for (var item: bejegyzesLista) {
            if(item.likeok>=35){
                System.out.println("Van olyan bejegyzés, amely 35-nél több likeot kapott.");
            }else{
                System.out.println("Nincs olyan bejegyzés, amely 35-nél több likeot kapott.");
            }
        }
    }
    public static void KevesebbTiszenotnel(){
        int szam = 0;
        for (var item: bejegyzesLista
        ) {
            if(item.likeok < 15)
                szam++;
        }
        System.out.println("3/c feladat:\nEnnyi bejegyzésre likeoltak 15-nél kevesebben: " + szam);
    }
    public static void legnepszerubb(){
        int max = 0;
        for (int i = 0; i < bejegyzesLista.size(); i++) {
            if (bejegyzesLista.get(max).getLikeok() < bejegyzesLista.get(i).getLikeok()){
                max = i;
            }
        }
        System.out.println("3/a feladat:\nEz a bejegyzés kapta a legtöbb likeot: " + bejegyzesLista.get(max));
    }
    public static void rendezes(){
        System.out.println("3/d feladat: Csökkenő sorrendben a bejegyzések: ");
        Collections.sort(bejegyzesLista, Collections.reverseOrder());
        for (Bejegyzes bejegyzes: bejegyzesLista) {
            System.out.println(bejegyzes);
        }
    }

}

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

}

package hu.petrik;

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
        //System.out.println(bejegyzesLista);


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
}

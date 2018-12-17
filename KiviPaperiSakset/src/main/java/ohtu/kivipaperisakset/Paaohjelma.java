package ohtu.kivipaperisakset;

import java.util.*;
import java.util.Scanner;

public class Paaohjelma {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        while (true) {
            System.out.println("\nValitse pelataanko"
                    + "\n (a) ihmistä vastaan "
                    + "\n (b) tekoälyä vastaan"
                    + "\n (c) parannettua tekoälyä vastaan"
                    + "\nmuilla valinnoilla lopetataan");

            String vastaus = scanner.nextLine();
            String komento = vastaus.substring(vastaus.length() - 1);

            HashMap<String, Komento> komennot = new HashMap<>();
            komennot.put("a", new Kaksinpeli());
            komennot.put("b", new Yksinpeli());
            komennot.put("c", new PahaYksinpeli());

            if (komennot.containsKey(komento)) {
                System.out.println("peli loppuu kun pelaaja antaa virheellisen siirron eli jonkun muun kuin k, p tai s");
                komennot.get(komento).pelaa();
            } else {
                break;
            }

        }

    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtu.kivipaperisakset;

import java.util.Scanner;

/**
 *
 * @author vseppane
 */
public abstract class SiirtoOperaatio implements Komento {

    private static final Scanner scanner = new Scanner(System.in);

    @Override
    public void pelaa() {
        Tuomari tuomari = new Tuomari();

        String ekanSiirto = "";
        String tokanSiirto = "";
        
        while (true) {
            System.out.print("Ensimmäisen pelaajan siirto: ");
            ekanSiirto = scanner.nextLine();

            System.out.print(infoPrintti());
            tokanSiirto = vastustajanSiirto();

            if (!onkoOkSiirto(ekanSiirto) || !onkoOkSiirto(tokanSiirto)) {
                break;
            }
            
            tuomari.kirjaaSiirto(ekanSiirto, tokanSiirto);
            System.out.println(tuomari);
            System.out.println();
        }

        System.out.println();
        System.out.println("Kiitos!");
        System.out.println(tuomari);
    }

    private static boolean onkoOkSiirto(String siirto) {
        return "k".equals(siirto) || "p".equals(siirto) || "s".equals(siirto);
    }

    protected abstract String vastustajanSiirto();

    protected abstract String infoPrintti();
}

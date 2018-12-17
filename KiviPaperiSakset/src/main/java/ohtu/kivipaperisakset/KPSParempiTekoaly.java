package ohtu.kivipaperisakset;

import java.util.Scanner;

import java.util.Scanner;

// Kivi-Paperi-Sakset, jossa voidaan valita pelataanko vastustajaa
// vastaan vai ei
public class KPSParempiTekoaly extends SiirtoOperaatio {

    @Override
    protected String vastustajanSiirto() {
        TekoalyParannettu tekoaly = new TekoalyParannettu(20);
        return tekoaly.annaSiirto();
    }

    @Override
    protected String infoPrintti() {
        return ("Tietokone siirtää: ");
    }
}

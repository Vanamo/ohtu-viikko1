package ohtu.kivipaperisakset;

import java.util.Scanner;

public class KPSTekoaly extends SiirtoOperaatio {

    @Override
    protected String vastustajanSiirto() {
        Tekoaly tekoaly = new Tekoaly();
        return tekoaly.annaSiirto();
    }

    @Override
    protected String infoPrintti() {
        return "Tietokone siirtää: ";
    }
}

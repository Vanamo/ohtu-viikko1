package ohtu.kivipaperisakset;

import java.util.Scanner;

public class KPSPelaajaVsPelaaja extends SiirtoOperaatio {

    private static final Scanner scanner = new Scanner(System.in);

    @Override
    protected String vastustajanSiirto() {
        return scanner.nextLine();
    }

    @Override
    protected String infoPrintti() {
        return "Toisen pelaajan siirto: ";
    }
}

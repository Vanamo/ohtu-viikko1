/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtu.kivipaperisakset;

/**
 *
 * @author vseppane
 */
public class Kaksinpeli implements Komento {

    @Override
    public void pelaa() {
        KPSPelaajaVsPelaaja kaksinpeli = new KPSPelaajaVsPelaaja();
        kaksinpeli.pelaa();
    }

}

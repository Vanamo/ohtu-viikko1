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
public class PahaYksinpeli implements Komento {

    @Override
    public void pelaa() {
        KPSParempiTekoaly pahaYksinpeli = new KPSParempiTekoaly();
        pahaYksinpeli.pelaa();
    }

}

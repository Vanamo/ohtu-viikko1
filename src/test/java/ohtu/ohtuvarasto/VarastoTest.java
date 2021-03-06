package ohtu.ohtuvarasto;

import org.junit.*;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class VarastoTest {

    Varasto varasto;
    Varasto turhaVarasto;
    Varasto varastossaSaldoa;
    Varasto varastoJaSaldoNegatiiviset;
    Varasto alkusaldoSuurempiKuinTilavuus;
    
    double vertailuTarkkuus = 0.0001;

    @Before
    public void setUp() {
        varasto = new Varasto(10);
        turhaVarasto = new Varasto(-1);
        varastossaSaldoa = new Varasto(10, 5);
        varastoJaSaldoNegatiiviset = new Varasto(-1, -1);
        alkusaldoSuurempiKuinTilavuus = new Varasto(5, 10);
    }

    @Test
    public void konstruktoriLuoTyhjanVaraston() {
        assertEquals(0, varasto.getSaldo(), vertailuTarkkuus);
    }

    @Test
    public void konstruktoriLuoVarastonJaSaldonOikein() {
        assertEquals(5, varastossaSaldoa.getSaldo(), vertailuTarkkuus);
    }

    @Test
    public void konstruktoriLuoNegatiivisenVarastonJaSaldonOikein() {
        assertEquals(0, varastoJaSaldoNegatiiviset.getSaldo(), vertailuTarkkuus);
    }

    @Test
    public void konstruktoriLuoVarastonOikeinVaikkaSaldoTilavuuttaSuurempi() {
        assertEquals(5, alkusaldoSuurempiKuinTilavuus.getSaldo(), vertailuTarkkuus);
    }
    
    @Test
    public void uudellaVarastollaOikeaTilavuus() {
        assertEquals(10, varasto.getTilavuus(), vertailuTarkkuus);
    }
    
    @Test
    public void saldollisellaVarastollaOikeaTilavuus() {
        assertEquals(10, varastossaSaldoa.getTilavuus(), vertailuTarkkuus);
    }
        
    @Test
    public void negatiivisellaVarastollaOikeaTilavuus() {
        assertEquals(0, varastoJaSaldoNegatiiviset.getTilavuus(), vertailuTarkkuus);
    }
    
    @Test
    public void turhallaVarastollaOikeaTilavuus() {
        assertEquals(0, turhaVarasto.getTilavuus(), vertailuTarkkuus);
    }
    
    @Test
    public void lisaysLisaaSaldoa() {
        varasto.lisaaVarastoon(8);

        // saldon pitäisi olla sama kun lisätty määrä
        assertEquals(8, varasto.getSaldo(), vertailuTarkkuus);
    }

    @Test
    public void lisaysLisaaPienentaaVapaataTilaa() {
        varasto.lisaaVarastoon(8);

        // vapaata tilaa pitäisi vielä olla tilavuus-lisättävä määrä eli 2
        assertEquals(2, varasto.paljonkoMahtuu(), vertailuTarkkuus);
    }

    @Test
    public void ottaminenPalauttaaOikeanMaaran() {
        varasto.lisaaVarastoon(8);

        double saatuMaara = varasto.otaVarastosta(2);

        assertEquals(2, saatuMaara, vertailuTarkkuus);
    }

    @Test
    public void ottaminenLisääTilaa() {
        varasto.lisaaVarastoon(8);

        varasto.otaVarastosta(2);

        // varastossa pitäisi olla tilaa 10 - 8 + 2 eli 4
        assertEquals(4, varasto.paljonkoMahtuu(), vertailuTarkkuus);
    }

    @Test
    public void lisäysYlittääTilan() {
        varasto.lisaaVarastoon(11);
        
        assertEquals(10, varasto.getSaldo(), vertailuTarkkuus);
    }

    @Test
    public void lisäysNegatiivinen() {
        varasto.lisaaVarastoon(-1);
        
        assertEquals(0, varasto.getSaldo(), vertailuTarkkuus);
    }
    
    @Test
    public void tyhjästäVarastostaOttaminen() {
        varasto.otaVarastosta(5);
        
        assertEquals(0, varasto.getSaldo(), vertailuTarkkuus);
    }
    
    @Test
    public void ottoNegatiivinen() {
        varasto.otaVarastosta(-1);
        
        assertEquals(0, varasto.getSaldo(), vertailuTarkkuus);
    }
    
    @Test
    public void toStringOikein() {
        String odotettu = "saldo = 0.0, vielä tilaa 10.0";
        
        assertEquals(varasto.toString(), odotettu);
    }
}
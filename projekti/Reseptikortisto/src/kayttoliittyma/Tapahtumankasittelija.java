/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kayttoliittyma;

import sovelluslogiikka.*;
import javax.swing.*;
import java.awt.*;

/**
 *
 * @author heli
 */
public class Tapahtumankasittelija {

    Keittokirja ruokakirja;
    Resepti reseptit;
    JFrame ikkuna;
    //   Raakaaine aineet;

    public Tapahtumankasittelija(Keittokirja kirja, JFrame i) {
        ruokakirja = kirja;
        ikkuna = i;
        //   reseptit = valmistusohje;
        //   aineet = tarvike;
    }

    public void lisaaResepti() {

        Resepti tmp = new Resepti();

        Reseptiikkuna rikkuna = new Reseptiikkuna(tmp, 1);
        rikkuna.run();
        
        ruokakirja.lisaaResepti(tmp);

    }

    public void poistaResepti() {

        ruokakirja.poistaResepti();

    }

    public void muokkaaReseptia() {
        reseptit.vaihdaKategoria(null);

    }

    public void haeReseptitKategorialla() {
        ruokakirja.haeReseptit(null);

    }

    public void haeKategoria() {
        reseptit.haeKategoria();

    }

    

}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kayttoliittyma;

import java.util.*;
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
    Raakaaine raakaaineet;
    Ohje ohje;
    KeittoKirjaIkkuna kki_ikkuna;
    ReseptiIkkuna ri_ikkuna;
    Resepti lisattavaResepti;

    public Tapahtumankasittelija(Keittokirja kirja) {
        ruokakirja = kirja;
    }

    public void asetaIkkuna(KeittoKirjaIkkuna i){
        kki_ikkuna = i;
    }
    
    public void lisaaResepti() {

        lisattavaResepti = new Resepti();

        ri_ikkuna = new ReseptiIkkuna(lisattavaResepti, 1, this);
        ri_ikkuna.run();
        
    }

    public void poistaResepti() {
        
        String pnimi = kki_ikkuna.reseptiPane1.getText();
        ArrayList<Resepti> poistettava = ruokakirja.haeResepti(pnimi);
        if (poistettava.size() > 0){
            ruokakirja.poistaResepti(poistettava.get(0));        
        }
        
        String[] lista = ruokakirja.haeReseptienNimet();
        
        kki_ikkuna.jList.setListData(lista);
        kki_ikkuna.jList.setSelectedIndex(0);
        paivitaNayttoReseptinTiedoilla();

    }

    public void tallennaResepti() {

        String nimi = ri_ikkuna.reseptinimi.getText();
        lisattavaResepti.setReseptinNimi(nimi);
        ruokakirja.lisaaResepti(lisattavaResepti);
        
        ri_ikkuna.dispose();
        
        String[] lista = ruokakirja.haeReseptienNimet();        
        kki_ikkuna.jList.setListData(lista);
    }

    public void haeVaikeusaste() {
        reseptit.haeVaikeusaste();
    }

    public void paivitaNayttoReseptinTiedoilla() {
        
        int paikka = kki_ikkuna.jList.getSelectedIndex();
        if (paikka < 0){
            paikka = 0;
        }
        Resepti tmp = ruokakirja.palautaResepti(paikka);
        if (tmp != null){      
            kki_ikkuna.reseptiPane2.setText(tmp.haeKategoria());
            kki_ikkuna.reseptiPane1.setText(tmp.haeNimi());
            kki_ikkuna.reseptiPane3.setText("" + tmp.haeVaikeusaste());
            kki_ikkuna.raakaainePane.setText(tmp.haeRaakaaineet());
            kki_ikkuna.ohjePane.setText(tmp.haeOhjeet());
        } else {
            kki_ikkuna.reseptiPane2.setText("");
            kki_ikkuna.reseptiPane1.setText("");
            kki_ikkuna.reseptiPane3.setText("");
            kki_ikkuna.raakaainePane.setText("");
            kki_ikkuna.ohjePane.setText("");

        }
    }

    public void lisaaRaakaaine(){
        
        String raine = ri_ikkuna.raakaaine1.getText();
        String rmaara = ri_ikkuna.maara1.getText();
        String ryks = ri_ikkuna.yksikko1.getText();
       
        Double testi = new Double(rmaara);
        Raakaaine ra = new Raakaaine(raine, ryks, testi);
        lisattavaResepti.lisaaRaakaaine(ra);
        
        String tulostus = lisattavaResepti.haeRaakaaineet();
        ri_ikkuna.raakaaineLomakePane.setText(tulostus);
    }

    public void lisaaOhje(){
        
        String vaihe = ri_ikkuna.ohje.getText();
       
        Ohje oh = new Ohje(vaihe);
        lisattavaResepti.lisaaVaihe(oh);
        
        String tulostus = lisattavaResepti.haeOhjeet();
        ri_ikkuna.ohjeTosiAlaPane.setText(tulostus);
    }
    
    public void talletaKategoria(String kat){
        lisattavaResepti.setKategoria(kat);        
    }

    public void talletaVaikeusAste(int va){
        lisattavaResepti.setvaikeusaste(va);        
    }

    public void tallenna() {
        ruokakirja.tallenna();
    }
    
    public void poistu() {
    
        System.exit(0);
        
    }

}

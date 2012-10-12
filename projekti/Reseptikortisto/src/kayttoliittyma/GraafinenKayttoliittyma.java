package kayttoliittyma;


import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import sovelluslogiikka.*;

public class GraafinenKayttoliittyma {

    private KeittoKirjaIkkuna ikkuna;
    Tapahtumankasittelija tk;
    Kuuntelija kuuntelija;
    Keittokirja kirja;
    
    public GraafinenKayttoliittyma(Keittokirja k){
        
            kirja = k;
            tk = new Tapahtumankasittelija(kirja);
            ikkuna = new KeittoKirjaIkkuna(kirja, tk);
            tk.asetaIkkuna(ikkuna);
            tk.paivitaNayttoReseptinTiedoilla();
            ikkuna.run();
    }
    
    public static void main(String[] args) throws IOException {

        Keittokirja kirja;
        kirja = Keittokirja.lue();

        GraafinenKayttoliittyma testi = new GraafinenKayttoliittyma(kirja);
        
    }


}

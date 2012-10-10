package kayttoliittyma;


import javax.swing.*;
import java.awt.*;
import sovelluslogiikka.*;

public class GraafinenKayttoliittyma implements Runnable {

    private ReseptiFrame ikkuna;
    Tapahtumankasittelija tk;
    Kuuntelija kuuntelija;
    Keittokirja kirja;
    
    public GraafinenKayttoliittyma(Keittokirja k){
        
            tk = new Tapahtumankasittelija(kirja, ikkuna);
            kuuntelija = new Kuuntelija(tk);
            kirja = k;
    }

    public void run() {
        ikkuna = new ReseptiFrame(kuuntelija, kirja);
        ikkuna.setPreferredSize(new Dimension(700, 800));

        ikkuna.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

//        luoKomponentit(ikkuna.getContentPane());

        ikkuna.pack();
        ikkuna.setVisible(true);
    }


    public JFrame getFrame() {
        return ikkuna;
    }


}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kayttoliittyma;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author heli
 */
public class Kuuntelija implements ActionListener, ListSelectionListener {

    private Tapahtumankasittelija tapk;
    
    public Kuuntelija(Tapahtumankasittelija tk){
        tapk = tk;
    }
   
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        
        if (ae.getActionCommand().equalsIgnoreCase("Lisää resepti")){
            tapk.lisaaResepti();
        } else if (ae.getActionCommand().equalsIgnoreCase("Poista resepti")){
            tapk.poistaResepti();
        } else if (ae.getActionCommand().equalsIgnoreCase("Lisaa raaka-aine")){
            tapk.lisaaRaakaaine();            
        } else if (ae.getActionCommand().equalsIgnoreCase("Tallenna")){
            tapk.tallenna();            
        } else if (ae.getActionCommand().equalsIgnoreCase("Lisaa vaihe")){
            tapk.lisaaOhje();            
        } else if (ae.getActionCommand().equalsIgnoreCase("Tallenna resepti")){
            tapk.tallennaResepti();            
        } else if (ae.getActionCommand().equalsIgnoreCase("Kala")) {
            tapk.talletaKategoria("Kala");
        } else if (ae.getActionCommand().equalsIgnoreCase("Kana")){
            tapk.talletaKategoria("Kana");
        } else if (ae.getActionCommand().equalsIgnoreCase("Liha")){
            tapk.talletaKategoria("Liha");
        } else if (ae.getActionCommand().equalsIgnoreCase("Kasvis")){
            tapk.talletaKategoria("Kasvis");
        } else if (ae.getActionCommand().equalsIgnoreCase("Herkut")){
            tapk.talletaKategoria("Harkut");
        } else if (ae.getActionCommand().equalsIgnoreCase("Yksi")) {
            tapk.talletaVaikeusAste(1);
        } else if (ae.getActionCommand().equalsIgnoreCase("Kaksi")){
            tapk.talletaVaikeusAste(2);
        } else if (ae.getActionCommand().equalsIgnoreCase("Kolme")){
            tapk.talletaVaikeusAste(3);
        } else if (ae.getActionCommand().equalsIgnoreCase("Neljä")){
            tapk.talletaVaikeusAste(4);
        } else if (ae.getActionCommand().equalsIgnoreCase("Viisi")){
            tapk.talletaVaikeusAste(5);
        } else if (ae.getActionCommand().equalsIgnoreCase("Poistu")){
            tapk.poistu();
        } 

        
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        
        tapk.paivitaNayttoReseptinTiedoilla();

    }
    
}

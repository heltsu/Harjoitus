/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kayttoliittyma;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author heli
 */
public class Kuuntelija implements ActionListener {

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
        } else if (ae.getActionCommand().equalsIgnoreCase("Muokkaa reseptiä")){
            tapk.muokkaaReseptia();            
        } else if (ae.getActionCommand().equalsIgnoreCase("Kala") && ae.getActionCommand().equalsIgnoreCase("Hae")) {
            tapk.haeReseptitKategorialla(); 
        } else if (ae.getActionCommand().equalsIgnoreCase("Kana") && ae.getActionCommand().equalsIgnoreCase("Hae")){
            tapk.haeReseptitKategorialla();
        } else if (ae.getActionCommand().equalsIgnoreCase("Liha")&& ae.getActionCommand().equalsIgnoreCase("Hae") ){
            tapk.haeReseptitKategorialla();
        } else if (ae.getActionCommand().equalsIgnoreCase("Kasvis")&& ae.getActionCommand().equalsIgnoreCase("Hae") ){
            tapk.haeReseptitKategorialla();
        } else if (ae.getActionCommand().equalsIgnoreCase("Herkut")&& ae.getActionCommand().equalsIgnoreCase("Hae") ){
            tapk.haeReseptitKategorialla();
        } 

        
    }
    
}

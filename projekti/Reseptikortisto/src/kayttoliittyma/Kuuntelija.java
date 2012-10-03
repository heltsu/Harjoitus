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
        
        if (ae.getActionCommand().equalsIgnoreCase("lisaa resepti")){
            tapk.lisaaResepti();
        } else if (ae.getActionCommand().equalsIgnoreCase("poista resepti")){
            tapk.poistaResepti();
        } else if (ae.getActionCommand().equalsIgnoreCase("muokkaa reseptiä")){
            tapk.muokkaaReseptia();            
        }
        
    }
    
}

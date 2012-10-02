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

    private Tapahtumankasittelija m_tk;
    
    public Kuuntelija(Tapahtumankasittelija tk){
        m_tk = tk;
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        
        if (ae.getActionCommand().equalsIgnoreCase("lisaa resepti")){
            m_tk.lisaaResepti();
        } else if (ae.getActionCommand().equalsIgnoreCase("poista resepti")){
            m_tk.poistaResepti();
        } else if (ae.getActionCommand().equalsIgnoreCase("muokkaa reseptiä")){
            m_tk.muokkaaReseptia();            
        }
        
    }
    
}

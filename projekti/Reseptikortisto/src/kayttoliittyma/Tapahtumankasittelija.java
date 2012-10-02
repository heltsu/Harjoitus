/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package kayttoliittyma;

import sovelluslogiikka.*;

/**
 *
 * @author heli
 */
public class Tapahtumankasittelija {
    
    Keittokirja m_kirja;
    
    public Tapahtumankasittelija(Keittokirja kirja){
        m_kirja = kirja;
    }
    
    public void lisaaResepti(){
        
        Resepti uuniomena = new Resepti("Uuniomenat", 2, "kala");
        m_kirja.lisaaResepti(uuniomena);
    }

    public void poistaResepti(){

    }

    public void muokkaaReseptia(){

    }

    
}

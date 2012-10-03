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
    
    Keittokirja ruokakirja;
    
    public Tapahtumankasittelija(Keittokirja kirja){
        ruokakirja = kirja;
    }
    
    public void lisaaResepti(){
        
        Resepti uuniomena = new Resepti("Uuniomenat", 2, "kala");
        ruokakirja.lisaaResepti(uuniomena);
    }

    public void poistaResepti(){

    }

    public void muokkaaReseptia(){

    }

    
}

package sovelluslogiikka;

// reseptin työvaiheet
import java.io.*;


public class Ohje implements Serializable{

     String vaihe;

     /**
      * tehdään Ohje olio jolle annetaan työvaihe
      * @param vaihe, käyttäjän antama ohjeen työvaihe
      */
    public Ohje(String vaihe) {
        this.vaihe = vaihe;
    }
    
    /**
     * lisätään ohjeeseen haluttu työvaihe
     * @param vaihe käyttäjän antama ohjeen työvaihe
     */
    public void annaVaihe(String vaihe){
        this.vaihe = vaihe;
    }
    
    public String getVaihe(){
        return vaihe;
    }
    
    @Override
    public String toString(){
         return vaihe;
    }
}

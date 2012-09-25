package sovelluslogiikka;

// reseptin työvaiheet


public class Ohje {

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
    
    @Override
    public String toString(){
         return vaihe;
    }
}

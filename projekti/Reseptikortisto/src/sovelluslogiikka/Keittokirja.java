package sovelluslogiikka;

//sisältää reseptit
//Admin voi lisätä, poistaa ja muokata reseptejä
import java.util.*;

public class Keittokirja {

    ArrayList<Resepti> kirja = new ArrayList<Resepti>();

    public Keittokirja() {
    }
    
    /**
     * etsitään haluttu resepti keittokirjasta reseptin nimen avulla
     * @param reseptin_nimi, käyttäjän antama reseptin nimi
     * @return haluttu resepti
     */
    public ArrayList<Resepti> haeResepti(String reseptin_nimi) {

        ArrayList<Resepti> nimet = new ArrayList<Resepti>();

        for (Resepti nimi : kirja) {
            if (nimi.haeNimi().equals(reseptin_nimi)) {
                nimet.add(nimi);
            }
        }
        return nimet;
    }

    /**
     * etsitään tiettyyn kategoriaan kuuluva resepti keittokirjasta
     * @param kategoria, käyttäjän antama kategoria
     * @return annettuun kategoriaan kuuluvat reseptit
     */
    public ArrayList<Resepti> haeReseptit(String kategoria) {

        ArrayList<Resepti> kategorialista = new ArrayList<Resepti>();

        for (Resepti nimi : kirja){
            if (nimi.haeKategoria().equals(kategoria)){
                kategorialista.add(nimi);
            }
        }
        return kategorialista;
    }

    /**
     * etsitään haluttuun kategoriaan ja tietyn vaikeusasteen omaavat reseptit
     * @param kategoria käyttäjän antama kategoriatieto
     * @param vaikeusaste käyttäjän antama tieto
     * @return halutut reseptit
     */    
    public ArrayList<Resepti> haeReseptit(String kategoria, int vaikeusaste) {
        
        ArrayList<Resepti> molemmat = new ArrayList<Resepti>();
        
        for (Resepti nimi : kirja){
            if (nimi.haeKategoria().equals(kategoria) && nimi.haeVaikeusaste()==(vaikeusaste)){
                molemmat.add(nimi);
            }
        }
        return molemmat;
    }
  /*  
    public ArrayList<Resepti> haeReseptitIlmanRaakaainetta(String raakaaine){
       
        ArrayList<Resepti>ilmanainetta = new ArrayList<Resepti>();
        
        for (Resepti : raakaaineet){
            if (nimi.haeNimi().(raakaaine)){
                
            }}
        return ilmanainetta;
    }*/
    /**
     * poistaResepti poistaa keittokirjasta halutun reseptin
     * @param nimi Käyttäjän antama syöte, reseptin nimi
     * 
     */
    public void poistaResepti(Resepti nimi) {
        if (kirja.contains(nimi)) {
            kirja.remove(nimi);
        }
        //vain AD voi poistaa
    }
    /**
     * lisaaResepti lisätään keittokirjaan haluttu resepti
     * @param resepti käyttäjän antama syöte
     */
    public void lisaaResepti(Resepti resepti) {
        kirja.add(resepti);
        //vain AD voi lisätä
    }
    /**
     * muokkaaReseptiä avulla voi korjata / muuttaa reseptillä olevia tietoja
     * @param nimi syöttäjän antama syöte
     */
    public void muokkaaReseptia(String nimi) {
        //vain AD voi muokata
    }
    
    

    public String ToString() {
        return "" + kirja;
    }
}

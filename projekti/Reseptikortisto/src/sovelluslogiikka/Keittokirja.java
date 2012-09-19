package sovelluslogiikka;

//sisältää reseptit
//Admin voi lisätä, poistaa ja muokata reseptejä
import java.util.*;

public class Keittokirja {

    ArrayList<Resepti> kirja = new ArrayList<Resepti>();

    public Keittokirja() {
    }

    public boolean haeResepti(Resepti nimi) {
        if (kirja.contains(nimi)) {
            return true;
        } else {
            return false;
        }
    }

    public void haeReseptit(Resepti laatu) {
        
    }

    public void haeReseptit(Resepti laatu, Resepti vaikeusaste) {
        
    }

    public void poistaResepti(Resepti nimi) {
        kirja.remove(nimi);
        //vain AD voi poistaa
    }

    public void lisaaResepti(Resepti nimi) {
        kirja.add(nimi);
        //vain AD voi lisätä
    }

    public boolean loytyykoResepti(Resepti nimi) {
        if (kirja.contains(nimi)) {
            return true;
        }
            return false;
    }

    public void muokkaaReseptia(String nimi) {
        //vain AD voi muokata
    }

    public String ToString() {
        return "" + kirja;
    }
}

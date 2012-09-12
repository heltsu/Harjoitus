
import java.util.*;

public class Ruokakortisto {

    String nimi;
    int vaikeusaste;
    String kategoria;
    ArrayList<String> reseptit = new ArrayList<String>();

    public Ruokakortisto(String nimi, int vaikeusaste, String kategoria) {
        this.kategoria = kategoria;
        this.nimi = nimi;
        if (vaikeusaste <= 0) {
            this.vaikeusaste = 0;
        } else if (vaikeusaste >= 5) {
            this.vaikeusaste = 5;
        } else {
            this.vaikeusaste = vaikeusaste;
        }
    }

    public String haeNimi() {

        return nimi;
    }

    public String haeKategoria() {

        return kategoria;
    }

    public int haeVaikeusaste() {

        return vaikeusaste;
    }

    public void lisaaResepti(String nimi) {

        reseptit.add(nimi);
    }

    public boolean haeResepti(String nimi) {
        this.nimi = nimi;
        if (reseptit.contains(nimi)) {
            return true;
        } else {
            return false;
        }
    }
    
}

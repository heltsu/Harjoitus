import java.util.*;

public class Ruokakortisto {
    String nimi;
    int vaikeusaste;
    String kategoria;
    ArrayList<String> reseptit = new ArrayList<String>();

    public Ruokakortisto(String nimi, int vaikeusaste) {
        this.nimi = nimi;
        this.vaikeusaste = vaikeusaste;
    }

    public String haeNimi() {

        return nimi;
    }

    public String haeKategoria() {

        return kategoria;
    }

    public int haeVaikeusaste() {
        if (vaikeusaste <= 0) {
            return 0;
        } else if (vaikeusaste >= 5) {
            return 5;
        } else {
            return vaikeusaste;
        }
    }

    public void lisaaRespeti(String nimi) {

        reseptit.add(nimi);
    }
}

package sovelluslogiikka;


import java.util.*;

public class Resepti {

    String nimi;
    int vaikeusaste;
    String kategoria;
    ArrayList<Raakaaine> raakaaineet = new ArrayList<Raakaaine>();
    ArrayList<Ohje> tyovaiheet = new ArrayList<Ohje>();

    public Resepti(String nimi, int vaikeusaste, String kategoria) {

        this.nimi = nimi;
        
        tarkistaVaikeusaste(vaikeusaste);
        
        if (tarkistaKategoria(kategoria)) {
            this.kategoria = kategoria;
        } else {
            this.kategoria = "ei määritelty";
        }
    }

    public Resepti(String nimi) {
        this.nimi = nimi;
        vaikeusaste = 0;
        kategoria = "ei määritelty";
    }

    private void tarkistaVaikeusaste(int vaikeusaste) {

        if (vaikeusaste <= 1) {
            this.vaikeusaste = 1;
        } else if (vaikeusaste >= 5) {
            this.vaikeusaste = 5;
        } else {
            this.vaikeusaste = vaikeusaste;
        }
    }

    private boolean tarkistaKategoria(String kategoria) {
        if (kategoria == "liha" || kategoria == "kala" || kategoria == "kana"
                || kategoria == "kasvis" || kategoria == "herkut") {
            return true;
        }
        return false;
    }

    public void vaihdaKategoria(String kategoria) {
        if (tarkistaKategoria(kategoria)) {
            this.kategoria = kategoria;
        } else {
            this.kategoria = "ei määritelty";
        }
    }

    public void vaihdaVaikeusaste(int vaikeusaste) {
        tarkistaVaikeusaste(vaikeusaste);
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

    public void lisaaRaakaaine(Raakaaine aine) {

        raakaaineet.add(aine);
    }
    
    public void lisaaVaihe(Ohje vaihe){
    
        tyovaiheet.add(vaihe);
    }

    public String toString() {
        return  nimi + "\n" + "kategoria: " + kategoria + "\n" + "vaikeusaste:"
                + " " + vaikeusaste + "\n" + raakaaineet + "\n" +tyovaiheet;
    }
}

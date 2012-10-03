package sovelluslogiikka;

import java.util.*;

public class Resepti {

    String nimi;
    int vaikeusaste;
    String kategoria;
    ArrayList<Raakaaine> raakaaineet = new ArrayList<>();
    ArrayList<Ohje> tyovaiheet = new ArrayList<>();

    /**
     * luo resepti olion
     *
     * @param nimi käyttäjän antama reseptin nimi
     * @param vaikeusaste käyttäjän antama vaikeusaste reseptille
     * @param kategoria käyttäjän antama kategoria
     */
    public Resepti(String nimi, int vaikeusaste, String kategoria) {

        this.nimi = nimi;

        tarkistaVaikeusaste(vaikeusaste);

        if (tarkistaKategoria(kategoria)) {
            this.kategoria = kategoria;
        } else {
            this.kategoria = "ei määritelty";
        }
    }

    /**
     * luo resepti olion
     *
     * @param nimi käyttäjän antama reseptin nimi
     */
    public Resepti(String nimi) {
        this.nimi = nimi;
        vaikeusaste = 0;
        kategoria = "ei määritelty";
    }

    /**
     * tarkistaa, että reseptin vaikeusaste on välillä 1-5. Jos yritetään antaa
     * välille sopimatonta vaikeusastetta korjataan se oikeaksi.
     *
     * @param vaikeusaste käyttäjän antama vaikeusaste
     */
    private void tarkistaVaikeusaste(int vaikeusaste) {

        if (vaikeusaste <= 1) {
            this.vaikeusaste = 1;
        } else if (vaikeusaste >= 5) {
            this.vaikeusaste = 5;
        } else {
            this.vaikeusaste = vaikeusaste;
        }
    }

    /**
     * tarkistetaan, että käyttäjän antama kategoria on kelvollinen
     *
     * @param kategoria käyttäjän antama tieto
     * @return hyväksyy tai hylkää
     */
    private boolean tarkistaKategoria(String kategoria) {
        if (kategoria.equals("liha") || kategoria.equals("kala") || kategoria.equals("kana")
                || kategoria.equals("kasvis") || kategoria.equals("herkut")) {
            return true;
        }
        return false;
    }

    /**
     * vaihdetaan reseptin kategoria halutuksi
     *
     * @param kategoria käyttäjän antama tieto
     */
    public void vaihdaKategoria(String kategoria) {
        if (tarkistaKategoria(kategoria)) {
            this.kategoria = kategoria;
        } else {
            this.kategoria = "ei määritelty";
        }
    }

    /**
     * vaihdetaan reseptin vaikeusate halutuksi
     *
     * @param vaikeusaste käyttäjän antama tieto
     */
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

    /**
     * lisätään reseptille raaka-aine
     *
     * @param aine käyttäjän antama tieto, Raakaaine olion nimi
     */
    public void lisaaRaakaaine(Raakaaine aine) {

        raakaaineet.add(aine);
    }

    /**
     * poistetaan raaka-aine reseptiltä
     * 
     * @param aine käyttäjän antama tieto, Raakaaine olion nimi
     */
    public void poistaRaakaaine(Raakaaine aine) {

        if (raakaaineet.contains(aine)) {
            raakaaineet.remove(aine);
        }
    }

    /**
     * haetaan haluttu raaka-aine
     * @param nimi käyttäjän antama tieto
     * @return 
     */
    public boolean onkoRaakaainetta(Raakaaine nimi) {

        if (raakaaineet.contains(nimi)) {
            return true;
        } else {
            return false;
        }
    }

    public boolean onkoRaakaaineita(Raakaaine aine, Raakaaine toinenAine) {

        if (raakaaineet.contains(aine) || raakaaineet.contains(toinenAine)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * lisätään reseptille ohjeen tekovaihe
     *
     * @param vaihe käyttäjän antama tieto,Ohje olion nimi
     */
    public void lisaaVaihe(Ohje vaihe) {

        tyovaiheet.add(vaihe);
    }

    public String toString() {
        return "\n" + "\n" + "nimi: " + nimi + "\n" + "kategoria: " + kategoria + "\n" + "vaikeusaste:"
                + " " + vaikeusaste + "\n" + raakaaineet + "\n" + tyovaiheet;
    }
}

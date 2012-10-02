package sovelluslogiikka;

//sisältää reseptit
//Admin voi lisätä, poistaa ja muokata reseptejä
import java.util.*;
import java.io.*;

public class Keittokirja {

    ArrayList<Resepti> kirja = new ArrayList<Resepti>();

    public Keittokirja() {
    }
    
    public void tulosta(){
        for (Resepti nimi : kirja){
            System.out.println(nimi);
        }
    }
    
    public void tallenna(String tiedostonimi){
        try{
            PrintWriter kirjoittaja = new PrintWriter(new File(tiedostonimi));
            for (Resepti nimi : kirja){
            kirjoittaja.println(nimi);
            }   
            kirjoittaja.close();
        }catch (Exception e){
            System.out.println("Virhe tallentamisessa");
        }
    }
    
    public void lataa(String tiedostonimi){
        try{
        Scanner lukija = new Scanner(new File(tiedostonimi));
        kirja.clear();
        int reseptimaara = Integer.parseInt(lukija.nextLine());
        for (int i = 0; i < reseptimaara; i++){
            String nimi = lukija.nextLine();
            //kirja.add(nimi);
        }
        }catch (Exception e){
            System.out.println("Virhe lataamisessa!");
        }
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

        for (Resepti nimi : kirja) {
            if (nimi.haeKategoria().equals(kategoria)) {
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

        for (Resepti nimi : kirja) {
            if (nimi.haeKategoria().equals(kategoria) && nimi.haeVaikeusaste() == (vaikeusaste)) {
                molemmat.add(nimi);
            }
        }
        return molemmat;
    }

    /**
     * Etsitään reseptit joissa on haluttua raaka-ainetta
     * @param raakaaine käyttäjän antama tieto
     * @return palauttaa listan resepteistä joissa on ko raaka-ainetta
     */
    public ArrayList<Resepti> haeReseptitJoissaRaakaainetta(Raakaaine raakaaine) {

        ArrayList<Resepti> aine = new ArrayList<Resepti>();

        for (Resepti nimi : kirja) {
            if (nimi.onkoRaakaainetta(raakaaine)) {
                aine.add(nimi);
            }
        }
        return aine;
    }
    
    /**
     * Etsitään reseptit joissa ei ole haluttua raaka-ainetta
     * @param raakaaine käyttäjän antama tieto
     * @return palauttaa listan resepteistä joissa ei ole ko raaka-ainetta
     */
    public ArrayList<Resepti> haeReseptitIlmanRaakaainetta(Raakaaine raakaaine) {

        ArrayList<Resepti> ilmanainetta = new ArrayList<Resepti>();

        for (Resepti nimi : kirja) {
            if (!nimi.onkoRaakaainetta(raakaaine)) {
                ilmanainetta.add(nimi);
            }
        }
        return ilmanainetta;
    }
    
    /**
     * haetaan reseptit joissa ei ole ko raaka-aineita
     * @param nimi käyttäjän antama tieto
     * @param toinenNimi käyttäjän antama tieto
     * @return palauttaa listan resepteistä joissa ei ole ko raaka-aineita
     */
    public ArrayList<Resepti> haeReseptitIlmanRaakaaineita(Raakaaine nimi, Raakaaine toinenNimi){
    
        ArrayList<Resepti> ilmanAineita = new ArrayList<Resepti>();
        
        for (Resepti reseptinnimi : kirja){
            if (!reseptinnimi.onkoRaakaaineita(nimi, toinenNimi)){
                ilmanAineita.add(reseptinnimi);
            }
        }
        return ilmanAineita;
    }

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

    public String ToString() {
        return "" + kirja;
    }
}

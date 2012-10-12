package sovelluslogiikka;


import java.util.*;
import java.io.*;

public class Keittokirja implements Serializable {

    ArrayList<Resepti> kirja = new ArrayList<>();

    public Keittokirja() {
    }

    public void tulosta() {
        for (Resepti nimi : kirja) {
            System.out.println(nimi);
        }
    }

    public void tallenna() {
        try {
            FileOutputStream fileOut = new FileOutputStream("valmistusohjeet.dat");
            ObjectOutputStream objOut = new ObjectOutputStream(fileOut);
            objOut.writeObject(this);
            objOut.close();

        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());
        }
    }

    public static Keittokirja lue() throws IOException {
        Keittokirja ki = null;
        try {
            FileInputStream fileIn = new FileInputStream("valmistusohjeet.dat");
            ObjectInputStream objIn = new ObjectInputStream(fileIn);
            try {
                ki = (Keittokirja) objIn.readObject();
            } catch (ClassNotFoundException cnfe) {
                cnfe.printStackTrace();
            }
            objIn.close();
        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());
            throw ioe;
        }
        return ki;
        
    }

    public String[] haeReseptienNimet() {
        
        String[] nimet = new String[kirja.size()];
        int i = 0;
        for (Resepti nimi : kirja) {
              nimet[i] = kirja.get(i).nimi;
              i++;
            }
        return nimet;
    }


    /**
     * etsitään haluttu resepti keittokirjasta reseptin nimen avulla
     * @param reseptin_nimi, käyttäjän antama reseptin nimi
     * @return haluttu resepti
     */
    public ArrayList<Resepti> haeResepti(String reseptin_nimi) {

        ArrayList<Resepti> nimet = new ArrayList<>();

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

        ArrayList<Resepti> kategorialista = new ArrayList<>();

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

        ArrayList<Resepti> molemmat = new ArrayList<>();

        for (Resepti nimi : kirja) {
            if (nimi.haeKategoria().equals(kategoria) && nimi.haeVaikeusaste() == (vaikeusaste)) {
                molemmat.add(nimi);
            }
        }
        return molemmat;
    }
    
    public Resepti palautaResepti(int nro){
        if ((kirja.size() < 1)||(nro > kirja.size()))
        {
            return null;
        }
        return kirja.get(nro);
    }

    /**
     * Etsitään reseptit joissa on haluttua raaka-ainetta
     * @param raakaaine käyttäjän antama tieto
     * @return palauttaa listan resepteistä joissa on ko raaka-ainetta
     */
    public ArrayList<Resepti> haeReseptitJoissaRaakaainetta(Raakaaine raakaaine) {

        ArrayList<Resepti> aine = new ArrayList<>();

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

        ArrayList<Resepti> ilmanainetta = new ArrayList<>();

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
    public ArrayList<Resepti> haeReseptitIlmanRaakaaineita(Raakaaine nimi, Raakaaine toinenNimi) {

        ArrayList<Resepti> ilmanAineita = new ArrayList<>();

        for (Resepti reseptinnimi : kirja) {
            if (!reseptinnimi.onkoRaakaaineita(nimi, toinenNimi)) {
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
    }

    /**
     * lisaaResepti lisätään keittokirjaan haluttu resepti
     * @param resepti käyttäjän antama syöte
     */
    public void lisaaResepti(Resepti resepti) {
        kirja.add(resepti);
    }

    public String ToString() {
        return "" + kirja;
    }

    
}

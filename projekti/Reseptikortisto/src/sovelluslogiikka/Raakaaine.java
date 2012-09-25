package sovelluslogiikka;


public class Raakaaine {

    private String nimi;
    private String laatu;
    private double maara;

    /**
     * Luodaan Raakaaine olio 
     * @param nimi käyttäjän antama raaka-aineen nimi
     */
    public Raakaaine(String nimi) { 
        this.nimi = nimi;
        laatu = "?";
        maara = 0;
    }

    /**
     * luodaan Raakaaine olio
     * @param nimi käyttäjän antama raaka-aineen nimi
     * @param laatu käyttäjän antama määrän laatu esim. g, dl, tl
     * @param maara kuinka paljon raaka-ainetta tarvitaan
     */
    public Raakaaine(String nimi, String laatu, double maara) {
        //Konstruktorilla luodaan olio jolle annetaan nimi,
        //tarvittava määrä ja määrän laatuyksikkö
        this.nimi = nimi;
        if (tarkistaLaatu(laatu)) {
            this.laatu = laatu;
        } else {
            this.laatu = "?";
        }

        if (tarkistaMaara(maara)){
            this.maara = maara;
        } else {
            this.maara = 0;
        }
    }

    /** 
     * korjataan väärin kirjoitetun raaka-aineen nimi
     * @param nimi käyttäjän antama raaka-aineen nimi
     */
    public void korjaaNimi(String nimi) {
        this.nimi = nimi;
    }

    /**
     * korjataan / vaihdetaan tarvittavan raaka-aineen määrän laatuyksikkö 
     * oikeaksi
     * @param laatu käyttäjän antama laadun tieto 
     */
    public void korjaaLaatu(String laatu) {
        if (tarkistaLaatu(laatu)) {
            this.laatu = laatu;
        } else {
            this.laatu = "?";
        }
    }

    /**
     * korjataana tarvittavan raaka-aineen määrä oikeaksi
     * @param maara käyttäjän antama raaka-aineen oikea määrä 
     */
    public void korjaaMaara(double maara) {
        if (tarkistaMaara(maara)) {
            this.maara = maara;
        } else {
            this.maara = 0;
        }
    }

    /**
     * tarkistetaan annetun laadun kelvollisuus
     * @param laatu käyttäjän antama tieto 
     * @return hyväksyy tai hylkää annetun tiedon
     */
    private boolean tarkistaLaatu(String laatu) {
        if (laatu.equals("g") || laatu.equals("kg") || laatu.equals("dl") || laatu.equals("l")
                || laatu.equals("rkl") || laatu.equals("tl") || laatu.equals("kpl")) {
            return true;
        }
        return false;
    }

    /**
     * tarkistetaan, että käyttäjän antama määrä on sallitulla välillä
     * @param maara käyttäjän antama tieto
     * @return hvyäksyy tai hylkää
     */
    private boolean tarkistaMaara(double maara) {
        if (maara >= 1 && maara <= 1000) {
            return true;
        }
        return false;
    }
    
    public String haeNimi(){
        return nimi;
    }
    
    public String haeLaatu(){
        return laatu;
    }
    
    public double haeMaara(){
    return maara;
    }

    public String toString() {
        return maara + " " + laatu + " " + nimi;
    }
}

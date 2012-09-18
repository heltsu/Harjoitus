
public class Raakaaine {

    private String nimi;
    private String laatu;
    private double maara;

    public Raakaaine(String nimi) {
        //Konstruktori luo olion jolle on annettu vain nimi
        this.nimi = nimi;
        laatu = "?";
        maara = 0;
    }

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

    public void korjaaNimi(String nimi) {
        //metodilla voidaan korjata väärin kirjoitetun ainesosan nimi
        this.nimi = nimi;
    }

    public void korjaaLaatu(String laatu) {
        //metodilla voidaan korjata / vaihtaa tarvittavan ainesosan määrän 
        //laatuyksikkö oikeaksi
        if (tarkistaLaatu(laatu)) {
            this.laatu = laatu;
        } else {
            this.laatu = "?";
        }
    }

    public void korjaaMaara(double maara) {
        //metodilla voidaan korjata tarvita määrä oikeaksi
        if (tarkistaMaara(maara)) {
            this.maara = maara;
        } else {
            this.maara = 0;
        }
    }

    private boolean tarkistaLaatu(String laatu) {
        //tarkistetaan, että annettu laatu on kelvollinen
        if (laatu == "g" || laatu == "kg" || laatu == "dl" || laatu == "l"
                || laatu == "rkl" || laatu == "tl" || laatu == "kpl") {
            return true;
        }
        return false;
    }

    private boolean tarkistaMaara(double maara) {
        //tarkistetaan, että annettu määrä on kelvollinen
        if (maara >= 1 && maara <= 20) {
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

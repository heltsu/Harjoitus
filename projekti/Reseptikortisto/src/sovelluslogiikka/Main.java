package sovelluslogiikka;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author heli
 */
public class Main {
public static void main (String[] args){
    
    Keittokirja kirja = new Keittokirja();
//    Tekstikayttoliittyma tk = new Tekstikayttoliittyma(kirja);
//    GraafinenOhjelma gk = new GraafinenOhjelma();
//    gk.run();
    

Keittokirja keittokirja = new Keittokirja(); 
Resepti uuniomena = new Resepti("Uuniomenat", 2, "kala"); 
Resepti uuniomena2 = new Resepti ("Uuniomenat", 3, "herkut");
Resepti silakkapihvit = new Resepti ("Silakkapihvit", 2, "kala");
Raakaaine omena = new Raakaaine ("omenaa",  "kpl", 2);
Raakaaine sokeri = new Raakaaine ("sokeria", "dl", 2.5);
Raakaaine silakka = new Raakaaine ("silakoita", "g", 600);
        
        uuniomena.lisaaRaakaaine(omena);
        uuniomena.lisaaRaakaaine(sokeri);
        uuniomena2.lisaaRaakaaine(omena);
        uuniomena2.lisaaRaakaaine(sokeri);
        silakkapihvit.lisaaRaakaaine(silakka);
        
Ohje omenaohje = new Ohje("Kuori ja paloittele omenat"); 
uuniomena.lisaaVaihe(omenaohje);
uuniomena2.lisaaVaihe(omenaohje);
Ohje omenaohje1 = new Ohje("laita omenat ja sokeri kulhoon");
Ohje omenaohje2 = new Ohje("laita kulho uuniin");
uuniomena.lisaaVaihe(omenaohje1);
uuniomena2.lisaaVaihe(omenaohje1);
uuniomena2.lisaaVaihe(omenaohje2);
keittokirja.lisaaResepti(uuniomena);
keittokirja.lisaaResepti(uuniomena2);
keittokirja.lisaaResepti(silakkapihvit);
uuniomena.haeRaakaaine("omenaa");
       
       
        
       // uuniomena.vaihdaKategoria("herkut");
      //  System.out.println(keittokirja.kirja);
        
        
      //  System.out.println(keittokirja.haeResepti("Uuniomenat"));
       // System.out.println(keittokirja.haeReseptit("kala"));
    //System.out.println(keittokirja.haeReseptit("kala", 2));
    
    System.out.println(uuniomena.haeRaakaaine("omena"));
       
    }
}

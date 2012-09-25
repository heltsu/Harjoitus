package sovelluslogiikka;

import sovelluslogiikka.Resepti;
import sovelluslogiikka.Keittokirja;
import java.util.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
/**
 *
 * @author heli
 */
public class KeittokirjaTest {
    ArrayList<Resepti> kirja = new ArrayList<Resepti>();
    Keittokirja herkut;
    Keittokirja herkut1;
    Resepti kanavartaat;
    Resepti kalapuikot;
    Resepti kala;
    Resepti pippuripihvi;
    Resepti kanapullat;
    Resepti marjaherkku;
    
    
    public KeittokirjaTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    
    @Before    
    
    public void setUp() {
    herkut = new Keittokirja();
    herkut1 = new Keittokirja();
    kanavartaat = new Resepti("kanavartaat", 5, "kana");
    kalapuikot = new Resepti ("kalapuikot", 2, "kala");
    pippuripihvi = new Resepti ("pippuripihvi", 5, "liha");
    kanapullat = new Resepti ("kanapullat", 5, "kana");
    marjaherkku = new Resepti ("marjaherkku", 3, "herkut");
    
    }
    
    @After
    public void tearDown() {
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void hello() {}
     
    @Test
    public void testToimiikoLisaaResepti(){
       herkut.lisaaResepti(kanavartaat);
       assertEquals(herkut.haeResepti("kanavartaat"), herkut.kirja);   
    }
    
    @Test 
     public void testToimiikoPoistaResepti(){
        herkut.poistaResepti(kanavartaat);
        assertEquals(herkut.haeResepti("kanavartaat"), herkut.kirja);
    }
    
    
    @Test
    public void testToimiikoHaeResepti(){
        assertEquals(herkut.haeResepti("kalapuikot"), herkut.kirja);
    }  
    
   @Test
    public void testToimiikoHaeReseptiLaatu(){
        herkut1.lisaaResepti(kalapuikot);
        assertEquals (herkut1.haeReseptit("kala"), herkut1.kirja);
    }
   @Test
   public void testToimiikoHaeReseptitLaatuVaikeusaste(){
       herkut1.lisaaResepti(kanavartaat);
       assertEquals (herkut1.haeReseptit("kana", 5), herkut1.kirja);
   }
   
   @Test
   public void testToimiikoHaeReseptitLaatuVaikeusaste1(){
       herkut1.lisaaResepti(marjaherkku);
       assertEquals(herkut1.haeReseptit("herkut", 3), herkut1.kirja);
   }
   
   @Test
   public void testToimiikoLisaaResepti1(){
       herkut.lisaaResepti(marjaherkku);
       assertEquals(herkut.haeResepti("marjaherkku"), herkut.kirja);
   }
}

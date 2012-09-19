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
    kanavartaat = new Resepti("kanavartaat");
    kalapuikot = new Resepti ("kalapuikot", 2, "kala");
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
       assertTrue(herkut.loytyykoResepti(kanavartaat));
    }
    
    @Test 
     public void testToimiikoPoistaResepti(){
        herkut.poistaResepti(kanavartaat);
        assertFalse(herkut.loytyykoResepti(kanavartaat));
    }
    
    
    @Test
    public void testToimiikoHaeResepti(){
        assertFalse(herkut.haeResepti(kalapuikot));
    }  
    
  /*  @Test
    public void testToimiikoHaeReseptiLaatu(){
        assertEquals (herkut.haeReseptit(kala), true);
    }*/
}

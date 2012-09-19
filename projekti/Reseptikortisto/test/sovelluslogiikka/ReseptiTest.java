package sovelluslogiikka;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

//import sovelluslogiikka.Resepti;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author hniemima
 */
public class ReseptiTest {
    Resepti resepti;
    Resepti resepti1;
    
    public ReseptiTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        resepti = new Resepti ("kanavartaat", 6, "kana");
        resepti1 =new Resepti ("kalapuikot");
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
     public void testToimiikoHaeNimi(){
        assertEquals (resepti.haeNimi(), "kanavartaat");     
    }
    @Test
    public void testToimiikoHaeNimi1(){
        assertEquals (resepti1.haeNimi(), "kalapuikot");
    }
    
    @Test
    public void testToimiikoHaeVaikeusaste(){
        assertEquals (resepti.haeVaikeusaste(), 5);  
    }
    
    @Test
    public void testToimiikoHeVaikeusaste1(){
        assertEquals (resepti1.haeVaikeusaste(), 0);
    }
    
    @Test
    public void testToimiikoHaeKategoria(){
        assertEquals (resepti.haeKategoria(), "kana");
    }
    
    @Test
    public void testToimiikoHaeKategoria1(){
        assertEquals (resepti1.haeKategoria(), "ei määritelty");   
    }
   
    
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

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
public class RuokakortistoTest {
    Ruokakortisto ruokakortisto;
    
    public RuokakortistoTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        ruokakortisto = new Ruokakortisto ("kanavartaat", 6, "kana");
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
        assertEquals (ruokakortisto.haeNimi(), "kanavartaat");
    }
    
    @Test
    public void testToimiikoHaeVaikeusaste(){
        assertEquals (ruokakortisto.haeVaikeusaste(), 5);
    }
    
    @Test
    public void testToimiikoHaeKategoria(){
        assertEquals (ruokakortisto.haeKategoria(), "kana");
    }
    
    @Test
    public void testToimiikoLisaaResepti(){
        ruokakortisto.lisaaResepti("kanavartaat");
        assertEquals (ruokakortisto.haeResepti("kanavartaat"), true);
    }
    
    @Test
    public void testToimiikoHaeResepti(){
        
    }
}

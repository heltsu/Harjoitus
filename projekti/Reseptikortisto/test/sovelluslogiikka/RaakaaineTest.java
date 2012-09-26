package sovelluslogiikka;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import sovelluslogiikka.Raakaaine;
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
public class RaakaaineTest {

    Raakaaine raakaaine;
    Raakaaine raakaaine1;
    Raakaaine raakaaine2;

    public RaakaaineTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        raakaaine = new Raakaaine("omena", "kpl", 2);
        raakaaine1 = new Raakaaine("sokeri", "dl", 2.5);
        raakaaine2 = new Raakaaine("jauheliha", "g", 500);
    }

    @After
    public void tearDown() {
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //

    @Test
    public void hello() {
    }

    @Test
    public void toimiikoKorjaaNimi() {
        raakaaine.korjaaNimi("porkkana");
        assertEquals(raakaaine.haeNimi(), "porkkana");
    }

    @Test
    public void toimiikoKorjaaLaatu() {
        raakaaine.korjaaLaatu("klp");
        assertEquals(raakaaine.haeLaatu(), "?");
    }

    @Test
    public void toimiikoKorjaaLaatu1() {
        raakaaine1.korjaaLaatu("dl");
        assertEquals(raakaaine1.haeLaatu(), "dl");
    }

    @Test
    public void toimiikoKorjaaMaara() {
        raakaaine.korjaaMaara(2);
        assertEquals(2, raakaaine.haeMaara(), 0.001);
    }

    @Test
    public void toimiikoKorjaaMaara1() {
        raakaaine1.korjaaMaara(1001);
        assertEquals(0, raakaaine1.haeMaara(), 0.001);
    }

    @Test
    public void toimiikoKorjaaMaara2() {
        raakaaine.korjaaMaara(-2);
        assertEquals(0, raakaaine.haeMaara(), 0.001);
    }

    @Test
    public void toimiikoMaarallaOikeaLaatu() {
        raakaaine.korjaaMaara(25);
        assertEquals(0, raakaaine.haeMaara(), 0.001);
    }

    @Test
    public void toimiikoMaarallaOikeaLaatu1() {
        raakaaine2.korjaaMaara(1000);
        assertEquals(0, raakaaine2.haeMaara(), 0.001);
    }

    @Test
    public void toimiikoMaarallaOikeaLaatu2() {
        raakaaine2.korjaaMaara(999);
        assertEquals(999, raakaaine2.haeMaara(), 0.001);
    }
    @Test
    public void toimiikoMaarallaOikeaLaatu3(){
        raakaaine2.korjaaMaara(-5);
        assertEquals(0, raakaaine2.haeMaara(), 0.001);
        }
}
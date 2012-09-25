/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kayttoliittyma;
import javax.swing.SwingUtilities;

/**
 *
 * @author heli
 */
public class Main {

    public static void main (String[] args){      
    
        GraafinenKayttoliittyma testi = new GraafinenKayttoliittyma();
        //testi.run();
        SwingUtilities.invokeLater(testi);
    }
}

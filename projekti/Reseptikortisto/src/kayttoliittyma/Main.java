/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kayttoliittyma;

import javax.swing.SwingUtilities;
import sovelluslogiikka.*;

/**
 *
 * @author heli
 */
public class Main {

    public static void main(String[] args) {

        Keittokirja kirja;
        kirja = Keittokirja.lue();

        GraafinenKayttoliittyma testi = new GraafinenKayttoliittyma(kirja);
        testi.run();
//        SwingUtilities.invokeLater(testi);
    }
}

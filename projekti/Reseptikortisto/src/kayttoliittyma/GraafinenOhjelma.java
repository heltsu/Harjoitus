package kayttoliittyma;

import java.awt.*;
import javax.swing.*;

public class GraafinenOhjelma implements Runnable {
    private JFrame ikkuna;
    
    public void run(){
        ikkuna = new JFrame("GraafinenOhjelma");
        ikkuna.setPreferredSize(new Dimension(300, 150));
        
        ikkuna.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        ikkuna.pack();
        ikkuna.setVisible(true);
    }
    
}

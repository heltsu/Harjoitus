package kayttoliittyma;

//import javax.swing.JFrame;
import javax.swing.*;
//import javax.swing.JLabel;
//import javax.swing.JButton;
import java.awt.*;
//import java.awt.Container;
//import java.awt.Dimension;
//import javax.swing.WindowConstants;

public class GraafinenKayttoliittyma implements Runnable {

    private JFrame ikkuna;

    public GraafinenKayttoliittyma() {
    }

    public void run() {
        ikkuna = new JFrame("Keittokirja");
        ikkuna.setPreferredSize(new Dimension(700, 800));

        ikkuna.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        luoKomponentit(ikkuna.getContentPane());

        ikkuna.pack();
        ikkuna.setVisible(true);
    }

    private void luoKomponentit(Container container) {
        
        container.add(valikko(), BorderLayout.WEST);
        container.add(otsikko(), BorderLayout.NORTH);    
        container.add(alaOsa(), BorderLayout.SOUTH);
    }

    private JPanel valikko() {
        JPanel panel = new JPanel(new GridLayout(14, 1));
        
        JRadioButton kala = new JRadioButton("Kala");
        JRadioButton liha = new JRadioButton("Liha");
        JRadioButton kana = new JRadioButton("Kana");
        JRadioButton herkut = new JRadioButton("Herkut");
        JRadioButton yksi = new JRadioButton("1");
        JRadioButton kaksi = new JRadioButton("2");
        JRadioButton kolme = new JRadioButton("3");
        JRadioButton nelja = new JRadioButton("4");
        JRadioButton viisi = new JRadioButton("5");

        ButtonGroup nappulat = new ButtonGroup();
        nappulat.add(yksi);
        nappulat.add(kaksi);
        nappulat.add(kolme);
        nappulat.add(nelja);
        nappulat.add(viisi);
        
        ButtonGroup nippulat = new ButtonGroup();
        nippulat.add(kala);
        nippulat.add(liha);
        nippulat.add(kana);
        nippulat.add(herkut);
        
        JLabel teksti1 = new JLabel("Nimi");
        JLabel teksti = new JLabel("Kategoria");
        JLabel teksti2 = new JLabel("Vaikeusaste");
        
        JTextField nimiKentta = new JTextField();
        
        JButton hae = new JButton("Hae");
        
        panel.add(teksti1);
        panel.add(nimiKentta);
        panel.add(teksti);
        panel.add(kala);
        panel.add(liha);
        panel.add(kana);
        panel.add(herkut);
        panel.add(teksti2);
        panel.add(yksi);
        panel.add(kaksi);
        panel.add(kolme);
        panel.add(nelja);
        panel.add(viisi);
        panel.add(hae);
        return panel;

    }
    private JPanel otsikko(){
        JPanel otsikko = new JPanel(new FlowLayout());
        JLabel keittokirja = new JLabel("Keittokirja");
        otsikko.add(keittokirja);
        return otsikko;
    }
    
    private JPanel alaOsa(){
        JPanel alaOsa = new JPanel(new GridLayout(3, 2));
        
        JRadioButton lisaa = new JRadioButton("Lisaa resepti");
        JRadioButton poista = new JRadioButton("Poista resepti");
        JRadioButton muokkaa = new JRadioButton("Muokkaa reseptiä");
        
        ButtonGroup puttonit = new ButtonGroup();
        puttonit.add(lisaa);
        puttonit.add(poista);
        puttonit.add(muokkaa);
        
        JLabel omistaja = new JLabel("Nimi");
        JTextField omistajan_nimi = new JTextField();
        JButton kirjaudu = new JButton("kirjaudu / poistu");
        
        alaOsa.add(omistaja);
        alaOsa.add(lisaa);
        alaOsa.add(omistajan_nimi);
        alaOsa.add(poista);
        alaOsa.add(kirjaudu);
        alaOsa.add(muokkaa);
        
        return alaOsa;
    }

    public JFrame getFrame() {
        return ikkuna;
    }
}

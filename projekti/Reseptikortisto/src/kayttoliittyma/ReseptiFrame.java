package kayttoliittyma;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.event.*;
import sovelluslogiikka.*;
import java.util.*;

public class ReseptiFrame extends JFrame {

    JMenuBar jMenuBar = new JMenuBar();
    JMenu jMenuFile = new JMenu();
    JMenuItem jMenuFileExit = new JMenuItem();
    JMenu jMenuHelp = new JMenu();
    JMenuItem jMenuHelpAbout = new JMenuItem();
    
    JToolBar jToolBar = new JToolBar();
     
    BorderLayout borderLayout1 = new BorderLayout();
    
    JPanel alaosa = new JPanel();
    JButton poista = new JButton("Poista resepti");
    JButton muokkaa = new JButton("Muokkaa reseptiä");
    JButton lisaa = new JButton("Lisää resepti");
    
    JSplitPane jSplitPane1 = new JSplitPane();   
    
    JPanel vasenPohja = new JPanel();
    BorderLayout borderLayout6 = new BorderLayout();

    JScrollPane jScrollPaneLista = new JScrollPane();    
    JList jList = new JList();

    JPanel oikeaPohja = new JPanel();
    GridLayout GridLayout2 = new GridLayout(3,1);
    
    JPanel reseptiLomake = new JPanel();
    GridLayout gridLayout3 = new GridLayout(3,2);
    JTextField reseptinimi = new JTextField();
    JLabel resepti = new JLabel("");
    JLabel kategoria = new JLabel("Kategoria");
    JTextField kategorianimi = new JTextField();
    JLabel vaikeusaste  = new JLabel("Vaikeusaste");
    JTextField vaikeusastenimi = new JTextField();

    JPanel raakaaineLomake = new JPanel();    
    BorderLayout borderLayout4 = new BorderLayout();
    JScrollPane raakaaine = new JScrollPane();
    JEditorPane raakaainePane = new JEditorPane();

    JPanel ohjeLomake = new JPanel();
    BorderLayout borderLayout3 = new BorderLayout();
    JScrollPane ohje = new JScrollPane();
    JEditorPane ohjePane = new JEditorPane();
    

    public ReseptiFrame(Kuuntelija kuuntelija, Keittokirja kirja) {

        Container contentPane = this.getContentPane();

        contentPane.setLayout(borderLayout1);
        contentPane.add(jToolBar, BorderLayout.NORTH);
        contentPane.add(jSplitPane1, BorderLayout.CENTER);
        contentPane.add(alaosa, BorderLayout.SOUTH);

        alaosa.add(poista);
        lisaa.addActionListener(kuuntelija);

        alaosa.add(muokkaa);
        poista.addActionListener(kuuntelija);
        
        alaosa.add(lisaa);      
        poista.addActionListener(kuuntelija);

        jSplitPane1.add(jScrollPaneLista, JSplitPane.LEFT);
        jSplitPane1.add(oikeaPohja, JSplitPane.RIGHT);
        jSplitPane1.setDividerLocation(150);
        
        jScrollPaneLista.getViewport().add(jList);
        jScrollPaneLista.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        String[] lista = kirja.haeReseptienNimet();
        
        jList.setListData(lista);
        jList.setSelectedIndex(0);
        
        jList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        //Lisätään oikeanpuoleiseen osaan ...
        oikeaPohja.setLayout(GridLayout2);
        oikeaPohja.add(reseptiLomake);
        oikeaPohja.add(raakaaineLomake);
        oikeaPohja.add(ohjeLomake);

        reseptiLomake.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.RAISED), "Resepti"));
        reseptiLomake.setLayout(gridLayout3);
        reseptiLomake.add(reseptinimi);
        reseptiLomake.add(resepti);
        reseptiLomake.add(kategoria);
        reseptiLomake.add(kategorianimi);
        reseptiLomake.add(vaikeusaste);
        reseptiLomake.add(vaikeusastenimi);

        raakaaineLomake.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.RAISED), "Raakaaine"));
        raakaaineLomake.setLayout(borderLayout4);
        raakaaineLomake.add(raakaaine,  BorderLayout.CENTER);
        raakaaine.getViewport().add(raakaainePane);
        raakaainePane.setContentType("text/html");
        raakaainePane.setEditable(false);   
        raakaainePane.setText("Kalle");

        ohjeLomake.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.RAISED), "Ohje"));
        ohjeLomake.setLayout(borderLayout3);
        ohjeLomake.add(ohje,  BorderLayout.CENTER);
        ohje.getViewport().add(ohjePane);
        ohjePane.setContentType("text/html");
        ohjePane.setEditable(false);  
        ohjePane.setText("Ville");

        
        //Määritellään valikkohierarkia.
        jMenuBar.add(jMenuFile);
        jMenuBar.add(jMenuHelp);
        jMenuFile.setText("Tiedosto");
        jMenuFile.add(jMenuFileExit);

        //Asetetaan ikkunan valikkorivi.
        this.setJMenuBar(jMenuBar);

        //Asetetaan ikkunan ominaisuudet
        this.setTitle("Keittokirja");

    }
}

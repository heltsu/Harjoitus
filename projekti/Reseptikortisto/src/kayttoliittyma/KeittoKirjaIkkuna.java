package kayttoliittyma;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.event.*;
import sovelluslogiikka.*;
import java.util.*;

public class KeittoKirjaIkkuna extends JFrame {

    Kuuntelija kki_kuuntelija;

    JMenuBar jMenuBar = new JMenuBar();
    JMenu jMenuFile = new JMenu();
    JMenuItem menuTallenna = new JMenuItem();
    JMenuItem menuPoistu = new JMenuItem();
    
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
    GridLayout gridLayout3 = new GridLayout(5,2);
    JTextField reseptinimi = new JTextField();
    JLabel resepti = new JLabel("");
    JLabel kategoria = new JLabel("Kategoria");
    JTextField kategorianimi = new JTextField();
    JLabel vaikeusaste  = new JLabel("Vaikeusaste");
    JTextField vaikeusastenimi = new JTextField();
    JEditorPane reseptiPane1 = new JEditorPane();
    JEditorPane reseptiPane2 = new JEditorPane();
    JEditorPane reseptiPane3 = new JEditorPane();

    JPanel raakaaineLomake = new JPanel();    
    BorderLayout borderLayout4 = new BorderLayout();
    JScrollPane raakaaine = new JScrollPane();
    JEditorPane raakaainePane = new JEditorPane();

    JPanel ohjeLomake = new JPanel();
    BorderLayout borderLayout3 = new BorderLayout();
    JScrollPane ohje = new JScrollPane();
    JEditorPane ohjePane = new JEditorPane();
    

    public KeittoKirjaIkkuna(Keittokirja kirja, Tapahtumankasittelija tk) {

        kki_kuuntelija = new Kuuntelija(tk);

        Container contentPane = this.getContentPane();

        contentPane.setLayout(borderLayout1);
        contentPane.add(jToolBar, BorderLayout.NORTH);
        contentPane.add(jSplitPane1, BorderLayout.CENTER);
        contentPane.add(alaosa, BorderLayout.SOUTH);

        alaosa.add(poista);
        poista.addActionListener(kki_kuuntelija);

        alaosa.add(muokkaa);
        muokkaa.addActionListener(kki_kuuntelija);
        
        alaosa.add(lisaa);      
        lisaa.addActionListener(kki_kuuntelija);

        jSplitPane1.add(jScrollPaneLista, JSplitPane.LEFT);
        jSplitPane1.add(oikeaPohja, JSplitPane.RIGHT);
        jSplitPane1.setDividerLocation(150);
        
        jScrollPaneLista.getViewport().add(jList);
        jScrollPaneLista.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        String[] lista = kirja.haeReseptienNimet();
        
        jList.setListData(lista);
        jList.setSelectedIndex(0);
        
        jList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
         jList.addListSelectionListener(kki_kuuntelija);

        //Lisätään lomakkeet oikeanpuoleiseen osaan ...
        oikeaPohja.setLayout(GridLayout2);
        oikeaPohja.add(reseptiLomake);
        oikeaPohja.add(raakaaineLomake);
        oikeaPohja.add(ohjeLomake);
        
        //Ensiksi reseptilomake 
        reseptiLomake.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.RAISED), "Resepti"));
        reseptiLomake.setLayout(gridLayout3);
      
        reseptiLomake.add(reseptinimi.add(reseptiPane1));
        reseptiLomake.add(resepti);
        reseptiPane1.setContentType("text");
        reseptiPane1.setEditable(false);
        
        reseptiLomake.add(new JLabel(""));
        reseptiLomake.add(new JLabel(""));
        
        reseptiLomake.add(kategoria);
        reseptiLomake.add(kategorianimi.add(reseptiPane2));
        reseptiPane2.setContentType("text");
        reseptiPane2.setEditable(false);
        
        reseptiLomake.add(new JLabel(""));
        reseptiLomake.add(new JLabel(""));
        
        reseptiLomake.add(vaikeusaste);
        reseptiLomake.add(vaikeusastenimi.add(reseptiPane3));
        reseptiPane3.setContentType("text");
        reseptiPane3.setEditable(false);
        
        
        //Seuraavaksi raaka-ainelomake
        raakaaineLomake.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.RAISED), "Raaka-aine"));
        raakaaineLomake.setLayout(borderLayout4);
        raakaaineLomake.add(raakaaine,  BorderLayout.CENTER);
        raakaaine.getViewport().add(raakaainePane);
        raakaainePane.setContentType("text");
        raakaainePane.setEditable(false);   
       

        ohjeLomake.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.RAISED), "Ohje"));
        ohjeLomake.setLayout(borderLayout3);
        ohjeLomake.add(ohje,  BorderLayout.CENTER);
        ohje.getViewport().add(ohjePane);
        ohjePane.setContentType("text");
        ohjePane.setEditable(false);  
        
        //Määritellään valikkohierarkia.
        jMenuBar.add(jMenuFile);
        jMenuFile.setText("Tiedosto");
        jMenuFile.add(menuTallenna);
        jMenuFile.add(menuPoistu);
        menuTallenna.setText("Tallenna");
        menuTallenna.addActionListener(kki_kuuntelija);
        menuPoistu.setText("Poistu");
        menuPoistu.addActionListener(kki_kuuntelija);
        

        //Asetetaan ikkunan valikkorivi.
        this.setJMenuBar(jMenuBar);

        //Asetetaan ikkunan ominaisuudet
        this.setTitle("Keittokirja");
        
    }
    
    public void run() {
        this.setPreferredSize(new Dimension(700, 800));

        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        this.pack();
        this.setVisible(true);
    }

}

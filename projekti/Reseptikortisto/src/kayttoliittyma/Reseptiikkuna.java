package kayttoliittyma;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.event.*;
import sovelluslogiikka.*;
import java.util.*;


public class Reseptiikkuna extends JFrame{
    private JFrame reseptinIkkuna;
    Tapahtumankasittelija tk;
    Kuuntelija kuuntelija;
    Keittokirja kirja;
    Resepti resepti;
    // tila 0 = ei tilaa, tila 1 = lisaa, tila 2 = muokkaa, tila 3 = poista
    int tila = 0;
    
        public void run() {
        reseptinIkkuna = new JFrame("Resepti");
        reseptinIkkuna.setPreferredSize(new Dimension(600, 700));

        reseptinIkkuna.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

      //  luoKomponentit(reseptinIkkuna.getContentPane());
        reseptinIkkuna.pack();
        reseptinIkkuna.setVisible(true);
    }
    
    
    JMenuBar jMenuBar = new JMenuBar();
    JMenu jMenuFile = new JMenu();
    JMenuItem jMenuFileExit = new JMenuItem();
    JMenu jMenuHelp = new JMenu();
    JMenuItem jMenuHelpAbout = new JMenuItem();
    
    BorderLayout borderLayout1 = new BorderLayout();
    
    JToolBar jToolBar = new JToolBar();
    JButton tallenna = new JButton("Tallenna resepti");
   
   
    JPanel alaosa = new JPanel();
    JLabel alateksti = new JLabel("  ");
    
    JSplitPane jSplitPane1 = new JSplitPane(); 
  
    JPanel vasenPohja = new JPanel();
    BorderLayout borderLayout6 = new BorderLayout();
    JScrollPane jScrollPaneLista = new JScrollPane();
    JList jList = new JList();
   
    JPanel oikeaPohja = new JPanel();
    GridLayout GridLayout2 = new GridLayout(3, 1);
   
    JPanel reseptinTayttoLomake = new JPanel();
    GridLayout gridLayout3 = new GridLayout(13, 3);
    JLabel reseptinnimi = new JLabel("Reseptin nimi:");
    JTextField reseptinimi = new JTextField();
    JLabel kategoria = new JLabel("Kategoria:");
    JScrollPane kategoriavalikko = new JScrollPane();
    JLabel vaikeusaste = new JLabel("Vaikeusaste:");
    JRadioButton yksi = new JRadioButton("Yksi");
    JRadioButton kaksi = new JRadioButton("Kaksi");
    JRadioButton kolme = new JRadioButton("Kolme");
    JRadioButton nelja = new JRadioButton("Neljä");
    JRadioButton viisi = new JRadioButton("Viisi");
    ButtonGroup vaikeusnappulat = new ButtonGroup();

    
    JRadioButton liha = new JRadioButton("Liha");
    JRadioButton kala = new JRadioButton("Kala");
    JRadioButton kana = new JRadioButton("Kana");
    JRadioButton kasvis = new JRadioButton("Kasvis");
    JRadioButton herkut = new JRadioButton("Herkut");
    ButtonGroup kategorinappulat = new ButtonGroup();
  
    JButton tallennaResepti = new JButton("Tallenna");
   
    JPanel raakaaineLomake = new JPanel();
    BorderLayout borderLayout3 = new BorderLayout();
    JLabel raakaainenimi = new JLabel("Raaka-aine:");
    JTextField raakaaine1 = new JTextField();
    JLabel maara = new JLabel("Määrä:");
    JTextField maara1 = new JTextField();
    JLabel yksikko = new JLabel("Yksikkö:");
    JScrollPane yksikko1 = new JScrollPane();
    JButton tallennaRaakaaine = new JButton("Tallenna");
    JEditorPane raakaainePane = new JEditorPane();
   
    JPanel ohjeLomake = new JPanel();
    BorderLayout borderLayout4 = new BorderLayout();
    JLabel annavalmistusohje = new JLabel("Anna valmistusohje");
    JScrollPane ohje = new JScrollPane();
    JButton tallennaOhje = new JButton("Tallenna");
    JEditorPane ohjePane = new JEditorPane();
    
    

    public Reseptiikkuna(Resepti res, int ti) {
        this.resepti = res;
        this.tila = ti;

        tk = new Tapahtumankasittelija(kirja, reseptinIkkuna);
        kuuntelija = new Kuuntelija(tk);
        
        Container contentPane = this.getContentPane();

        contentPane.setLayout(borderLayout1);
        contentPane.add(jToolBar, BorderLayout.NORTH);
        contentPane.add(jSplitPane1, BorderLayout.CENTER);
        contentPane.add(alaosa, BorderLayout.SOUTH);
        
        jToolBar.add(tallenna);
        tallenna.addActionListener(kuuntelija);
        
        alaosa.add(alateksti);

        jSplitPane1.add(jScrollPaneLista, JSplitPane.LEFT);
        jSplitPane1.add(oikeaPohja, JSplitPane.RIGHT);
        jSplitPane1.setDividerLocation(150);
        
        jScrollPaneLista.getViewport().add(jList);
        jScrollPaneLista.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

  //      String[] lista = kirja.haeReseptienNimet();
  //      
  //      jList.setListData(lista);
  //      jList.setSelectedIndex(0);
        
        jList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        //Lisätään oikeanpuoleiseen osaan ...
        oikeaPohja.setLayout(GridLayout2);
        oikeaPohja.add(reseptinTayttoLomake);
        oikeaPohja.add(raakaaineLomake);
        oikeaPohja.add(ohjeLomake);
        
        //Lisätään reseptin perustiedot
        reseptinTayttoLomake.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.RAISED), "Resepti"));
        reseptinTayttoLomake.setLayout(gridLayout3);
        
        reseptinTayttoLomake.add(reseptinnimi);
        reseptinTayttoLomake.add(reseptinimi);
        reseptinTayttoLomake.add(new JLabel(""));
        
        reseptinTayttoLomake.add(kategoria);
        reseptinTayttoLomake.add(new JLabel(""));
        reseptinTayttoLomake.add(new JLabel(""));
        
        reseptinTayttoLomake.add(liha);
        reseptinTayttoLomake.add(new JLabel(""));
        reseptinTayttoLomake.add(new JLabel(""));
        reseptinTayttoLomake.add(kala);
        reseptinTayttoLomake.add(new JLabel(""));
        reseptinTayttoLomake.add(new JLabel(""));
        reseptinTayttoLomake.add(kana);
        reseptinTayttoLomake.add(new JLabel(""));
        reseptinTayttoLomake.add(new JLabel(""));
        reseptinTayttoLomake.add(kasvis);
        reseptinTayttoLomake.add(new JLabel(""));
        reseptinTayttoLomake.add(new JLabel(""));
        reseptinTayttoLomake.add(herkut);
        reseptinTayttoLomake.add(new JLabel(""));
        reseptinTayttoLomake.add(new JLabel(""));
        
        reseptinTayttoLomake.add(vaikeusaste);
        reseptinTayttoLomake.add(new JLabel(""));
        reseptinTayttoLomake.add(new JLabel(""));
        
        reseptinTayttoLomake.add(yksi);
        reseptinTayttoLomake.add(new JLabel(""));
        reseptinTayttoLomake.add(new JLabel(""));
        reseptinTayttoLomake.add(kaksi);
        reseptinTayttoLomake.add(new JLabel(""));
        reseptinTayttoLomake.add(new JLabel(""));
        reseptinTayttoLomake.add(kolme);
        reseptinTayttoLomake.add(new JLabel(""));
        reseptinTayttoLomake.add(new JLabel(""));
        reseptinTayttoLomake.add(nelja);
        reseptinTayttoLomake.add(new JLabel(""));
        reseptinTayttoLomake.add(new JLabel(""));
        reseptinTayttoLomake.add(viisi);
        reseptinTayttoLomake.add(new JLabel(""));
        reseptinTayttoLomake.add(tallennaResepti);     
        
        //Lisätään raaka-aineen tiedot
        raakaaineLomake.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.RAISED), "Raakaaine"));
        raakaaineLomake.setLayout(borderLayout4);
        
        raakaaineLomake.add(raakaainenimi);
        raakaaineLomake.add(raakaaine1);
        
        raakaaineLomake.add(maara);
        raakaaineLomake.add(maara1);
        
        raakaaineLomake.add(yksikko);
        raakaaineLomake.add(yksikko1);
        
        raakaainePane.setContentType("text/html");
        raakaainePane.setEditable(false);   
        raakaainePane.setText("Kalle");
        
        //Lisätään ohje lomakkeelle
        ohjeLomake.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.RAISED), "Ohje"));
        ohjeLomake.setLayout(borderLayout3);
        ohjeLomake.add(annavalmistusohje);
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
        this.setTitle("Resepti");
    }
 

   public JFrame getFrame() {
       return reseptinIkkuna;
}
}

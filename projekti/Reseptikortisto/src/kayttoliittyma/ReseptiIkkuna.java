package kayttoliittyma;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.event.*;
import sovelluslogiikka.*;
import java.util.*;



public class ReseptiIkkuna extends JFrame{

    Kuuntelija ri_kuuntelija;
    Resepti resepti;
    // tila 0 = ei tilaa, tila 1 = lisaa , tila 2 = muokkaa, tila 3 = poista
    int tila = 0;     
     
      
    BorderLayout ikkunanPohja = new BorderLayout();
    
    JPanel alaosa = new JPanel();
    JButton tallenna_resepti = new JButton("Tallenna resepti");
       
    JPanel pohja = new JPanel();
    GridLayout lomakkeidenPohja = new GridLayout(3, 1);
    
    //Resepti-ikkunan tarvikkeet
    JPanel reseptinTayttoLomake = new JPanel();
    GridLayout reseptiLomakePohja = new GridLayout(7, 2);
    JLabel reseptinnimi = new JLabel("Reseptin nimi:");
    JTextField reseptinimi = new JTextField();
    JLabel kategoria = new JLabel("Kategoria:");
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
  
    //Raaka-aineikkunan tarvikkeet
    JPanel raakaaineLomake = new JPanel();
    GridLayout raakaaineLomakePohja = new GridLayout(2,1);
    JPanel raakaaineLomakeYla = new JPanel();
    GridLayout raakaaineLomakeYlaPohja = new GridLayout(3,3);
    JPanel raakaaineLomakeAla = new JPanel();
    BorderLayout raakaaineLomakeAlaPohja = new BorderLayout();
    JLabel raakaainenimi = new JLabel("Raaka-aine:");
    JTextField raakaaine1 = new JTextField();
    JLabel maara = new JLabel("Määrä:");
    JTextField maara1 = new JTextField();
    JLabel yksikko = new JLabel("Yksikkö: kg,g,l,dl,rkl,tl,kpl");
    JTextField yksikko1 = new JTextField();
    JButton lisaaRaakaaine = new JButton("Lisaa raaka-aine"); 
    JEditorPane raakaaineLomakePane =new JEditorPane();
   
    //Ohjeikkunan tarvikkeet
    JPanel ohjeLomake = new JPanel();
    GridLayout ohjeLomakePohja = new GridLayout(4,1);
    JPanel ohjeYla = new JPanel();
    FlowLayout ohjeYlaPohja = new FlowLayout();
    JPanel ohjeKeski = new JPanel();
    BorderLayout ohjeKeskiPohja = new BorderLayout();
    JPanel ohjeAla = new JPanel();
    FlowLayout ohjeAlaPohja = new FlowLayout();
    JPanel ohjeTosiAla = new JPanel();
    BorderLayout ohjeTosiAlaPohja = new BorderLayout(); 
    JLabel annavalmistusohje = new JLabel("Anna valmistusohje vaiheittain");
    JTextField ohje = new JTextField();
    JButton lisaa_vaihe = new JButton("Lisaa vaihe"); 
    JEditorPane ohjeTosiAlaPane = new JEditorPane();
    

    public ReseptiIkkuna(Resepti res, int ti, Tapahtumankasittelija tk) {

        this.resepti = res;
        this.tila = ti;
        ri_kuuntelija = new Kuuntelija(tk);

        
        Container contentPane = this.getContentPane();

        //Lisätään ikkunaan osat
        contentPane.setLayout(ikkunanPohja);
        contentPane.add(pohja, BorderLayout.CENTER);
        contentPane.add(alaosa, BorderLayout.SOUTH);
        
        alaosa.add(tallenna_resepti);
        tallenna_resepti.addActionListener(ri_kuuntelija);

        //Lisätään pohjaan resepti-, raaka-aine- ja ohjelomakkeet
        pohja.setLayout(lomakkeidenPohja);
        pohja.add(reseptinTayttoLomake);
        pohja.add(raakaaineLomake);
        pohja.add(ohjeLomake);
        
        //Lisätään reseptilomakkeen perustiedot
        reseptinTayttoLomake.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.RAISED), "Resepti"));
        reseptinTayttoLomake.setLayout(reseptiLomakePohja);
        
        //Lisätään reseptilomakkeen tiedot
        reseptinTayttoLomake.add(reseptinnimi);
        reseptinTayttoLomake.add(reseptinimi);
        reseptinimi.addActionListener(ri_kuuntelija);
        
        reseptinTayttoLomake.add(kategoria);
        reseptinTayttoLomake.add(vaikeusaste);
        
        reseptinTayttoLomake.add(liha);
        liha.addActionListener(ri_kuuntelija);
        reseptinTayttoLomake.add(yksi);
        yksi.addActionListener(ri_kuuntelija);
        
        reseptinTayttoLomake.add(kala);
        kala.addActionListener(ri_kuuntelija);
        reseptinTayttoLomake.add(kaksi);
        kaksi.addActionListener(ri_kuuntelija);

        reseptinTayttoLomake.add(kana);
        kana.addActionListener(ri_kuuntelija);
        reseptinTayttoLomake.add(kolme);
        kolme.addActionListener(ri_kuuntelija);
        
        reseptinTayttoLomake.add(kasvis);
        kasvis.addActionListener(ri_kuuntelija);
        reseptinTayttoLomake.add(nelja);
        nelja.addActionListener(ri_kuuntelija);
        
        reseptinTayttoLomake.add(herkut);
        herkut.addActionListener(ri_kuuntelija);
        reseptinTayttoLomake.add(viisi);
        viisi.addActionListener(ri_kuuntelija);
        
        kategorinappulat.add(liha);
        kategorinappulat.add(kala);
        kategorinappulat.add(kana);
        kategorinappulat.add(kasvis);
        kategorinappulat.add(herkut); 
        
        vaikeusnappulat.add(yksi);
        vaikeusnappulat.add(kaksi);
        vaikeusnappulat.add(kolme);
        vaikeusnappulat.add(nelja);
        vaikeusnappulat.add(viisi);
        
        
        //Jaetaan raaka-ainelomakkeen pohja ylä- ja alaosaan
        raakaaineLomake.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.RAISED), "Raaka-aine"));
        raakaaineLomake.setLayout(raakaaineLomakePohja);
        raakaaineLomake.add(raakaaineLomakeYla);
        raakaaineLomake.add(raakaaineLomakeAla);
          
        //Asetetaan yläosan tiedot 
        raakaaineLomakeYla.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.RAISED)));
        raakaaineLomakeYla.setLayout(raakaaineLomakeYlaPohja);
        
        raakaaineLomakeYla.add(raakaainenimi);
        raakaaineLomakeYla.add(maara);
        raakaaineLomakeYla.add(yksikko);
        
        raakaaineLomakeYla.add(raakaaine1);
        raakaaine1.addActionListener(ri_kuuntelija);
        raakaaineLomakeYla.add(maara1);
        maara1.addActionListener(ri_kuuntelija);
        raakaaineLomakeYla.add(yksikko1);
        yksikko1.addActionListener(ri_kuuntelija);
       
        raakaaineLomakeYla.add(new JLabel(""));
        raakaaineLomakeYla.add(lisaaRaakaaine); 
        lisaaRaakaaine.addActionListener(ri_kuuntelija);
        raakaaineLomakeYla.add(new JLabel(""));

        //Asetetaan alaosan tiedot
        raakaaineLomakeAla.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.RAISED)));
        raakaaineLomakeAla.setLayout(raakaaineLomakeAlaPohja);

        raakaaineLomakeAla.add(raakaaineLomakePane);
        raakaaineLomakePane.setContentType("text");
        raakaaineLomakePane.setEditable(false);
//        raakaaineLomakePane.setText("Omena 5 kpl");
        
        //Lisätään ohjelomakkeelle pohjat
        ohjeLomake.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.RAISED), "Ohje"));
        ohjeLomake.setLayout(ohjeLomakePohja);
        ohjeLomake.add(ohjeYla);
        ohjeLomake.add(ohjeKeski);
        ohjeLomake.add(ohjeAla);
        ohjeLomake.add(ohjeTosiAla);
        
        ohjeYla.setLayout(ohjeYlaPohja);
        ohjeKeski.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.RAISED)));
        ohjeKeski.setLayout(ohjeKeskiPohja);
        ohjeAla.setLayout(ohjeAlaPohja);
        ohjeTosiAla.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.RAISED)));
        ohjeTosiAla.setLayout(ohjeTosiAlaPohja);
        
        //Lisätään ohjelomakkeelle tiedot
        ohjeYla.add(annavalmistusohje);
        ohjeKeski.add(ohje);
        ohje.addActionListener(ri_kuuntelija);
        ohjeAla.add(lisaa_vaihe);
        lisaa_vaihe.addActionListener(ri_kuuntelija);
        ohjeTosiAla.add(ohjeTosiAlaPane);
        ohjeTosiAlaPane.setContentType("text");
        ohjeTosiAlaPane.setEditable(false);
//        ohjeTosiAlaPane.setText("Kuori omenat");
        
        //Asetetaan ikkunan ominaisuudet
        this.setTitle("Resepti");

    }
 
    public void run() {

        this.setPreferredSize(new Dimension(600, 700));

        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        this.pack();
        this.setVisible(true);
    }

}

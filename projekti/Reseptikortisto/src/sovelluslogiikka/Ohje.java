package sovelluslogiikka;

// reseptin työvaiheet


public class Ohje {

     String vaihe;

    public Ohje(String vaihe) {
        this.vaihe = vaihe;
    }
    public void annaVaihe(String vaihe){
        this.vaihe = vaihe;
    }
    
    public String toString(){
         return vaihe;
    }
}

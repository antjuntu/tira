import java.util.*;

public class Main {
    public static void main(String[] args) {
        Kurssit k1 = new Kurssit();
        k1.lisaaKurssi("OHPE");
        k1.lisaaKurssi("TIRA");
        k1.lisaaKurssi("LAMA");
        k1.lisaaVaatimus("OHPE","TIRA");
        k1.lisaaVaatimus("TIRA","LAMA");
        System.out.println(k1.voikoSuorittaa()); // true
        Kurssit k2 = new Kurssit();
        k2.lisaaKurssi("OHPE");
        k2.lisaaKurssi("TIRA");
        k2.lisaaVaatimus("OHPE","TIRA");
        k2.lisaaVaatimus("TIRA","OHPE");
        System.out.println(k2.voikoSuorittaa()); // false
    }
}

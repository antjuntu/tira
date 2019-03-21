import java.util.*;

public class Ravintola {
    
    //Ostettavien siipien maksimimäärä
    static final int MAX = 1000;
    
    // siipien yhteishinta
    int[] hinnat;
  
    public Ravintola() {
        hinnat = new int[MAX + 1];
    }
    
    public void lisaaPaketti(int maara, int hinta) {
        // lisätään jokainen paketti niin monta kertaa, että
        // MAX määrä voitaisiin ostaa pelkästään tällä paketilla
        for (int i = 0; i < MAX / maara; i++) {
            
            for (int x = MAX - maara; x > 0; x--) {
            if (hinnat[x] > 0) {
                if (hinnat[x + maara] > 0) {
                    hinnat[x + maara] = Math.min(hinnat[x] + hinta, hinnat[x + maara]);
                } else {
                    hinnat[x + maara] = hinnat[x] + hinta;
                }
            }
        }
        // Tapaus x = 0
        if (hinnat[maara] > 0) {
            hinnat[maara] = Math.min(hinnat[maara], hinta);
        } else {
            hinnat[maara] = hinta;
        }
            
       }
        
//        String s = Arrays.toString(hinnat);
//        System.out.println("maara: " + maara + ", hinta: " + hinta + " lisätty");
//        System.out.println(s);
//        System.out.println("-------------------------------");
    }
    

    public int halvinHinta(int maara) {
        return hinnat[maara];
    }
    
}

import java.util.*;

public class PeliVerkko {
    
    static final int V = 1000000;
    
    // edustajan i komponenttiin kuuluvat jäsenet
    ArrayList<Integer>[] komponentit = new ArrayList[V + 1];
    // T örkki
    // F haltija
    boolean[] rooli = new boolean[V + 1];
   
    boolean voiPelata = false;
    
    int[] vanhempi = new int[V + 1];
    int[] koko = new int[V + 1];
    
    public void lisaaYhteys(int a, int b) {
        int x = find(a);
        int y = find(b);
        if (x != y) {
            if (rooli[a] == rooli[b]) {
                muutaKomponentinRooli(b);
            }
        }
        
    }
    
    public boolean voikoPelata() {
        return voiPelata;
    }

    int find(int x) {
        while (x != vanhempi[x]) {
            x = vanhempi[x];
        }
        return x;
    }
    
    // oletus: a ja b ovat komponenttiensa edustajia
    void union(int a, int b) {
        if (a > b) {
            int temp = a;
            a = b;
            b = temp;
        }
        // nyt a <= b
        vanhempi[a] = b;
        koko[b] = koko[b] + koko[a];
    }
    
    public PeliVerkko() {
        for (int i = 1; i <= V; i++) {
            komponentit[i] = new ArrayList<>();
            vanhempi[i] = i;
            koko[i] = 1;
            rooli[i] = false;
        }
    }
    
    void muutaKomponentinRooli(int x) {
        for (Integer i : komponentit[x]) {
            rooli[i] = !rooli[i];
        }
    }
    
}

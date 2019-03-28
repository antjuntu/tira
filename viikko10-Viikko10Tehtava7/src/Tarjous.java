import java.util.*;

public class Tarjous {
    
    static final int MAX_KAUPUNGIT = 500;
    static final int MAX_HINTA = 1000 * 10000;
    
    int n = 0; // kaupunkien lkm
    
    HashMap<String, Integer> kaupungit;
    
    int[][] d;
    
    ArrayList<Kaari> kaaret;
    
    public void lisaaYhteys(String alku, String loppu, int hinta) {
        if (!kaupungit.containsKey(alku)) {
            kaupungit.put(alku, ++n);
        }
        int alkuSolmu = kaupungit.get(alku);
        if (!kaupungit.containsKey(loppu)) {
            kaupungit.put(loppu, ++n);
        }
        int loppuSolmu = kaupungit.get(loppu);
        
        // Tallennetaan vain halvin yhteys jokaiselta väliltä
        if (d[alkuSolmu][loppuSolmu] > hinta) {
            d[alkuSolmu][loppuSolmu] = hinta;
        }
        kaaret.add(new Kaari(alkuSolmu, loppuSolmu, hinta));
    }
    
    public int reitinHinta(String alku, String loppu) {
        if (!kaupungit.containsKey(alku) || !kaupungit.containsKey(loppu)) {
            return -1;
        }
        
        floydWarshall();
        
        int alkuSolmu = kaupungit.get(alku);
        int loppuSolmu = kaupungit.get(loppu);
        if (d[alkuSolmu][loppuSolmu] == MAX_HINTA) {
            return -1;
        }
        
        int max = MAX_HINTA;
        for (Kaari kaari : kaaret) {
            int uusiHinta = d[alkuSolmu][kaari.alku] + kaari.hinta / 2 + d[kaari.loppu][loppuSolmu];
            if (uusiHinta < max) {
                max = uusiHinta;
            }
        }
   
        return max;
     
    }
    
    void floydWarshall() {
        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    int uusi = d[i][k] + d[k][j];
                    if (uusi < d[i][j]) {
                        d[i][j] = uusi;
                    }
                }
            }
        }
    }
    
    public Tarjous() {
        d = new int[MAX_KAUPUNGIT + 1][MAX_KAUPUNGIT + 1];
        for (int i = 1; i <= MAX_KAUPUNGIT; i++) {
            for (int j = 1; j <= MAX_KAUPUNGIT; j++) {
                if (i == j) {
                    d[i][i] = 0;
                } else {
                    d[i][j] = MAX_HINTA;
                }
            }
        }
        kaupungit = new HashMap<>();
        kaaret = new ArrayList();
    }
    
    class Kaari {
        int alku;
        int loppu;
        int hinta;

        public Kaari(int alku, int loppu, int hinta) {
            this.alku = alku;
            this.loppu = loppu;
            this.hinta = hinta;
        }
    }
}

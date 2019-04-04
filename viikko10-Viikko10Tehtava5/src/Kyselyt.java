
import java.util.*;

public class Kyselyt {
    
    static final int MAX = 500 * 1000;
    
    // kaupunkien lukumäärä
    int n = 0;
    boolean reititLaskettu = false;
    
    HashMap<String, Integer> kaupungit = new HashMap<>();
    ArrayList<Kaari> kaaret = new ArrayList<>();
    int[][] d;
    
    public void lisaaTie(String alku, String loppu, int pituus) {
        
        if (!kaupungit.containsKey(alku)) {
            kaupungit.put(alku, ++n);
        }
        int alkuSolmu = kaupungit.get(alku);

        if (!kaupungit.containsKey(loppu)) {
            kaupungit.put(loppu, ++n);
        }
        int loppuSolmu = kaupungit.get(loppu);
      
        kaaret.add(new Kaari(alkuSolmu, loppuSolmu, pituus));
        kaaret.add(new Kaari(loppuSolmu, alkuSolmu, pituus));
    }
    
    public int reitinPituus(String alku, String loppu) {

        if (!reititLaskettu) {
            laskeReitit();
            reititLaskettu = true;
        }
            
        // HUOM! etäisyys kaupungista itseensä
        if (alku.equals(loppu)) {
            return 0;
        }
        
        if (!kaupungit.containsKey(alku) || !kaupungit.containsKey(loppu)) {
            return -1;
        }

        int mista = kaupungit.get(alku);
        int minne = kaupungit.get(loppu);
        
        if (d[mista][minne] == MAX) {
            return -1;
        }
        return d[mista][minne];
    }
    
    void laskeReitit() {
        
        d = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == j) {
                    d[i][i] = 0;
                } else {
                    d[i][j] = MAX;
                }
            }
        }
        // jos lisätään lyhyempi reitti jo olemassaolevalle reitille
        kaaret.forEach((kaari) -> {
            if (d[kaari.alku][kaari.loppu] > kaari.pituus) {
                d[kaari.alku][kaari.loppu] = kaari.pituus;
            }
        });
        floydWarshall();
    }
    
    void floydWarshall() {
        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for(int j = 1; j <= n; j++) {
                    if (d[i][j] > d[i][k] + d[k][j]) {
                        d[i][j] = d[i][k] + d[k][j];
                    }
                }
            }
        }
    }
    
    public static class Kaari {
        public int alku;
        public int loppu;
        public int pituus;

        public Kaari(int alku, int loppu, int pituus) {
            this.alku = alku;
            this.loppu = loppu;
            this.pituus = pituus;
        }
    }
}

import java.util.*;


public class Palvelimet {
    
    // Nyt solmu 0 on verkon lähde!!!
    static final int V = 100;
    static final int MAX = Integer.MAX_VALUE;
    int[][] d;
    boolean[] vierailtu;
    ArrayDeque<Integer> jono;
    int[] edeltaja;
    
    public void lisaaPalvelin(int kone) {
        // lisätään yhteys 0 -> kone virtauksella MAX + 1
        d[0][kone] = MAX;
    }
    
    public void lisaaYhteys(int alku, int loppu, int nopeus) {
        d[alku][loppu] += nopeus;
    }
    // alkusolmu on 0
    public int laskeNopeus(int kohde) {
        int alku = 0;
        int maxVirtaus = 0;
        
        boolean uusiPolkuLoytyi = false;
        
        do {
            uusiPolkuLoytyi = false;
            for (int i = 0; i <= V; i++) {
                vierailtu[i] = false;
                edeltaja[i] = -1;
            }
            jono = new ArrayDeque<>();
            vierailtu[alku] = true;
            jono.addLast(alku);
            
            while (!jono.isEmpty()) {
                int v = jono.removeFirst();
                for (int s = 0; s <= V; s++) {
                    if (d[v][s] > 0 && !vierailtu[s]) {
                        vierailtu[s] = true;
                        edeltaja[s] = v;
                        if (s == kohde) {
                            uusiPolkuLoytyi = true;
                            break;
                        }
                        jono.addLast(s);
                    }
                }
            }
            if (uusiPolkuLoytyi) {
                ArrayDeque<Integer> jono1 = new ArrayDeque<>();
                ArrayDeque<Integer> jono2 = new ArrayDeque<>();
                jono1.addFirst(kohde);
                jono2.addFirst(kohde);
                int s = kohde;
                while (s != alku) {
                    s = edeltaja[s];
                    jono1.addFirst(s);
                    jono2.addFirst(s);
                }
                
                int minPituus = MAX;
                s = jono1.removeFirst();
                while (!jono1.isEmpty()) {
                    int x = jono1.removeFirst();
                    if (d[s][x] < minPituus) {
                        minPituus = d[s][x];
                    }
                    s = x;
                }
                
                maxVirtaus += minPituus;
                s = jono2.removeFirst();
                while (!jono2.isEmpty()) {
                    int x = jono2.removeFirst();
                    d[s][x] = d[s][x] - minPituus;
                    d[x][s] = minPituus;
                    s = x;
                }
            }
        } while (uusiPolkuLoytyi);
        
        return maxVirtaus;
    }
    
    public Palvelimet() {
        d = new int[V + 1][V + 1];
        vierailtu = new boolean[V + 1];
        edeltaja = new int[V + 1];
    }
}


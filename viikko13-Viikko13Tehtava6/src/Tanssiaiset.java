import java.util.*;


public class Tanssiaiset {
    
    // 0   -> alku
    // 1   -> 100 kumpulan opisk.
    // 101 -> 200 viikin opisk.
    // 201 -> loppu
    static final int V = 201;
    static final int ALKU = 0;
    static final int LOPPU = 201;
    
    HashMap<String, Integer> kumpulanOpiskelija = new HashMap<>();
    HashMap<String, Integer> viikinOpiskelija = new HashMap<>();
    
    int kumpulanLkm = 0;
    int viikinLkm = 100;
    
    int[][] d = new int[V + 1][V + 1];
    boolean[] vierailtu = new boolean[V + 1];
    int[] edeltaja = new int[V + 1];
    
    ArrayDeque<Integer> jono = new ArrayDeque<>();
    ArrayDeque<Integer> jono1 = new ArrayDeque<>();
    ArrayDeque<Integer> jono2 = new ArrayDeque<>();
    
    public void lisaaToive(String a, String b) {
        if (!kumpulanOpiskelija.containsKey(a)) {
            kumpulanOpiskelija.put(a, ++kumpulanLkm);
        }
        if (!viikinOpiskelija.containsKey(b)) {
            viikinOpiskelija.put(b, ++viikinLkm);
        }
        int x = kumpulanOpiskelija.get(a);
        int y = viikinOpiskelija.get(b);
        
        d[ALKU][x] = 1;
        d[x][y] = 1;
        d[y][LOPPU] = 1;
    }
    
    public int laskeParit() {
        int maxVirtaus = 0;
        
        boolean uusiPolku = false;
        
        do {
            uusiPolku = false;
            
            for (int i = 0; i <= V; i++) {
                vierailtu[i] = false;
                edeltaja[i] = -1;
            }
            vierailtu[ALKU] = true;
            jono.addLast(ALKU);
            
            while (!jono.isEmpty()) {
                int v = jono.removeFirst();
                for (int s = 0; s <= V; s++) {
                    if (d[v][s] > 0 && !vierailtu[s]) {
                        vierailtu[s] = true;
                        edeltaja[s] = v;
                        if (s == LOPPU) {
                            uusiPolku = true;
                            break;
                        }
                        jono.addLast(s);
                    }
                }
            }
            
            if (uusiPolku) {
                jono1 = new ArrayDeque<>();
                jono2 = new ArrayDeque<>();
                jono1.addFirst(LOPPU);
                jono2.addFirst(LOPPU);
                int s = LOPPU;
                while (s != ALKU) {
                    s = edeltaja[s];
                    jono1.addFirst(s);
                    jono2.addFirst(s);
                }
                
                int minPituus = Integer.MAX_VALUE;
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
            
        } while (uusiPolku);
        
        return maxVirtaus;
    }
}


























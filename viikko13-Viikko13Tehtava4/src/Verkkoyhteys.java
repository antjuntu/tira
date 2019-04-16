import java.util.*;


public class Verkkoyhteys {
    
    static final int V = 100;
    static final int MAX_NOPEUS = 100;
    
    //int maxVirtaus;
    int[][] d;
    
    boolean[] vierailtu;
    ArrayDeque<Integer> jono;
    int[] edeltaja;
    
    public void lisaaYhteys(int alku, int loppu, int nopeus) {

        d[alku][loppu] += nopeus;
    }
    
    public int laskeNopeus(int alku, int loppu) {
        int maxVirtaus = 0;
//        for (int i = 1; i <= 5; i++) {
//            for (int j = 1; j <= 5; j++) {
//                System.out.print(d[i][j] + " ");
//            }
//            System.out.println();
//        }
        boolean uusiPolkuLoytyi = false;
   
        do {
            uusiPolkuLoytyi = false;
            for (int i = 1; i <= V; i++) {
                vierailtu[i] = false;
                edeltaja[i] = 0;
            }
            jono = new ArrayDeque<>();
            vierailtu[alku] = true;
            jono.addLast(alku);
            while(!jono.isEmpty()) {
                int v = jono.removeFirst();
                for (int s = 1; s <= V; s++) {
                    if (d[v][s] > 0 && !vierailtu[s]) {
                        vierailtu[s] = true;
                        edeltaja[s] = v;
                        if (s == loppu) {
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
                jono1.addFirst(loppu);
                jono2.addFirst(loppu);
                int s = loppu;
                while (s != alku) {
                    s = edeltaja[s];
                    jono1.addFirst(s);
                    jono2.addFirst(s);
                }
                
                int minPituus = MAX_NOPEUS + 1;
                System.out.println(jono1);
                s = jono1.removeFirst();
                while (!jono1.isEmpty()) {
                    int x = jono1.removeFirst();
                    if (d[s][x] < minPituus) {
                        minPituus = d[s][x];
                    }
                    s = x;
                }
                
                System.out.println("minPituus: " + minPituus);
                maxVirtaus += minPituus;
                ///////////////////////////////////
                //System.out.println(jono2);
                s = jono2.removeFirst();
                while (!jono2.isEmpty()) {
                    int x = jono2.removeFirst();
                    System.out.println("s: " + s + ", x: " + x);
                    d[s][x] = d[s][x] - minPituus;
                    d[x][s] = minPituus;
                    s = x;
                }
//                for (int i = 1; i <= 5; i++) {
//                    for (int j = 1; j <= 5; j++) {
//                        System.out.print(d[i][j] + " ");
//                    }
//                    System.out.println();
//                }
            }
        } while (uusiPolkuLoytyi);
        
        return maxVirtaus;
    }
    
    public Verkkoyhteys() {
//        vieruslista = new ArrayList[V + 1];
//        for (int i = 1; i <= V; i++) {
//            vieruslista[i] = new ArrayList<>();
//        }
        d = new int[V + 1][V + 1];
        //maxVirtaus = 0;
        vierailtu = new boolean[V + 1];
        edeltaja = new int[V + 1];
    }
    
    class Kaari {
        int alku;
        int loppu;
        int nopeus;

        public Kaari(int alku, int loppu, int nopeus) {
            this.alku = alku;
            this.loppu = loppu;
            this.nopeus = nopeus;
        }
           
    }
}

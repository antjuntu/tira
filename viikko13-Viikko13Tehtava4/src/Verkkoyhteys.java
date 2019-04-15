import java.util.*;


public class Verkkoyhteys {
    
    static final int V = 100;
    static final int MAX_NOPEUS = 100;
    
    //int maxVirtaus;
    ArrayList<Kaari>[] vieruslista;
    int[][] d;
    
    boolean[] vierailtu;
    ArrayDeque<Integer> jono;
    int[] edeltaja;
    
    public void lisaaYhteys(int alku, int loppu, int nopeus) {
        vieruslista[alku].add(new Kaari(alku, loppu, nopeus));
        d[alku][loppu] = nopeus;
    }
    
    public int laskeNopeus(int alku, int loppu) {
        int maxVirtaus = 0;
        
        boolean uusiPolkuLoytyi = false;
        do {
            int minJaannosKapasiteetti = MAX_NOPEUS + 1;
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
                        if (d[v][s] < minJaannosKapasiteetti) {
                            minJaannosKapasiteetti = d[v][s];
                        }
                        edeltaja[s] = v;
                        if (v == loppu) {
                            uusiPolkuLoytyi = true;
                            break;
                        }
                        jono.addLast(s);
                    }
                }
            }
        } while (uusiPolkuLoytyi);
        
        return maxVirtaus;
    }
    
    public Verkkoyhteys() {
        vieruslista = new ArrayList[V + 1];
        for (int i = 1; i <= V; i++) {
            vieruslista[i] = new ArrayList<>();
        }
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

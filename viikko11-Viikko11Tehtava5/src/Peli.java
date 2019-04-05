import java.util.*;

public class Peli {
    
    static final int N = 500;
    static final int VALKOINEN = 0;
    static final int HARMAA = 1;
    static final int MUSTA = 2;
    
    int n;
    int[] vari;
    int[] pituus;
    
    boolean sykli;
    
    ArrayList<Integer>[] vieruslista;
       
    public Peli() {       
        n = 0;
        vieruslista = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            vieruslista[i] = new ArrayList<>();
        }
        vari = new int[N + 1];
        pituus = new int[N + 1];
        
        sykli = false;
    }
    
    public void lisaaYhteys(int alku, int loppu) {
        vieruslista[alku].add(loppu);
    }
    
    public int parasTulos(int alku, int loppu) {
        if (alku == loppu) {
            return 1;
        }
        syvyyshaku(alku);
        if (vari[loppu] == VALKOINEN) {
            return -1;
        }
        //System.out.println("sykli: " + sykli);
        //System.out.println(Arrays.toString(pituus));
        return pituus[alku];
    }
    
    void syvyyshaku(int u) {
        vari[u] = MUSTA;
        pituus[u] = 1;
        
        for (Integer v : vieruslista[u]) {
            if (vari[v] == VALKOINEN) {
                syvyyshaku(v);
            }
            // Nämä suoritetaan myös kun solmu on musta
            int uusi = pituus[v] + 1;
            if (uusi > pituus[u]) {
                pituus[u] = uusi;
            }
        }
    }
    
    void syvyyshaku2(int u) {
        vari[u] = HARMAA;
        pituus[u] = 1;
        
        for (Integer v : vieruslista[u]) {
            if (vari[v] == HARMAA) {
                sykli = true;
                continue;
            }
            if (vari[v] == VALKOINEN) {
                syvyyshaku(v);
                int uusi = pituus[v] + 1;
                if (uusi > pituus[u]) {
                    pituus[u] = uusi;
                }
            }
        }
    }
     
}

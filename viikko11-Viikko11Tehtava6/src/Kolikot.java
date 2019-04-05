import java.util.*;

public class Kolikot {
    
    static final int N = 500;
    
    boolean[] kasitelty;
    int[] kolikoitaHuoneessa;
    int[] yhteensa;
    
    int[] seuraaja;
    
    ArrayList<Integer>[] vieruslista;
    
    public Kolikot() {
        
        kasitelty = new boolean[N + 1];
        kolikoitaHuoneessa = new int[N + 1];
        yhteensa = new int[N + 1];
        
        vieruslista = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            vieruslista[i] = new ArrayList<>();
        }
        
        seuraaja = new int[N + 1];
    }
    
    public void lisaaYhteys(int alku, int loppu) {
        
        vieruslista[alku].add(loppu);
    }
    
    public void lisaaKolikko(int huone) {
        kolikoitaHuoneessa[huone]++;
    }
    
    
    public int parasTulos(int alku, int loppu) {
        

        syvyyshaku(alku);
     
        if (alku == loppu) {
            return kolikoitaHuoneessa[alku];
        }
        if (!kasitelty[loppu]) {
            return -1;
        }
        
        boolean loppuLöytyiPolulta = false;
        int x = alku;
        while (x != -1) {
            x = seuraaja[x];
            if (x == loppu) {
                loppuLöytyiPolulta = true;
            }
        }
        if (!loppuLöytyiPolulta) {
            return 0;
        }
        
        return yhteensa[alku];
    }
   
    void syvyyshaku(int u) {
        kasitelty[u] = true;
        yhteensa[u] = kolikoitaHuoneessa[u];
        seuraaja[u] = -1;
        
        for (Integer v : vieruslista[u]) {
            if (!kasitelty[v]) {
                syvyyshaku(v);
            }
            int uusi = kolikoitaHuoneessa[u] + yhteensa[v];
            if (uusi > yhteensa[u]) {
                yhteensa[u] = uusi;
                seuraaja[u] = v;
            }
        }
    }
    
}

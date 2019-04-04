import java.util.*;

public class Kurssit {
    
    static final int MAX_N = 500;
    int n;
    HashMap<String, Integer> kurssit;
    ArrayList<Integer>[] vieruslista;
    
    static final int VALKOINEN = 0;
    static final int HARMAA = 1;
    static final int MUSTA = 2;
    int[] vari;
    boolean loytyiSykli;
    
    public Kurssit() {
        n = 0;
        kurssit = new HashMap<>();
        vieruslista = new ArrayList[MAX_N + 1];
        for (int i = 1; i <= MAX_N; i++) {
            vieruslista[i] = new ArrayList<>();
        }
        vari = new int[MAX_N + 1];
    }
    
    public void lisaaKurssi(String nimi) {
        if (!kurssit.containsKey(nimi)) {
            kurssit.put(nimi, ++n);
        }
    }
    
    public void lisaaVaatimus(String ensin, String sitten) {
        vieruslista[kurssit.get(ensin)].add(kurssit.get(sitten));
    }
    
    // Jos verkossa ei ole sykliä, niin topologinen järjestys löytyy
    public boolean voikoSuorittaa() {
        loytyiSykli = false;
        for (int v = 1; v <= n; v++) {
            if (vari[v] == VALKOINEN) {
                syvyyshaku(v);
            }
        }
        return !loytyiSykli;
    }
    
    public void syvyyshaku(int u) {
        vari[u] = HARMAA;
        for (Integer v : vieruslista[u]) {
            if (vari[v] == HARMAA) {
                loytyiSykli = true;
                return;
            }
            if (vari[v] == VALKOINEN) {
                syvyyshaku(v);
            }
        }
        vari[u] = MUSTA;
    }
    
}

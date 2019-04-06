import java.util.*;

public class Lennot {
    
    static final int N = 500;
    int n;
    
    static final int VALKOINEN = 0;
    static final int HARMAA = 1;
    static final int MUSTA = 2;
    int[] vari;
    
    boolean[] kasitelty;
    
    HashMap<String, Integer> kaupungit;
    
    ArrayList<Integer>[] vieruslista;
    ArrayList<Integer>[] vieruslistaTranspoosi;
    ArrayDeque<Integer> lista;
    
    int komponentteja;
    
    public Lennot() {
        n = 0;
        kaupungit = new HashMap<>();
        vieruslista = new ArrayList[N + 1];
        vieruslistaTranspoosi = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            vieruslista[i] = new ArrayList<>();
            vieruslistaTranspoosi[i] = new ArrayList<>();
        }
    }
    
    public void lisaaKaupunki(String nimi) {
        if (!kaupungit.containsKey(nimi)) {
            kaupungit.put(nimi, ++n);
        }
    }
    
    public void lisaaYhteys(String alku, String loppu) {
        vieruslista[kaupungit.get(alku)].add(kaupungit.get(loppu));
        vieruslistaTranspoosi[kaupungit.get(loppu)].add(kaupungit.get(alku));
        
    }
    
    
    public boolean onkoKaikki() {
        vari = new int[N + 1];
        kasitelty = new boolean[N + 1];
        komponentteja = 0;
        lista = new ArrayDeque<>();
        
        SCC();
        
        return komponentteja == 1;
    }
    
    void SCC() {
        for (int i = 1; i <= n; i++) {
            if (vari[i] == VALKOINEN) {
                syvyyshaku(i);
            }
        }
        
        while (!lista.isEmpty()) {
            int i = lista.removeFirst();
            if (!kasitelty[i]) {
                ++komponentteja;
                syvyyshakuTranspoosi(i);
            }
        }
        
    }
    
    void syvyyshaku(int u) {
        vari[u] = HARMAA;
        for (Integer v : vieruslista[u]) {
            if (vari[v] == VALKOINEN) {
                syvyyshaku(v);
            }
        }
        vari[u] = MUSTA;
        lista.addFirst(u);
    }
    
    void syvyyshakuTranspoosi(int u) {
        kasitelty[u] = true;
        for (Integer v : vieruslistaTranspoosi[u]) {
            if (!kasitelty[v]) {
                syvyyshakuTranspoosi(v);
            }
        }
    }
    
}

import java.util.*;

public class Kolikot {
    
    static final int N = 500;
    static final int VALKOINEN = 0;
    static final int HARMAA = 1;
    static final int MUSTA = 2;
    
    boolean[] huone;
    int vari[];
    boolean[] kasitelty;
    int[] kolikoitaHuoneissa;
    
    ArrayList<Integer>[] vieruslista;
    ArrayList<Integer>[] vieruslistaTranspoosi;
    
    // Kosarajun algoritmiin
    ArrayDeque<Integer> lista;
    
    // Komponenttiverkko
    int nC = 0;
    int[] komponentti;
    int[] kolikoitaKomponenteissa;
    
    ArrayList<Integer> vieruslistaC;
    
    public Kolikot() {
        huone = new boolean[N + 1];
        vari = new int[N + 1];
        kasitelty = new boolean[N + 1];
        kolikoitaHuoneissa = new int[N + 1];
        
        vieruslista = new ArrayList[N + 1];
        vieruslistaTranspoosi = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            vieruslista[i] = new ArrayList<>();
            vieruslistaTranspoosi[i] = new ArrayList<>();
        }
        
        lista = new ArrayDeque<>();
    }
    
    public void lisaaYhteys(int alku, int loppu) {
        huone[alku] = true;
        huone[loppu] = true;
        vieruslista[alku].add(loppu);
        vieruslistaTranspoosi[loppu].add(alku);
    }
    
    public void lisaaKolikko(int huone) {
        kolikoitaHuoneissa[huone]++;
    }
    
    
    public int parasTulos(int alku, int loppu) {
        
        kosaraju();
        
        return 0;
    }
    
    void kosaraju() {
        for (int i = 1; i <= N; i++) {
            if (huone[i] && vari[i] == VALKOINEN) {
                syvyyshaku1(i);
            }
        }
        System.out.println("Lista:");
        for (Integer i : lista) {
            if (huone[i]) {
                System.out.print(i + ", ");
            }
        }
        System.out.println();
    }
    
    void syvyyshaku1(int u) {
        vari[u] = HARMAA;
        for (Integer v : vieruslista[u]) {
            if (!huone[v]) {
                continue;
            }
//            if (vari[v] == HARMAA) {
//                // sykli löytyi
//            }
            if (vari[v] == VALKOINEN) {
                syvyyshaku1(v);
            }
        }
        vari[u] = MUSTA;
        lista.addFirst(u);
    }
    
    void syvyyshaku2(int u) {
        
    }
    
    
}

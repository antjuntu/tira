import java.util.*;

public class Peli {
    
    static final int N = 500;
    static final int VALKOINEN = 0;
    static final int HARMAA = 1;
    static final int MUSTA = 2;
    int[] vari;
    
    // jos solmu i on olemassa solmu[i] = true
    boolean[] solmu;
    boolean[] kasitelty;
    
    
    
    // Alkuperäisen verkon vieruslista
    ArrayList<Integer>[] vieruslista;
    // Transpoosiverkon vieruslista
    ArrayList<Integer>[] vieruslistaC;
    
    int[][] d;
    int[][] dT;
    
    ArrayDeque<Integer> lista;
    
    // Komponenttiverkko
    int komponentteja = 0;
    int[] komponentti;
    
    int[] huoneitaKomponentissa;
    int[][] dC;
    
    int[] huoneitaReitilla;
    boolean[] kasiteltyC;
    
    public Peli() {
        vari = new int[N + 1];
        solmu = new boolean[N + 1];
        kasitelty = new boolean[N + 1];
        
        komponentti = new int[N + 1];
        
        vieruslista = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            vieruslista[i] = new ArrayList<>();
        }
        
        vieruslistaC = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            vieruslistaC[i] = new ArrayList<>();
        }
        
        d = new int[N + 1][N + 1];
        dT = new int[N + 1][N + 1];
        
        lista = new ArrayDeque<>();
    }
    
    public void lisaaYhteys(int alku, int loppu) {
        solmu[alku] = true;
        solmu[loppu] = true;
        vieruslista[alku].add(loppu);
        vieruslistaC[loppu].add(alku);
        d[alku][loppu] = 1;
    }
    
    
    public int parasTulos(int alku, int loppu) {
        SCC();
//        for (int i = 1; i <= 5; i++) {
//            for (int j = 1; j <= 5; j++) {
//                System.out.print(d[i][j]);
//            }
//            System.out.println();
//        }
//        System.out.println("------------------------------");
//        for (int i = 1; i <= 5; i++) {
//          for (int j = 1; j <= 5; j++) {
//              System.out.print(dT[i][j]);
//          }
//          System.out.println();
//        }
//        System.out.println(lista);
//        for (int i = 1; i <= N; i++) {
//            if (solmu[i]) {
//                System.out.println(i + ": " +komponentti[i]);
//            }
//        }
        muodostaKomponettiVerkko();
        if (komponentteja == 1) {
            return huoneitaKomponentissa[1];
        }
        if (alku == loppu) {
            return 1;
        }
        
        System.out.println("komponentti alku" + komponentti[alku]);
        System.out.println("komponentti loppu" + komponentti[loppu]);
        pisinReitti(komponentti[alku]);
        System.out.println("huoneita reitilla");
        for (int i = 1; i <= komponentteja; i++) {
            System.out.println(i + ": " + huoneitaReitilla[i]);
        }
        if (huoneitaReitilla[komponentti[alku]] == 0) {
            return -1;
        }
        return huoneitaReitilla[komponentti[alku]];
    }
    
    public void muodostaKomponettiVerkko() {
        dC = new int[komponentteja + 1][komponentteja + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (d[i][j] > 0) {
                    dC[komponentti[i]][komponentti[j]] = 1;
                }
            }
        }
        for (int i = 1; i <= komponentteja; i++) {
            dC[i][i] = 0;
        }
        
//        System.out.println("KomponenttiVerkko: ");
//        for (int i = 1; i <= komponentteja; i++) {
//            for (int j = 1; j <= komponentteja; j++) {
//                System.out.print(dC[i][j]);
//            }
//            System.out.println();
//        }
//        System.out.println("---------------");
        
        System.out.println("Komponentit: ");
        for (int i = 1; i <= N ; i++) {
            if (solmu[i])
                System.out.println( i + ": " + komponentti[i]);
        }

        // huoneita kmponenteissa
        huoneitaKomponentissa = new int[komponentteja + 1];
        for (int i = 1; i <= N; i++) {
            if (solmu[i]) {
                huoneitaKomponentissa[komponentti[i]]++;
            }
        }
        
        System.out.println("Huoneita komponenteissa:");
        for (int i = 1; i <= komponentteja; i++) {
            System.out.println("komponentti " + i + ": " + huoneitaKomponentissa[i]);
        }
        kasiteltyC = new boolean[komponentteja + 1];
        huoneitaReitilla = new int[komponentteja + 1];
        
    }
    
    public void pisinReitti(int u) {
        kasiteltyC[u] = true;
        huoneitaReitilla[u] = huoneitaKomponentissa[u];
        for (int j = 1; j <= komponentteja; j++) {
            if (dC[u][j] > 0 && !kasiteltyC[j]) {
                pisinReitti(j);
                int uusi = huoneitaReitilla[j] + huoneitaKomponentissa[u];
                if (uusi > huoneitaReitilla[u]) {
                    huoneitaReitilla[u] = uusi;
                }
            }
        }
    }
    
    public void SCC() {
        for (int i = 1; i <= N; i++) {
            if (solmu[i] && vari[i] == VALKOINEN) {
                syvyyshaku(i);
            }
        }
        // transpoosi
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                dT[i][j] = d[j][i];
            }
        }
        
        while (!lista.isEmpty()) {
            int i = lista.removeFirst();
            if (solmu[i] && !kasitelty[i]) {
                ++komponentteja;
                syvyyshaku2(i);
            }
        }
    }
    
    public void syvyyshaku(int u) {
        vari[u] = HARMAA;
        for (Integer v : vieruslista[u]) {
            if (!solmu[v]) {
                continue;
            }
            if (vari[v] == VALKOINEN) {
                syvyyshaku(v);
            }
        }
        vari[u] = MUSTA;
        lista.addFirst(u);
    }
    
    public void syvyyshaku2(int u) {
        kasitelty[u] = true;
        komponentti[u] = komponentteja;
        for (Integer v : vieruslistaC[u]) {
            if (!solmu[v]) {
                continue;
            }
            if (!kasitelty[v]) {
                syvyyshaku2(v);
            }
        }
    }
    
}


import java.util.*;
public class Main {

    static ArrayDeque<Integer> jono;
    static boolean[] vierailtu;
    static int[] etaisyys;
    // lyhyimpien reittien lkm solmuun i asti reitit[i]
    static long[] reitit;
    
    static ArrayList<Integer>[] vieruslistat;
    
    // muodosta ensin vieruslista
    public static long reittimaara(int n, int[] mista, int[] minne) {
        jono = new ArrayDeque<>();
        muodostaVierusLista(n, mista, minne);
        
        reitit = new long[n + 1];
        reitit[1] = 1;
        
        vierailtu = new boolean[n + 1];
        etaisyys = new int[n + 1];
        
        leveysHaku(1);
        
        return reitit[n];
    }
    
    public static void leveysHaku(int u) {
        vierailtu[u] = true;
        etaisyys[u] = 0;
        jono.addLast(u);
        
        while (!jono.isEmpty()) {
            int v = jono.removeFirst();
            for (Integer s : vieruslistat[v]) {
                if (vierailtu[s] && etaisyys[s] == etaisyys[v] + 1) {
                    reitit[s] = reitit[s] + reitit[v];
                    continue;
                }
                if (!vierailtu[s]) {
                    reitit[s] = reitit[v];
                    vierailtu[s] = true;
                    etaisyys[s] = etaisyys[v] + 1;
                    jono.addLast(s);
                }
            }
        }
        
    }

    // Muodosta ensin vieruslista
    public static void main(String[] args) {
        System.out.println(reittimaara(2, new int[]{1}, new int[]{2}));                               //1
        System.out.println(reittimaara(5, new int[]{1, 1, 2, 3, 4}, new int[]{2, 3, 4, 4, 5}));               //2
        System.out.println(reittimaara(5, new int[]{1, 1, 1, 2, 3, 4}, new int[]{2, 3, 4, 5, 5, 5})); //3
        System.out.println(reittimaara(7, new int[]{1, 2, 3, 1, 1, 4, 5, 6}, new int[]{2, 3, 7, 4, 5, 6, 6, 7}));   //3

    }
    
    public static void muodostaVierusLista(int n, int[] mista, int[] minne) {
        vieruslistat = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            vieruslistat[i] = new ArrayList<>();
        }
        
        for (int i = 0; i < mista.length; i++) {
            vieruslistat[mista[i]].add(minne[i]);
            vieruslistat[minne[i]].add(mista[i]);
        }
        
//        for (int i = 1; i <= n; i++) {
//            System.out.print(i + ": ");
//            for (Integer s : vieruslistat[i]) {
//                System.out.print(s + " ");
//            }
//            System.out.println();
//        }
    }
}

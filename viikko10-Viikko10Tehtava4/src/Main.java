
import java.util.*;

public class Main {

    static int N;
    static long[] etaisyys;
    static boolean[] kasitelty;
    
    static ArrayList<Kaari>[] vieruslista;
    static PriorityQueue<X> keko;
    
    public static long lyhinReitti(int n, int[] mista, int[] minne, long[] matka) {
        N = n;
        vieruslista = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            vieruslista[i] = new ArrayList<>();
        }
        alustaVieruslista(mista, minne, matka);
        
        etaisyys = new long[N + 1];
        for (int i = 1; i <= N; i++) {
            etaisyys[i] = Long.MAX_VALUE;
        }
        kasitelty = new boolean[N + 1];
        
        keko = new PriorityQueue<>();
        
        dijkstra(1);
        
        if (etaisyys[N] == Long.MAX_VALUE) {
            return -1;
        }
        return etaisyys[N];
    }
    
    static void dijkstra(int alkuSolmu) {
        etaisyys[alkuSolmu] = 0;
        keko.add(new X(1, 0));
        
        while (!keko.isEmpty()) {
            X seuraava = keko.poll();
            int solmu = seuraava.solmu;
            if (kasitelty[solmu]) {
                continue;
            }
            kasitelty[solmu] = true;
            for (Kaari kaari : vieruslista[solmu]) {
                long nykyinen = etaisyys[kaari.loppu];
                long uusi = etaisyys[solmu] + kaari.paino;
                if (uusi < nykyinen) {
                    etaisyys[kaari.loppu] = uusi;
                    keko.add(new X(kaari.loppu, uusi));
                }
            }
        }
    }
    
    static void alustaVieruslista(int[] mista, int[] minne, long[] matka) {
        for (int i = 0; i < mista.length; i++) {
            vieruslista[mista[i]].add(new Kaari(minne[i], matka[i]));
            vieruslista[minne[i]].add(new Kaari(mista[i], matka[i]));
        }
//        for (int j = 1; j <= N; j++) {
//            System.out.println("Lähtösolmu: " + j);
//            for (Kaari kaari : vieruslista[j]) {
//                System.out.println(kaari.loppu + ", " + kaari.paino);
//            }
//            System.out.println("-----------------");
//        }
    }
    
    static class Kaari {
        public int loppu;
        public long paino;
        
        public Kaari(int loppu, long paino) {
            this.loppu = loppu;
            this.paino = paino;
        }
    }
    
    static class X implements Comparable {
        public int solmu;
        public long etaisyys;
        
        public X(int solmu, long etaisyys) {
            this.solmu = solmu;
            this.etaisyys = etaisyys;
        }

        @Override
        public int compareTo(Object o) {
            X toinen = (X) o;
            if (this.etaisyys < toinen.etaisyys) {
                return -1;
            } else if (this.etaisyys > toinen.etaisyys) {
                return 1;
            }
            return 0;
        }
    }

    public static void main(String[] args) {
        System.out.println(lyhinReitti(3, new int[]{1, 2}, new int[]{2, 3}, new long[]{5, 3}) + ", oikea: 8");
        System.out.println(lyhinReitti(3, new int[]{1, 1}, new int[]{2, 3}, new long[]{2, 3}) + ", oikea: 3");
        System.out.println(lyhinReitti(3, new int[]{1, 2, 1}, new int[]{3, 3, 2}, new long[]{9, 1, 1}) + ", oikea: 2");
        System.out.println(lyhinReitti(3, new int[]{1, 2, 1}, new int[]{3, 3, 2}, new long[]{1, 9, 9}) + ", oikea: 1");
    }
//    // Bellman-Ford löytää ratkaisut, mutta liian hitaasti
//    public static long lyhinReitti(int n, int[] mista, int[] minne, long[] matka) {
//        N = n;
//        etaisyys = new long[N + 1];
//        etaisyys[1] = 0;
//        for (int i = 2; i <= N; i++) {
//            etaisyys[i] = Long.MAX_VALUE;
//        }
//        for (int i = 1; i <= N - 1; i++) {
//            for (int j = 0; j < mista.length; j++) {
//                long nykyinen = etaisyys[minne[j]];
//                long uusi = etaisyys[mista[j]];
//                if (uusi < Long.MAX_VALUE) {
//                    uusi = uusi + matka[j];
//                }
//                if (uusi < nykyinen) {
//                    etaisyys[minne[j]] = uusi;
//                }
//                // kaari myös toiseen suuntaan
//                nykyinen = etaisyys[mista[j]];
//                uusi = etaisyys[minne[j]];
//                if (uusi < Long.MAX_VALUE) {
//                    uusi = uusi + matka[j];
//                }
//                if (uusi < nykyinen) {
//                    etaisyys[mista[j]] = uusi;
//                }
//            }
//        }
//        if (etaisyys[N] == Long.MAX_VALUE) {
//            return -1;
//        }
//        return etaisyys[N];
//    }
}

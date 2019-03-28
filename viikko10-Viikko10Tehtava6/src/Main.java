
import java.util.*;

public class Main {
    
    static int N;
    static long[] aika;
    static boolean[] kasitelty;
    
    static ArrayList<Kaari>[] vieruslista;
    static PriorityQueue<X> keko;
    
    public static long yhteysaika(int n, int[] mista, int[] minne, long[] milloin) {
        N = n;
        vieruslista = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            vieruslista[i] = new ArrayList<>();
        }
        
        for (int i = 0; i < mista.length; i++) {
            vieruslista[mista[i]].add(new Kaari(minne[i], milloin[i]));
            vieruslista[minne[i]].add(new Kaari(mista[i], milloin[i]));
        }
        
       aika = new long[N + 1];
       for (int i = 1; i <= N; i++) {
           aika[i] = Long.MAX_VALUE;
       }
       kasitelty = new boolean[N + 1];
       
       keko = new PriorityQueue<>();
       
        dijkstra(1);
        
        return aika[N];
    }
    
    static void dijkstra(int alkusolmu) {
        aika[alkusolmu] = 0;
        keko.add(new X(alkusolmu, 0));
        
        while (!keko.isEmpty()) {
            X seuraava = keko.poll();
            int solmu = seuraava.solmu;
            if (kasitelty[solmu]) {
                continue;
            }
            kasitelty[solmu] = true;
            for (Kaari kaari : vieruslista[solmu]) {
                long nykyinen = aika[kaari.loppu];
                long max = Math.max(aika[solmu], kaari.aika);
                if (nykyinen > max) {
                    aika[kaari.loppu] = max;
                    keko.add(new X(kaari.loppu, aika[kaari.loppu]));
                }
            }
        }
    }

    static class Kaari {
        public int loppu;
        public long aika;

        public Kaari(int loppu, long aika) {
            this.loppu = loppu;
            this.aika = aika;
        }
    }
    
    static class X implements Comparable {
        public int solmu;
        public long aika;

        public X(int solmu, long aika) {
            this.solmu = solmu;
            this.aika = aika;
        }

        @Override
        public int compareTo(Object o) {
           X toinen = (X) o;
           if (this.aika < toinen.aika) {
               return -1;
           } else if (this.aika > toinen.aika) {
               return 1;
           } else {
               return 0;
           }
        }
    }
    
    public static void main(String[] args) {
        System.out.println(yhteysaika(4, new int[]{1, 2, 3}, new int[]{2, 3, 4}, new long[]{1, 2, 1})); //2
        System.out.println(yhteysaika(4, new int[]{1, 1, 2, 3}, new int[]{2, 3, 4, 4}, new long[]{1, 5, 8, 7})); //7
        System.out.println(yhteysaika(5, new int[]{1, 2, 2, 3, 4}, new int[]{2, 3, 4, 5, 5}, new long[]{10, 1, 8, 1, 9})); //10
        System.out.println(yhteysaika(5, new int[]{1, 2, 2, 3, 4}, new int[]{2, 3, 4, 5, 5}, new long[]{1, 1, 8, 1, 9})); //1
    }
}

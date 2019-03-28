

//import java.util.*;
//
//public class Kyselyt {
//    
//    static int n = 0;
//    static HashMap<String, Integer> kaupungit = new HashMap<>();
//    static ArrayList<Kaari> kaaret = new ArrayList<>();
//    static int[][] d;
//    static final int MAX = 500 * 1000;
//    static boolean reititLaskettu = false;
//    
//    public void lisaaTie(String alku, String loppu, int pituus) {
//        
//        if (!kaupungit.containsKey(alku)) {
//            kaupungit.put(alku, ++n);
//        }
//        int alkuSolmu = kaupungit.get(alku);
//
//        if (!kaupungit.containsKey(loppu)) {
//            kaupungit.put(loppu, ++n);
//        }
//        int loppuSolmu = kaupungit.get(loppu);
//      
//        kaaret.add(new Kaari(alkuSolmu, loppuSolmu, pituus));
//        kaaret.add(new Kaari(loppuSolmu, alkuSolmu, pituus));
//    }
//    
//    public int reitinPituus(String alku, String loppu) {
////        // Kaupungit
////        kaupungit.entrySet().forEach((mapEntries) -> {
////            System.out.println(mapEntries.getValue() + ": " + mapEntries.getKey());
////        });
//
//            if (!reititLaskettu) {
//                laskeReitit();
//                reititLaskettu = true;
//            }
//            
////        for (int i = 1; i <= n; i++) {
////            for (int j = 1; j <= n; j++) {
////                System.out.print(d[i][j] + ", ");
////            }
////            System.out.println();
////        }
//        //System.out.println("n: " + n);
//        
//        if (!kaupungit.containsKey(alku) || !kaupungit.containsKey(loppu)) {
//            return -1;
//        }
//
//        int mista = kaupungit.get(alku);
//        int minne = kaupungit.get(loppu);
//        if (d[mista][minne] == MAX) {
//            return -1;
//        }
//        return d[mista][minne];
//        
//        
//    }
//    
//    static void laskeReitit() {
//        d = new int[n + 1][n + 1];
//        for (int i = 1; i <= n; i++) {
//            for (int j = 1; j <= n; j++) {
//                if (i == j) {
//                    d[i][i] = 0;
//                } else {
//                    d[i][j] = MAX;
//                }
//            }
//        }
//        // jos lisätään lyhyempi reitti
//        // jo olemassaolevalle reitille
//        kaaret.forEach((kaari) -> {
//            // jos lisätään pitempi reitti ei tehdä mitään
//            // jos lisätään lyhyempi reitti
//            if (d[kaari.alku][kaari.loppu] > kaari.pituus) {
//                d[kaari.alku][kaari.loppu] = kaari.pituus;
//                //d[kaari.loppu][kaari.alku] = kaari.pituus;
//            }
//        });
//        floydWarshall();
//        
//    }
//    
//    static void floydWarshall() {
//        for (int k = 1; k <= n; k++) {
//            for (int i = 1; i <= n; i++) {
//                for(int j = 1; j <= n; j++) {
//                    if (d[i][j] > d[i][k] + d[k][j]) {
//                        d[i][j] = d[i][k] + d[k][j];
//                    }
//                }
//            }
//        }
//    }
//    
//    public static class Kaari {
//        public int alku;
//        public int loppu;
//        public int pituus;
//
//        public Kaari(int alku, int loppu, int pituus) {
//            this.alku = alku;
//            this.loppu = loppu;
//            this.pituus = pituus;
//        }
//    }
//}



import java.util.*;

public class Kyselyt {
    
    final int MAX_KAUPUNGIT = 500;
    final int MAX_ETAISYYS = 500 * 1000;
    
    int n = 0;
    
    int[] etaisyys;
    boolean[] kasitelty;
    HashMap<String, Integer> kaupungit = new HashMap<>();
    ArrayList<Kaari>[] vieruslista;
    PriorityQueue<X> keko;
    
    
    
    public void lisaaTie(String alku, String loppu, int pituus) {
        if (!kaupungit.containsKey(alku)) {
            kaupungit.put(alku, ++n);
        }
        int alkuSolmu = kaupungit.get(alku);
        
        if (!kaupungit.containsKey(loppu)) {
            kaupungit.put(loppu, ++n);
        }
        int loppuSolmu = kaupungit.get(loppu);
        
        vieruslista[alkuSolmu].add(new Kaari(loppuSolmu, pituus));
        vieruslista[loppuSolmu].add(new Kaari(alkuSolmu, pituus));
    }   
    
    public int reitinPituus(String alku, String loppu) {
        // HUOM!!!
        if (alku.equals(loppu)) {
            return 0;
        }
        if (!kaupungit.containsKey(alku) || !kaupungit.containsKey(loppu)) {
            return -1;
        }
        int alkuSolmu = kaupungit.get(alku);
        int loppuSolmu = kaupungit.get(loppu);
        
        etaisyys = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            etaisyys[i] = MAX_ETAISYYS;
        }
        kasitelty = new boolean[n + 1];
        keko = new PriorityQueue<>();
        
        dijkstra(alkuSolmu);
        
        if (etaisyys[loppuSolmu] == MAX_ETAISYYS) {
            return -1;
        }
        return etaisyys[loppuSolmu];
    }
    
    void dijkstra(int alkusolmu) {
        etaisyys[alkusolmu] = 0;
        keko.add(new X(alkusolmu, 0));
        
        while (!keko.isEmpty()) {
            X seuraava = keko.poll();
            int solmu = seuraava.solmu;
            if (kasitelty[solmu]) {
                continue;
            }
            kasitelty[solmu] = true;
            for (Kaari kaari : vieruslista[solmu]) {
                int nykyinen = etaisyys[kaari.loppu];
                int uusi = etaisyys[solmu] + kaari.paino;
                if (uusi < nykyinen) {
                    etaisyys[kaari.loppu] = uusi;
                    keko.add(new X(kaari.loppu, uusi));
                }
            }
        }
    }

    public Kyselyt() {
        vieruslista = new ArrayList[MAX_KAUPUNGIT + 1];
        for (int i = 1; i <= MAX_KAUPUNGIT; i++) {
            vieruslista[i] = new ArrayList<>();
        }
    }
    
    class Kaari {
        public int loppu;
        public int paino;

        public Kaari(int loppu, int paino) {
            this.loppu = loppu;
            this.paino = paino;
        }
    }
    
    class X implements Comparable {
        public int solmu;
        public int etaisyys;

        public X(int solmu, int etaisyys) {
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
            } else {
                return 0;
            }
        }
        
        
    }
}

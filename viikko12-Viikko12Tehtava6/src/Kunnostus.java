import java.util.*;

public class Kunnostus {
    
    HashMap<String, Integer> kaupunki = new HashMap<>();
    List<Kaari> kaarilista = new ArrayList<>();
    int kaupunkeja = 0;
    
    int yhteishinta = 0;
    int kaarienLkm = 0;
    
    // Union-Find
    int[] vanhempi;
    int[] koko;
    
    public void lisaaKaupunki(String nimi) {
        if (!kaupunki.containsKey(nimi)) {
            kaupunki.put(nimi, ++kaupunkeja);
        }
    }
    
    public void lisaaTie(String alku, String loppu, int hinta) {
        kaarilista.add(new Kaari(kaupunki.get(alku), kaupunki.get(loppu), hinta));
    }
    
    public int halvinHinta() {
        vanhempi = new int[kaupunkeja + 1];
        koko = new int[kaupunkeja + 1];
   
        for (int i = 1; i <= kaupunkeja; i++) {
            makeSet(i);
        }
        kruskal();
        if (kaarienLkm == kaupunkeja - 1) {
            return yhteishinta;
        }
        return -1;
    }
    
    void kruskal() {
        kaarilista.sort((Kaari a, Kaari b) -> a.paino - b.paino);
        for (Kaari kaari : kaarilista) {
            int a = find(kaari.alku);
            int b = find(kaari.loppu);
            if (a != b) {
                union(a,b);
                kaarienLkm++;
                yhteishinta+= kaari.paino;
            }
        }
    }
    
    // Union-Find
    void makeSet(int x) {
        vanhempi[x] = x;
        koko[x] = 1;
    }
    
    int find(int x) {
        while(x!= vanhempi[x]) {
            x = vanhempi[x];
        }
        return x;
    }
    
    void union(int x, int y) {
        if (koko[x] >= koko[y]) {
            vanhempi[y] = x;
            koko[x] += koko[y];
        } else {
            vanhempi[x] = y;
            koko[y] += koko[x];
        }
    }
    
    class Kaari implements Comparable{
        int alku;
        int loppu;
        int paino;

        public Kaari(int alku, int loppu, int paino) {
            this.alku = alku;
            this.loppu = loppu;
            this.paino = paino;
        }

        @Override
        public int compareTo(Object o) {
            Kaari toinen = (Kaari) o;
            return this.paino - toinen.paino;
        }

        @Override
        public String toString() {
            return alku + " - " + loppu + ": " + paino;
        }
        
    }
}

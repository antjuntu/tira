import java.util.*;

public class UusiVerkko {
    
    static final int V = 1000000;
    
    int[] vanhempi = new int[V + 1];
    int[] koko = new int[V + 1];
    
    public UusiVerkko() {
        for (int i = 1; i <= V; i++) {
            makeSet(i);
        }
    }
    
    public void lisaaYhteys(int a, int b) {
        if (find(a) != find(b)) {
            union(find(a), find(b));
        }
    }
    
    public boolean onkoSamassa(int a, int b) {
        return find(a) == find(b);
    }
    
    // Union-Find
    void makeSet(int x) {
        vanhempi[x] = x;
        koko[x] = 1;
    }
    
    int find(int x) {
        while (x != vanhempi[x]) {
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
}

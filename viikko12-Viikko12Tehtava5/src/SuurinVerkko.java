import java.util.*;

public class SuurinVerkko {
    
    static final int V = 1000000;
    // suurimman yhtenäisen komponentin koko
    int max;
    
    int[] vanhempi;
    int[] koko;
    
    public SuurinVerkko() {
        vanhempi = new int[V + 1];
        koko = new int[V + 1];
        for (int i = 1; i <= V; i++) {
            vanhempi[i] = i;
            koko[i] = 1;
        }
        max = 1;
    }
    
    public void lisaaYhteys(int a, int b) {
        int x = find(a);
        int y = find(b);
        if (x != y) {
            union(x,y);
        }
    }
    
    public int suurinVerkko() {
        return max;
    }
    
    // Union-Find
    int find(int x) {
        while (x != vanhempi[x]) {
            x = vanhempi[x];
        }
        return x;
    }
    
    void union (int x, int y) {
        if (koko[x] < koko[y]) {
            int temp = x;
            x = y;
            y = temp;
        }
        // nyt koko[x] >= koko[y]
        vanhempi[y] = x;
        koko[x] += koko[y];
        if (koko[x] > max) {
            max = koko[x];
        }
    }
}

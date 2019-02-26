import java.util.*;

public class Mediaani {
    
    PriorityQueue<Integer> keko = new PriorityQueue<>();
    
    public Mediaani() {
        keko = new PriorityQueue<>();
    }
    
    public void lisaaLuku(int x) {
        keko.add(x);
    }
    
    public int mediaani() {
        int n = keko.size() / 2;
        if (keko.size() % 2 == 1) {
            n++;
        }
        int[] array = new int[n];
        
        int i = 0;
        while (i < n) {
            array[i] = keko.poll();
            i++;
        }
        int med = array[--i];
        for (int j = array.length - 1; j >= 0; j--) {
            keko.add(array[j]);
        }
        return med;
    }
}

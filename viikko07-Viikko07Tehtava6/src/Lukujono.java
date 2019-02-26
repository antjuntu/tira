import java.util.*;

public class Lukujono {
    
    static PriorityQueue<Long> heap;
    
    public long laskeLuku(int kohta) {
        heap = new PriorityQueue<>();
        heap.add(2l);
        heap.add(3l);
        heap.add(5l);
        int counter = 0;
        long n = 0;
        while (counter < kohta) {
            n = heap.poll();
            while (heap.peek() == n) {
                heap.poll();
            }
            heap.add(2l * n);
            heap.add(3l * n);
            heap.add(5l * n);
            counter++;
        }
        return n;
    }
}

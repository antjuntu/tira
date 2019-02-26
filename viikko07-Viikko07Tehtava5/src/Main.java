
import java.util.*;

public class Main {
    
    
    public static long lyhinAika(int[] koneet, int maara) {
        PriorityQueue<Kone> heap = new PriorityQueue<>();
        long time = 0l;
        for (int i = 0; i < koneet.length; i++) {
            heap.add(new Kone(koneet[i], koneet[i]));
        }
        while (maara > 0) {
            Kone next = heap.poll();
            time = next.priority;
            next.priority += next.operatingTime;
            heap.add(next);
            maara--;
        }
        return time;
    }
    
    static class Kone implements Comparable{
        private long priority;
        private long operatingTime;

        @Override
        public int compareTo(Object other) {
            Kone kone = (Kone) other;
            if (this.priority - kone.priority == 0l) {
                return 0;
            } else if (this.priority - kone.priority < 0l) {
                return -1;
            } else {
                return 1;
            }
        }

        public Kone(int priority, int length) {
            this.priority = priority;
            this.operatingTime = length;
        }
    }

    public static void main(String[] args) {
        System.out.println(lyhinAika(new int[]{1}, 5)); // 5
        System.out.println(lyhinAika(new int[]{1, 1, 1}, 6)); // 2
        System.out.println(lyhinAika(new int[]{5, 1, 1}, 6)); // 3
        System.out.println(lyhinAika(new int[]{1, 2, 3, 4}, 10)); // 6
    }
}

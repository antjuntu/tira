import java.util.*;

public class Mediaani {
    
    // Maksimikeko, jossa mediaania pienemmät tai yhtäsuuret
    PriorityQueue<Integer> pienemmat;
    // Minimikeko, jossa mediaania isommat
    PriorityQueue<Integer> suuremmat;
    int mediaani;
    int n;
    
    public Mediaani() {
        pienemmat = new PriorityQueue<>(20, Collections.reverseOrder());
        suuremmat = new PriorityQueue<>();
        n = 0;
        mediaani = 0;
    }
    
    public void lisaaLuku(int x) {
        if (n == 0) {
            mediaani = x;
            n++;
            return;
        }
        if (n % 2 == 1) {
            if (x <= mediaani) {
                pienemmat.add(x);
                suuremmat.add(mediaani);
                mediaani = pienemmat.poll();
            } else {
                suuremmat.add(x);
            }
        } else { // n % 2 == 0
            if (x <= mediaani) {
                pienemmat.add(x);
            } else {
                suuremmat.add(x);
                pienemmat.add(mediaani);
                mediaani = suuremmat.poll();
            }
        }
        n++;
    }
    
    public int mediaani() {
        return mediaani;
    }
}

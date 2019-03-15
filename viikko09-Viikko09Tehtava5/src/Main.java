import java.util.*;

public class Main {
    public static void main(String[] args) {
        Reitit r = new Reitit();
        int[][] kartta = {
            {1,1,1,1,1,1,1,1},
            {1,0,1,0,1,0,0,1},
            {1,1,1,0,1,0,1,1},
            {1,0,1,0,1,0,0,1},
            {1,1,1,1,1,1,1,1},
        };
        r.asetaKartta(kartta);
        System.out.println(r.onkoReitti(1,1,1,1)); // true
        System.out.println(r.onkoReitti(1,1,3,6)); // false
        System.out.println(r.onkoReitti(1,6,3,6)); // true
        System.out.println(r.onkoReitti(1,2,3,2)); // false
    }
}

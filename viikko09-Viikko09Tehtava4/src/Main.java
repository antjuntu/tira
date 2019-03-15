import java.util.*;

public class Main {
    public static void main(String[] args) {
        Huoneet h = new Huoneet();
        int[][] kartta = {
            {1,1,1,1,1,1,1,1},
            {1,0,1,0,1,0,0,1},
            {1,1,1,0,1,0,1,1},
            {1,0,1,0,1,0,0,1},
            {1,1,1,1,1,1,1,1},
        };
        System.out.println(h.laske(kartta)); // 4
    }
}

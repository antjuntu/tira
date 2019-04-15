import java.util.*;

public class Main {
    public static void main(String[] args) {
        int[][] ruudukko =
        {   {0,1,0,0,1},
            {0,1,0,0,0},
            {1,0,1,1,1},
            {0,0,0,0,1},
            {0,1,0,0,0}
        };
        Ruudukko r = new Ruudukko();
        System.out.println(r.laske(ruudukko)); // 3
    }
}

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Labyrintti l = new Labyrintti();
        int[][] kartta = {
            {1,1,1,1,1,1,1,1},
            {1,2,1,0,0,3,0,1},
            {1,0,1,0,1,1,0,1},
            {1,0,0,0,0,0,0,1},
            {1,1,1,1,1,1,1,1},
        };
        System.out.println(l.laske(kartta)); // 8
    }
}

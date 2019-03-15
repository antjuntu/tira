
import java.util.*;

public class Main {

    static int[][] etaisyys;
    static int n;

    public static int kierros(int[][] et) {
        etaisyys = et;
        n = etaisyys[0].length;
        
        int[] reitti = new int[n + 1];
        //reitti[0] = 0;
        //reitti[n] = 0;
        
        boolean[] mukana = new boolean[n];
        mukana[0] = true;
        
        return laske(reitti, mukana, 1, 0);
    }
    
    private static int laske(int[] reitti, boolean[] mukana, int k, int pituus) {
        if (k == n) {
            return pituus + etaisyys[reitti[n - 1]][0];
        }
        int paras = Integer.MAX_VALUE;
        for (int i = 1; i < n; i++) {
            if (!mukana[i]) {
                reitti[k] = i;
                mukana[i] = true;
                int arvo = laske(reitti, mukana, k + 1, pituus + etaisyys[reitti[k - 1]][i]);
                paras = Math.min(paras, arvo);
                mukana[i] = false;
            }
        }
        return paras;
    }

    public static void main(String[] args) {
        int[][] e1 = {{0, 3, 2, 1},
        {3, 0, 4, 2},
        {2, 4, 0, 4},
        {1, 2, 4, 0}};
        System.out.println(kierros(e1));    //9

        int[][] e2 = {{0, 2, 1, 1},
        {2, 0, 1, 1},
        {1, 1, 0, 2},
        {1, 1, 2, 0}};
        System.out.println(kierros(e2));    //4

        int[][] e3 = {{0, 1, 2, 1},
        {1, 0, 1, 2},
        {2, 1, 0, 1},
        {1, 2, 1, 0}};
        System.out.println(kierros(e3));    //4

        int[][] e4 = {{0, 1, 2, 3},
        {1, 0, 4, 5},
        {2, 4, 0, 6},
        {3, 5, 6, 0}};
        System.out.println(kierros(e4));    //14
    }
}

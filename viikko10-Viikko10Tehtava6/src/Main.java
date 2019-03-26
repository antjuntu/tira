
import java.util.*;

public class Main {

    public static long yhteysaika(int n, int[] mista, int[] minne, long[] milloin) {
        return 0l;
    }

    public static void main(String[] args) {
        System.out.println(yhteysaika(4, new int[]{1, 2, 3}, new int[]{2, 3, 4}, new long[]{1, 2, 1})); //2
        System.out.println(yhteysaika(4, new int[]{1, 1, 2, 3}, new int[]{2, 3, 4, 4}, new long[]{1, 5, 8, 7})); //7
        System.out.println(yhteysaika(5, new int[]{1, 2, 2, 3, 4}, new int[]{2, 3, 4, 5, 5}, new long[]{10, 1, 8, 1, 9})); //10
        System.out.println(yhteysaika(5, new int[]{1, 2, 2, 3, 4}, new int[]{2, 3, 4, 5, 5}, new long[]{1, 1, 8, 1, 9})); //1
    }
}

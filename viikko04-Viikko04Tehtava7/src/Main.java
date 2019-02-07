
import java.util.*;

public class Main {

    public static int[] suuremmat(int[] luvut) {
        return luvut;
    }

    public static void main(String[] args) {
        int[] tulos1 = suuremmat(new int[]{1, 2, 3, 4, 5});
        System.out.println(Arrays.toString(tulos1));
        int[] tulos2 = suuremmat(new int[]{5, 4, 3, 2, 1});
        System.out.println(Arrays.toString(tulos2));
        int[] tulos3 = suuremmat(new int[]{4, 3, 2, 1, 5});
        System.out.println(Arrays.toString(tulos3));
        int[] tulos4 = suuremmat(new int[]{1, 5, 2, 4, 3});
        System.out.println(Arrays.toString(tulos4));
    }
}


import java.util.*;

public class Main {


    public static int kierros(int[][] et) {
        return 0;
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

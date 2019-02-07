import java.util.*;

public class Main {
    public static void main(String[] args) {
        ListanLyhennys l = new ListanLyhennys();
        int[] lista1 = {1,2,2,1,1,1,3};
        int[] lista2 = {1,2,3,4,5,6,7,8};
        int[] lista3 = {1,1,1,1,2,2,2,2};
        int[] lista4 = {1,2,3,4,4,3,2,1};
        int[] lista5 = {1,2,1,1,2,2,1,1,2,2,1};
        System.out.println(l.laske(lista1)); // 1
        System.out.println(l.laske(lista2)); // 8
        System.out.println(l.laske(lista3)); // 0
        System.out.println(l.laske(lista4)); // 0
        System.out.println(l.laske(lista5)); // 3
    }
}

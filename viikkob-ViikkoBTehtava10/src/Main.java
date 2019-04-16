import java.util.*;

public class Main {
    public static void main(String[] args) {
        ParasKierto p = new ParasKierto();
        int[] taulukko1 = {1,3,2,4,5};
        int[] taulukko2 = {2,4,5,1,3};
        int[] taulukko3 = {5,4,3,2,1};
        int[] taulukko4 = {1,5,2,4,3};
        System.out.println(p.laske(taulukko1, taulukko2)); // 5
        System.out.println(p.laske(taulukko1, taulukko3)); // 3
        System.out.println(p.laske(taulukko3, taulukko4)); // 2
        System.out.println(p.laske(taulukko1, taulukko4)); // 3
    }
}

import java.util.*;

public class Main {
    public static void main(String[] args) {
        YhtaMonta y = new YhtaMonta();
        int[] taulukko1 = {1,2,1,2,1};
        int[] taulukko2 = {1,1,1,1,1};
        int[] taulukko3 = {1,1,1,1,2};
        int[] taulukko4 = {1,2,2,3,3,3};
        System.out.println(y.laske(taulukko1)); // 1
        System.out.println(y.laske(taulukko2)); // 0
        System.out.println(y.laske(taulukko3)); // 1
        System.out.println(y.laske(taulukko4)); // 2
    }
}

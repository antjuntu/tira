import java.util.*;

public class Main {
    public static void main(String[] args) {
        SamatLuvut s = new SamatLuvut();
        int[] taulukko1 = {1,2,2,1,2};
        int[] taulukko2 = {1,2,3,4,5};
        int[] taulukko3 = {1,1,1,1,1};
        System.out.println(s.laske(taulukko1)); // 4
        System.out.println(s.laske(taulukko2)); // 0
        System.out.println(s.laske(taulukko3)); // 10
    }
}

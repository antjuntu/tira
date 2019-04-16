import java.util.*;

public class Main {
    public static void main(String[] args) {
        Vierekkain v = new Vierekkain();
        int[] taulukko1 = {1,2,3,4,5};
        int[] taulukko2 = {1,1,2,2,3};
        int[] taulukko3 = {1,1,1,1,1};
        System.out.println(Arrays.toString(v.muodosta(taulukko1))); // [1,2,3,4,5]
        System.out.println(Arrays.toString(v.muodosta(taulukko2))); // [1,2,1,2,3]
        System.out.println(Arrays.toString(v.muodosta(taulukko3))); // null
    }
}

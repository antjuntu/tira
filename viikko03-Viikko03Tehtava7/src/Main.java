import java.util.*;

public class Main {
    public static void main(String[] args) {
        Inversiot i = new Inversiot();
        int[] taulukko1 = i.muodosta(4,3);
        System.out.println(Arrays.toString(taulukko1)); // [3,1,4,2]
        
        int[] taulukko2 = i.muodosta(4,0);
        System.out.println(Arrays.toString(taulukko2)); // [1,1,1,1]
        
        int[] taulukko3 = i.muodosta(4,6);
        System.out.println(Arrays.toString(taulukko3)); // [4,3,2,1]
        
        int[] taulukko4 = i.muodosta(3,1);
        System.out.println(Arrays.toString(taulukko4)); // [2,1,3]
    }
}


import java.util.*;

public class Main {

    public static int valienMaara(long[] taulukko, long k) {
        int lkm = 0;
        int ala = 0; // välin alaraja
        int yla = 0; // välin yläraja + 1
        long summa = 0; // tutkittavan välin summa
        
        while (ala < taulukko.length && yla < taulukko.length) {
            if (summa < k) {
                summa += taulukko[yla];
                yla++;
            }
            if (summa > k){
                summa -= taulukko[ala];
                ala++;
            }
            if (summa == k) {
                lkm++;
                summa -= taulukko[ala];
                ala++;
            }
        }
       
        return lkm;
    }

    public static void main(String[] args) {
        System.out.println(valienMaara(new long[]{1, 1, 1, 1}, 4)); // 1
        System.out.println(valienMaara(new long[]{1, 1, 1, 1}, 1)); // 4
        System.out.println(valienMaara(new long[]{1, 2, 3, 4}, 3)); // 2
        System.out.println(valienMaara(new long[]{1, 3, 1, 2}, 3)); // 2
        // löytyykö viimeinen alkio????
        System.out.println(valienMaara(new long[]{1, 3, 1, 2, 3}, 3)); // 3
        //
        System.out.println(valienMaara(new long[]{5, 2, 4, 2, 9, 1, 9, 1, 1, 2, 3, 9, 2, 5, 5, 5, 9, 9, 3, 5}, 40)); // 1
        System.out.println(valienMaara(new long[]{5, 2, 4, 2, 9, 1, 9, 1, 1, 2}, 11)); // 4
        
    }
}


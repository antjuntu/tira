
import java.util.*;

public class Main {

    public static int valienMaara(long[] taulukko, long k) {
        int lkm = 0;
        int ala = 0; // välin alaraja
        int yla = 0; // välin yläraja
        long summa = 0; // tutkittavan välin summa
        //  0  1  2  3  4  5  6  7  8  9
        // {1, 3, 1, 2, 3}
        while (ala < taulukko.length && yla < taulukko.length) {
            if (summa > k) {
                summa -= taulukko[ala];
                ala++;
                continue;
            }
            if (summa == k) {
                lkm++;
                summa -= taulukko[ala];
                ala++;
            } else {
                summa += taulukko[yla];
                yla++;
            }
        }
        return lkm;
    }

    public static void main(String[] args) {
//        System.out.println(valienMaara(new long[]{1, 1, 1, 1}, 4)); // 1
//        System.out.println(valienMaara(new long[]{1, 1, 1, 1}, 1)); // 4
//        System.out.println(valienMaara(new long[]{1, 2, 3, 4}, 3)); // 2
//        System.out.println(valienMaara(new long[]{1, 3, 1, 2}, 3)); // 2
        // Ei löydä viimeistä yhden pituista väliä!!!!!
        System.out.println(valienMaara(new long[]{1, 3, 1, 2, 3}, 3)); // 3
        //
//        System.out.println(valienMaara(new long[]{5, 2, 4, 2, 9, 1, 9, 1, 1, 2, 3, 9, 2, 5, 5, 5, 9, 9, 3, 5}, 40)); // 1
//        System.out.println(valienMaara(new long[]{5, 2, 4, 2, 9, 1, 9, 1, 1, 2}, 11)); // 4
        
    }
}

//            if (summa < k) {
//                summa += taulukko[yla];
//                // tarkista meneekö summa yli
////                if (summa == k) {
////                    lkm++;
////                    summa -= taulukko[ala];
////                    ala++;
////                }
//                yla++;
//            } else if (summa > k) {
//                // vähennä kunnes summa <= k
//                summa -= taulukko[ala];
//                ala++;
//                //yla++; // ei kasvateta jos summa > k
//            }
//                
//            if (summa == k) {
//                lkm++;
//                summa -= taulukko[ala];
//                ala++;
//                //yla++;
//            }

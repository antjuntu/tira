import java.util.*;

public class Inversiot {   
    // O(n^2) ratkaisu
    public int[] muodosta(int n, long k) {
        int[] tulos = new int[n];

        for (int i = 0; i < n; i++) {
            tulos[i] = i + 1;
        }
        if (k == 0) {
            return tulos;
        }
        int lkm = 0;
        while (true) {
            int j = 0;
            while (j < n - 1) {
                if (tulos[j] < tulos[j + 1]) {
                    int temp = tulos[j];
                    tulos[j] = tulos[j + 1];
                    tulos[j + 1] = temp;
                    lkm++;
                    if (lkm == k) {
                        return tulos;
                    }
                }
                j++;
            }
        }
        
    }    
}

//// O(n^2) ratkaisu
//    public int[] muodosta(int n, long k) {
//        int[] tulos = new int[n];
//
//        for (int i = 0; i < n; i++) {
//            tulos[i] = i + 1;
//        }
//        if (k == 0) {
//            return tulos;
//        }
//        int lkm = 0;
//        while (true) {
//            int j = 0;
//            while (j < n - 1) {
//                if (tulos[j] < tulos[j + 1]) {
//                    int temp = tulos[j];
//                    tulos[j] = tulos[j + 1];
//                    tulos[j + 1] = temp;
//                    lkm++;
//                    if (lkm == k) {
//                        return tulos;
//                    }
//                }
//                j++;
//            }
//        }
//        
//    }   

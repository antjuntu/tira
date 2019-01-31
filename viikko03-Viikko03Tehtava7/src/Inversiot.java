import java.util.*;

public class Inversiot {   
    // O(n)
    public int[] muodosta(int n, long k) {
        int pienet = 1;
        int suuret = n;
        long inversiot = k;
        int[] tulos = new int[n];
        
        int i = 0; // seuraavan sijoitettavan luvun paikka tulos-taulukossa
        while (inversiot > 0) {
            if (inversiot >= n - i - 1) {
                tulos[i] = suuret;
                suuret--;
                inversiot -= n - i - 1;
            } else {
                tulos[i] = pienet;
                pienet++;
            }
            i++;
        }
        // sijoitetaan loput luvut 
        while(i < n) {
            tulos[i] = pienet;
            pienet++;
            i++;
        }
        return tulos;
    }    
}

//// O(n^2)
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
//    }   

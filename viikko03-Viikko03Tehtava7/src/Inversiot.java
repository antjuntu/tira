import java.util.*;

public class Inversiot {    
    public int[] muodosta(int n, long k) {
        int[] tulos = new int[n];
        // käsittele tapaus k = 0
        if (k == 0) {
            for (int i = 0; i < n; i++) {
                tulos[i] = 1;
            }
            return tulos;
        }
        // k > 0
        for (int i = 0; i < n; i++) {
            tulos[i] = i + 1;
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

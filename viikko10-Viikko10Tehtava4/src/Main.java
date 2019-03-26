
import java.util.*;

public class Main {

    static int N;
    static long[] etaisyys;
    
    // Bellman-Ford
    public static long lyhinReitti(int n, int[] mista, int[] minne, long[] matka) {
        N = n;
        etaisyys = new long[N + 1];
        etaisyys[1] = 0;
        for (int i = 2; i <= N; i++) {
            etaisyys[i] = Long.MAX_VALUE;
        }
        for (int i = 1; i <= N - 1; i++) {
            for (int j = 0; j < mista.length; j++) {
                long nykyinen = etaisyys[minne[j]];
                long uusi = etaisyys[mista[j]];
                if (uusi < Long.MAX_VALUE) {
                    uusi = uusi + matka[j];
                }
                if (uusi < nykyinen) {
                    etaisyys[minne[j]] = uusi;
                }
                // kaari myös toiseen suuntaan
                nykyinen = etaisyys[mista[j]];
                uusi = etaisyys[minne[j]];
                if (uusi < Long.MAX_VALUE) {
                    uusi = uusi + matka[j];
                }
                if (uusi < nykyinen) {
                    etaisyys[mista[j]] = uusi;
                }
            }
        }
        if (etaisyys[N] == Long.MAX_VALUE) {
            return -1;
        }
        return etaisyys[N];
    }

    public static void main(String[] args) {
        System.out.println(lyhinReitti(3, new int[]{1, 2}, new int[]{2, 3}, new long[]{5, 3}) + ", oikea: 8");
        System.out.println(lyhinReitti(3, new int[]{1, 1}, new int[]{2, 3}, new long[]{2, 3}) + ", oikea: 3");
        System.out.println(lyhinReitti(3, new int[]{1, 2, 1}, new int[]{3, 3, 2}, new long[]{9, 1, 1}) + ", oikea: 2");
        System.out.println(lyhinReitti(3, new int[]{1, 2, 1}, new int[]{3, 3, 2}, new long[]{1, 9, 9}) + ", oikea: 1");
    }
}

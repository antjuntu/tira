

public class Summataulukko {

    private long[] summa;
    
    Summataulukko(long[] taulukko) {
       summa = new long[taulukko.length];
       summa[0] = taulukko[0];
       
       for (int i = 1; i < taulukko.length; i++) {
           summa[i] = summa[i - 1] + taulukko[i];
       }
    }

    long summa(int l, int r) {
        if (l == 0) {
            return summa[r];
        } else {
            return summa[r] - summa[l - 1];
        }
    }
}

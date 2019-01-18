public class Kolikot {

    // Haluttu kolikoiden summa
    private int summa;
    // Kolikoiden määrä
    private int n;
    // Kolikot taulukon alkuun [0,..,n-1]
    private int[] kolikot = new int[20];
    
    // kuuluuko kolikko yhdistelmään, vai ei
    private boolean[] mukana;
    
    // Löydettyjen kolikkoyhdistelmien määrä
    private int lkm;
    
    public void lisaaKolikko(int arvo) {
        this.kolikot[this.n] = arvo;
        this.n++;
    }
    
    public int laskeYhdistelmat(int summa) {
        this.summa = summa;
        this.lkm = 0;
        this.mukana = new boolean[n];
        this.laske(0);
        return this.lkm;
    }    
    
    private void laske(int m) {
        if (m == this.n) {
            int summa1 = 0;
            for (int i = 0; i < this.n; i++) {
                if (mukana[i]) {
                    summa1 += kolikot[i];
                }
            }
            if (summa1 == this.summa) {
                this.lkm++;
            }
        } else {
            mukana[m] = true;
            laske(m + 1);
            mukana[m] = false;
            laske(m + 1);
        }
    }
}

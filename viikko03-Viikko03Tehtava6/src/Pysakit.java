import java.util.*;

public class Pysakit {    
    
    public int laske(int[] talot, int x) {
        if (talot.length == 0) {
            return 0;
        }
        Arrays.sort(talot);
        
        // Asetetaan 1. pysäkki paikkaan talot[0] + x
        int edellinenPysakki = talot[0] + x;
        int lkm = 1; // pysäkkien määrä
        
        int i = 1; // seuraavan talon indeksi
        while (i < talot.length) {
            // Tarvitaanko uusi pysäkki?
            if (talot[i] > edellinenPysakki + x) {
                lkm++;
                edellinenPysakki = talot[i] + x;
            }
            // Jos talon etäisyys pysäkistä on korkeintaan x,
            // ohitetaan talo.
            i++;
        }
        return lkm;
    }   
    
}

import java.util.*;

public class Nopat {
    
    static long[] taulu = new long[51];
    
    static {
        alustaTaulu();
    }
    
    public long laske(int n) {
        return taulu[n];
    }
    
    private static void alustaTaulu() {
        taulu[0] = 1L;
        taulu[1] = 1L;
        for (int i = 2; i <= 6; i++) {
            for(int j = i - 1; j >= 0; j--) {
                taulu[i] += taulu[j];
            }
        }
        for (int i = 7; i <= 50; i++) {
            taulu[i] = taulu[i-1] + taulu[i-2] + taulu[i-3] + taulu[i-4] + taulu[i-5] + taulu[i-6];
        }
        
    }
   
}

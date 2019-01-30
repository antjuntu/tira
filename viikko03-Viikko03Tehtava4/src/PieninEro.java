import java.util.*;

public class PieninEro {    
    public int laske(int[] taulukko) {
        Arrays.sort(taulukko);
        int min = taulukko[taulukko.length - 1] - taulukko[0];
        int i = 1;
        while (i < taulukko.length) {
            int ero = taulukko[i] - taulukko[i-1];
            if (ero < min) {
                min = ero;
            }
            i++;
        }
        return min;
    }    
}

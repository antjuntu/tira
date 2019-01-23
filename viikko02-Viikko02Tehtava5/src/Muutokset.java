public class Muutokset {    
    public int laske(int[] taulukko) {
        int changes = 0;
     
        int i = 0;
        while (i < taulukko.length - 1) {
            if (taulukko[i] == taulukko[i + 1]) {
                changes++;
                taulukko[i + 1] += taulukko[i];
                if (i + 2 < taulukko.length) {
                    taulukko[i + 1] += taulukko[i + 2];
                }
            }
            i++;
        }
        
        return changes;
    }    
    
}

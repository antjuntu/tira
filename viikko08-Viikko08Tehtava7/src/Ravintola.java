import java.util.*;

public class Ravintola {
    
    static final int MAX = 1001;
    static final int KOKONAIS_HINNAN_MAX = 1000000;
    
    // paketti i: maara[i] ja hinta[i]
    int[] maara;
    int[] hinta;
    // montako pakettia on saatavilla
    int k;
    
    int[] siipienMaara;
    
    public Ravintola() {
        maara = new int[MAX];
        hinta = new int[MAX];
        siipienMaara = new int[MAX];
        k = 0; 
        //siipienMaara[0] = 0;
    }
    
    public void lisaaPaketti(int maara, int hinta) {
        ++k;
        this.maara[k] = maara;
        this.hinta[k] = hinta;
        //int maxSiipiaPaketilla = MAX / maara;
        //for (int i = 0; i < maxSiipiaPaketilla; i++) {
            for (int j = siipienMaara.length; j > 0; j--) {
                if (siipienMaara[j] > 0) {
                    if (siipienMaara[j + maara] > 0) {
                        siipienMaara[j + maara] = Math.min(siipienMaara[j + maara], siipienMaara[j] + hinta);
                    } else { // siipienMaara[j + maara] == 0
                        siipienMaara[j + maara] = siipienMaara[j] + hinta;
                    }
                }
            //}
            // käsittele siipienMaara[j] indeksi j = 0
            if (siipienMaara[maara] > hinta) {
                siipienMaara[maara] = hinta;
            }
        }
    }
    

    /**
     * 
     * @param maara 1 - 1000
     * @return maara 1 - KOKONAIS_HINNAN_MAX
     */
    public int halvinHinta(int maara) {
        return hinta[maara];
    }
}

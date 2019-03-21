import java.util.*;

public class Reitit {
    
    // Asetetaan kartta[y][x] = komponentin numero (2,3,...) vierailluille solmuille
    int[][] kartta;
    boolean[][] vierailtu;
    int nY;
    int nX;
    
    // Selvitä verkon yhtenäiset komponentit
    public void asetaKartta(int[][] kartta) {
        this.kartta = kartta;
        nY = kartta.length;
        nX = kartta[0].length;
        vierailtu = new boolean[nY][nX];
        
        int komponentinNumero = 2;
        for (int y = 1; y < nY - 1; y++) {
            for (int x = 1; x < nX - 1; x++) {
                if (kartta[y][x] == 1) {
                    continue;
                }
                if (!vierailtu[y][x]) {
                    syvyysHaku(y, x, komponentinNumero);
                    komponentinNumero++;
                }
            }
        }
    }
    
    // Tutki kuuluuko alku- ja loppupiste samaan komponenttiin
    public boolean onkoReitti(int y1, int x1, int y2, int x2) {
        if (kartta[y1][x1] == 1 || kartta[y2][x2] == 1) {
            return false;
        }
        return kartta[y1][x1] == kartta[y2][x2];
    }
    
    private void syvyysHaku(int y, int x, int komponentinNumero) {
        if (vierailtu[y][x]) {
            return;
        }
        if (kartta[y][x] == 1) {
            return;
        }
        if (y <= 0 || y >= nY - 1 || x <= 0 || x >= nX - 1) {
            return;
        }
        vierailtu[y][x] = true;
        kartta[y][x] = komponentinNumero;
        
        syvyysHaku(y - 1, x, komponentinNumero);
        syvyysHaku(y + 1, x, komponentinNumero);
        syvyysHaku(y, x - 1, komponentinNumero);
        syvyysHaku(y, x + 1, komponentinNumero);
    }
}

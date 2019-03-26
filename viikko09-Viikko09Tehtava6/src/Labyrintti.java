import java.util.*;

public class Labyrintti {
    
    int[][] kartta;
    
    ArrayDeque<Solmu> jono;
    int[][] etaisyys;
    boolean[][] vierailtu;
    int nY;
    int nX;
    
    int startY;
    int startX;
    
    int endX;
    int endY;
    
    public int laske(int[][] kartta) {
        this.kartta = kartta;
        jono = new ArrayDeque<>();
        nY = kartta.length;
        nX = kartta[0].length;
        
        etaisyys = new int[nY][nX];
        for (int y = 0; y < nY; y++) {
            for (int x = 0; x < nX; x++) {
                etaisyys[y][x] = Integer.MAX_VALUE;
                if (kartta[y][x] == 2) {
                    startY = y;
                    startX = x;
                }
                if (kartta[y][x] == 3) {
                    endY = y;
                    endX = x;
                }
            }
        }
        
        vierailtu = new boolean[nY][nX];
        
        leveysHaku(startY, startX);
        
        if (etaisyys[endY][endX] == Integer.MAX_VALUE) {
            return -1;
        }
        return etaisyys[endY][endX];
    }
    
    public void leveysHaku(int y, int x) {
        vierailtu[y][x] = true;
        etaisyys[y][x] = 0;
        jono.addLast(new Solmu(y, x));
        
        while (!jono.isEmpty()) {
            Solmu next = jono.removeFirst();
            int sY = next.y;
            int sX = next.x;
            
            // naapurit
            // ylä
            if (sY - 1 > 0 && !vierailtu[sY - 1][sX] && kartta[sY][sX] != 1) {
                vierailtu[sY - 1][sX] = true;
                etaisyys[sY - 1][sX] = etaisyys[sY][sX] + 1;
                jono.addLast(new Solmu(sY -1, sX));
            }
            // ala
            if (sY + 1 < nY - 1 && !vierailtu[sY + 1][sX] && kartta[sY][sX] != 1) {
                vierailtu[sY + 1][sX] = true;
                etaisyys[sY + 1][sX] = etaisyys[sY][sX] + 1;
                jono.addLast(new Solmu(sY + 1, sX));
            }
            // vasen
            if (sX - 1 > 0 && !vierailtu[sY][sX - 1] && kartta[sY][sX] != 1) {
                vierailtu[sY][sX - 1] = true;
                etaisyys[sY][sX - 1] = etaisyys[sY][sX] + 1;
                jono.addLast(new Solmu(sY, sX - 1));
            }
            // oikea
            if (sX + 1 < nX - 1 && !vierailtu[sY][sX + 1] && kartta[sY][sX] != 1) {
                vierailtu[sY][sX + 1] = true;
                etaisyys[sY][sX + 1] = etaisyys[sY][sX] + 1;
                jono.addLast(new Solmu(sY, sX + 1));
            }
        }
    }
    
    public static class Solmu {
        public int y;
        public int x;
        
        public Solmu(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}


public class Huoneet {
    
    static int nY;
    static int nX;
    static boolean[][] vierailtu;    
    static int huoneet;
    
    public int laske(int[][] kartta) {
        huoneet = 0;
        nY = kartta.length;
        nX = kartta[0].length;
        //System.out.println("nY: " + nY + ", nX: " + nX);
        vierailtu = new boolean[nY][nX];
        for (int y = 1; y < nY - 1; y++) {
            for (int x = 1; x < nX - 1; x++) {
                if (kartta[y][x] == 1) {
                    continue;
                }
                if (!vierailtu[y][x]) {
                    huoneet++;
                    syvyysHaku(y, x, kartta);
                }
            }
        }
        
        return huoneet;
    }
    
    private static void syvyysHaku(int y, int x, int[][] kartta) {
        if (y <= 0 || y >= nY - 1 || x <= 0 || x >= nX - 1) {
            return;
        }
        if (kartta[y][x] == 1) {
            return;
        }
        if (vierailtu[y][x]) {
            return;
        }
        vierailtu[y][x] = true;
        syvyysHaku(y - 1, x, kartta);
        syvyysHaku(y + 1, x, kartta);
        syvyysHaku(y, x - 1, kartta);
        syvyysHaku(y, x + 1, kartta);
    }
}

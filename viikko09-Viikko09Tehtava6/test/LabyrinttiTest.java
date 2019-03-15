import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;
import fi.helsinki.cs.tmc.edutestutils.Points;

@Points("9.6")
public class LabyrinttiTest {
    static int[][] kartta1, kartta2, kartta3, kartta4, kartta5;
    
    @BeforeClass
    public static void luoKartat() {
        int n = 1000;
        kartta1 = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || i == n-1 || j == 0 || j == n-1) {
                    kartta1[i][j] = 1;
                }
            }
        }
        kartta2 = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                kartta2[i][j] = 1;
            }
        }
        Random r = new Random(1337);
        kartta3 = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int x = r.nextInt(100);
                if (i == 0 || i == n-1 || j == 0 || j == n-1 || x < 35) {
                    kartta3[i][j] = 1;
                }
            }
        }                
        kartta4 = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int x = r.nextInt(100);
                if (i == 0 || i == n-1 || j == 0 || j == n-1 || x < 33) {
                    kartta4[i][j] = 1;
                }
            }
        }                
        kartta5 = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int x = r.nextInt(100);
                if (i == 0 || i == n-1 || j == 0 || j == n-1 || x < 40) {
                    kartta5[i][j] = 1;
                }
            }
        }                
    }
    
    void testi(int[][] kartta, int alkuY, int alkuX, int loppuY, int loppuX, int oikea) {
        Labyrintti l = new Labyrintti();
        int n = kartta.length;
        int m = kartta[0].length;
        int[][] kopio = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                kopio[i][j] = kartta[i][j];
            }
        }
        kopio[alkuY][alkuX] = 2;
        kopio[loppuY][loppuX] = 3;
        int tulos = l.laske(kopio);
        if (tulos == oikea) return;
        fail("Metodisi antaa tuloksen "+tulos+", vaikka oikea tulos on "+oikea);
    }
    
    @Test(timeout = 1000)
    public void pieniTesti() {
        int[][] kartta = {
            {1,1,1,1,1,1},
            {1,0,0,1,0,1},
            {1,1,1,1,0,1},
            {1,0,0,0,0,1},
            {1,0,1,1,0,1},
            {1,0,0,0,0,1},
            {1,1,1,1,1,1}};
        testi(kartta,1,1,1,2,1);
        testi(kartta,1,1,1,4,-1);
        testi(kartta,1,4,3,1,5);
        testi(kartta,1,4,5,1,7);
    }
    
    @Test(timeout = 1000)
    public void suuriTesti1() {
        int n = 1000;
        testi(kartta1,1,1,n-2,n-2,2*(n-3));
    }

    @Test(timeout = 1000)
    public void suuriTesti2() {
        int n = 1000;
        testi(kartta2,1,1,n-2,n-2,-1);
    }

    @Test(timeout = 1000)
    public void suuriTesti3() {
        int n = 1000;
        testi(kartta3,1,1,n-2,n-2,2116);
    }

    @Test(timeout = 1000)
    public void suuriTesti4() {
        int n = 1000;
        testi(kartta4,1,1,n-2,n-2,2042);
    }

    @Test(timeout = 1000)
    public void suuriTesti5() {
        int n = 1000;
        testi(kartta5,1,1,n-2,n-2,-1);
    }
}

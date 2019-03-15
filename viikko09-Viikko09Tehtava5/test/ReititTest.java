import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;
import fi.helsinki.cs.tmc.edutestutils.Points;

@Points("9.5")
public class ReititTest {
    static int[][] kartta1, kartta2, kartta3, kartta4;
    
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
                if (i == 0 || i == n-1 || j == 0 || j == n-1 || x < 25) {
                    kartta3[i][j] = 1;
                }
            }
        }                
        kartta4 = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int x = r.nextInt(100);
                if (i == 0 || i == n-1 || j == 0 || j == n-1 || x < 50) {
                    kartta4[i][j] = 1;
                }
            }
        }                
    }        
    
    @Test(timeout = 1000)
    public void pieniTesti() {
        int[][] kartta = {
            {1,1,1,1,1,1},
            {1,0,0,0,0,1},
            {1,0,1,0,1,1},
            {1,0,0,0,1,1},
            {1,1,1,1,0,1},
            {1,0,1,0,0,1},
            {1,1,1,1,1,1}};
        Reitit r = new Reitit();
        r.asetaKartta(kartta);
        int n = kartta.length;
        int m = kartta[0].length;
        int t = 0;
        for (int y1 = 0; y1 < n; y1++) {
            for (int x1 = 0; x1 < m; x1++) {
                for (int y2 = 0; y2 < n; y2++) {
                    for (int x2 = 0; x2 < m; x2++) {
                        if (r.onkoReitti(y1,x1,y2,x2)) t++;
                    }
                }
            }
        }
        if (t == 91) return;
        fail("Luokkasi toimii väärin pienessä testissä");
    }

    void testi(int[][] kartta, int oikea) {
        Reitit r = new Reitit();
        r.asetaKartta(kartta);
        Random u = new Random(1337);
        int n = 1000;
        int t = 0;
        for (int i = 0; i < 100000; i++) {
            int y1 = u.nextInt(n);
            int x1 = u.nextInt(n);
            int y2 = u.nextInt(n);
            int x2 = u.nextInt(n);
            if (r.onkoReitti(y1, x1, y2, x2)) t++;
        }
        if (t == oikea) return;
        fail("Luokkasi toimii väärin suuressa testissä");
    }
    
    @Test(timeout = 1000)
    public void suuriTesti1() {
        testi(kartta1,99174);
    }

    @Test(timeout = 1000)
    public void suuriTesti2() {
        testi(kartta2,0);
    }

    @Test(timeout = 1000)
    public void suuriTesti3() {
        testi(kartta3,55145);
    }

    @Test(timeout = 1000)
    public void suuriTesti4() {
        testi(kartta4,6);
    }
}

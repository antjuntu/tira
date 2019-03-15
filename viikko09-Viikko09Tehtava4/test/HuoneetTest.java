import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;
import fi.helsinki.cs.tmc.edutestutils.Points;

@Points("9.4")
public class HuoneetTest {
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
                if (i == 0 || i == n-1 || j == 0 || j == n-1 || x < 75) {
                    kartta4[i][j] = 1;
                }
            }
        }                
    }        
    
    public void testi(int[][] kartta, int oikea) {
        Huoneet h = new Huoneet();
        int tulos = h.laske(kartta);
        if (tulos == oikea) return;
        fail("Metodisi antaa tuloksen "+tulos+", mutta oikea tulos on "+oikea);
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
        testi(kartta,3);
    }

    @Test(timeout = 1000)
    public void suuriTesti1() {
        testi(kartta1,1);
    }

    @Test(timeout = 1000)
    public void suuriTesti2() {
        testi(kartta2,0);
    }

    @Test(timeout = 1000)
    public void suuriTesti3() {
        testi(kartta3,3423);
    }

    @Test(timeout = 1000)
    public void suuriTesti4() {
        testi(kartta4,129228);
    }
}

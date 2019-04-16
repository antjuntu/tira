import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;
import fi.helsinki.cs.tmc.edutestutils.Points;

@Points("B.8")
public class YhtaMontaTest {
    static int[] taulu1, taulu2, taulu3, taulu4, taulu5, taulu6, taulu7;
    
    @BeforeClass
    public static void luoTaulukot() {
        int n = 1000000;
        taulu1 = new int[n];
        for (int i = 0; i < n; i++) {
            taulu1[i] = 1;
        }
        taulu2 = new int[n];
        for (int i = 0; i < n; i++) {
            taulu2[i] = i+1;
        }
        Random r = new Random(1337);
        taulu3 = new int[n];
        for (int i = 0; i < n; i++) {
            taulu3[i] = r.nextInt(5)+1;
        }
        taulu4 = new int[n];
        for (int i = 0; i < n; i++) {
            taulu4[i] = r.nextInt(1000000000)+1;
        }
        taulu5 = new int[n];
        for (int i = 0; i < n; i++) {
            taulu5[i] = r.nextInt(100)+1;
        }
        taulu6 = new int[n];
        for (int i = 0; i < n-1; i++) {
            taulu6[i] = 1;
        }
        taulu6[n-1] = 2;
        taulu7 = new int[n];
        for (int i = 0; i < n; i++) {
            taulu7[i] = i < 33333 ? 1 : 2;
        }
    }        
    
    public void testi(int[] taulukko, int oikea) {
        YhtaMonta y = new YhtaMonta();
        int tulos = y.laske(taulukko);
        if (tulos == oikea) return;
        fail("Oikea tulos on "+oikea+", mutta metodisi antaa "+tulos);
    }
    
    @Test(timeout = 1000)
    public void pienetTestit() {
        testi(new int[] {1},0);
        testi(new int[] {1,1},0);
        testi(new int[] {1,2},0);
        testi(new int[] {1,1,1},0);
        testi(new int[] {1,1,2},1);
        testi(new int[] {1,2,1},1);
        testi(new int[] {2,1,1},1);
        testi(new int[] {1,2,3},0);
        testi(new int[] {1,1,2,2},0);
        testi(new int[] {1,2,1,2},0);
        testi(new int[] {1,2,3,4},0);
        testi(new int[] {1,1,1,1},0);
        testi(new int[] {1,1,1,2},1);
        testi(new int[] {1,1,1,2,2,2,3,3,3,3,3},2);
        testi(new int[] {1,1,1,1,1,2,2,2,2,2,3},1);
        testi(new int[] {1,2,2,3,3,3,4,4,4,4},4);
    }
    
    @Test(timeout = 1000)
    public void suuriTesti1() {
        testi(taulu1,0);
    }

    @Test(timeout = 1000)
    public void suuriTesti2() {
        testi(taulu2,0);
    }

    @Test(timeout = 1000)
    public void suuriTesti3() {
        testi(taulu3,1145);
    }

    @Test(timeout = 1000)
    public void suuriTesti4() {
        testi(taulu4,511);
    }

    @Test(timeout = 1000)
    public void suuriTesti5() {
        testi(taulu5,24700);
    }

    @Test(timeout = 1000)
    public void suuriTesti6() {
        testi(taulu6,1);
    }

    @Test(timeout = 1000)
    public void suuriTesti7() {
        testi(taulu7,33333);
    }
}

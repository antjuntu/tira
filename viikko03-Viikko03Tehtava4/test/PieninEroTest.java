import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;
import fi.helsinki.cs.tmc.edutestutils.Points;

@Points("3.4")
public class PieninEroTest {

    static int[] suuri1, suuri2, suuri3, suuri4;
    
    @BeforeClass
    public static void luoTaulukot() {
        Random r = new Random(1337);
        int n = 1000000;
        suuri1 = new int[n];
        for (int i = 0; i < n; i++) {
            suuri1[i] = 1;
        }
        suuri2 = new int[n];
        for (int i = 0; i < n; i++) {
            suuri2[i] = i+1;
        }
        suuri3 = new int[n];
        for (int i = 0; i < n; i++) {
            suuri3[i] = r.nextInt(1000000000)+1;
        }
        suuri4 = new int[n];
        suuri4[0] = 123;
        for (int i = 1; i < n; i++) {
            suuri4[i] = suuri4[i-1]+r.nextInt(500)+123;
        }
        for (int i = n-1; i >= 0; i--) {
            int k = r.nextInt(i+1);
            int t = suuri4[k];
            suuri4[k] = suuri4[i];
            suuri4[i] = t;
        }
    }
    
    private void testi(int[] taulukko, int oikea) {
        PieninEro e = new PieninEro();
        int tulos = e.laske(taulukko);
        if (tulos == oikea) return;
        if (taulukko.length <= 10) {
            fail("Taulukossa "+Arrays.toString(taulukko)+" oikea vastaus on "+oikea+", mutta metodisi antaa "+tulos);
        } else {
            fail("Oikea vastaus on "+oikea+", mutta metodisi antaa "+tulos); 
        }
    }
    
    @Test(timeout = 1000)
    public void pienetTestit() {
        testi(new int[] {1,1},0);
        testi(new int[] {1,2},1);
        testi(new int[] {1,1,1,1},0);
        testi(new int[] {1,2,3,4},1);
        testi(new int[] {4,3,2,1},1);
        testi(new int[] {1,7,4,9},2);
        testi(new int[] {1,1000000000},999999999);
        testi(new int[] {10,20,30,40},10);
        testi(new int[] {32,16,8,4,2,1},1);
        testi(new int[] {1,1000,500,1,1000},0);
    }

    @Test(timeout = 1000)
    public void suuriTesti1() {
        testi(suuri1,0);
    }

    @Test(timeout = 1000)
    public void suuriTesti2() {
        testi(suuri2,1);
    }

    @Test(timeout = 1000)
    public void suuriTesti3() {
        testi(suuri3,0);
    }

    @Test(timeout = 1000)
    public void suuriTesti4() {
        testi(suuri4,123);
    }
}

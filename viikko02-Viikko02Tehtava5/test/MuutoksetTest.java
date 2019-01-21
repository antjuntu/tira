import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;
import fi.helsinki.cs.tmc.edutestutils.Points;

@Points("2.5")
public class MuutoksetTest {

    static int[] suuri1, suuri2, suuri3, suuri4;
    
    @BeforeClass
    public static void luoTaulukot() {
        Random r = new Random(1337);
        int n = 1000000;
        suuri1 = new int[n];
        for (int i = 0; i < n; i++) {
            suuri1[i] = r.nextInt(1000) == 0 ? 2 : 1;
        }
        suuri2 = new int[n];
        for (int i = 0; i < n; i++) {
            suuri2[i] = r.nextInt(2)+1;
        }
        suuri3 = new int[n];
        for (int i = 0; i < n; i++) {
            suuri3[i] = r.nextInt(10)+1;
        }
        suuri4 = new int[n];
        for (int i = 0; i < n; i++) {
            suuri4[i] = r.nextInt(1000000000)+1;
        }
    }
    
    private void testi(int[] taulukko, int oikea) {
        Muutokset m = new Muutokset();
        int tulos = m.laske(taulukko);
        if (tulos == oikea) return;
        if (taulukko.length <= 10) {
            fail("Taulukossa "+Arrays.toString(taulukko)+" oikea vastaus on "+oikea+", mutta metodisi antaa "+tulos);
        } else {
            fail("Oikea vastaus on "+oikea+", mutta metodisi antaa "+tulos); 
        }
    }
    
    @Test(timeout = 1000)
    public void pienetTestit() {
        testi(new int[] {1},0);
        testi(new int[] {1,1},1);
        testi(new int[] {1,2},0);
        testi(new int[] {1,1,1},1);
        testi(new int[] {1,1,2},1);
        testi(new int[] {1,2,1},0);
        testi(new int[] {2,1,1},1);
        testi(new int[] {1,1,1,1},2);
        testi(new int[] {1,1,1,2},1);
        testi(new int[] {1,1,2,1},1);
        testi(new int[] {1,2,1,1},1);
        testi(new int[] {2,1,1,1},1);
        testi(new int[] {1,2,2,1},1);
        testi(new int[] {1,2,1,2},0);
        testi(new int[] {2,1,2,1},0);
        testi(new int[] {1,2,2,3,3,3,4},2);
    }

    @Test(timeout = 1000)
    public void suuriTesti1() {
        testi(suuri1,499221);
    }

    @Test(timeout = 1000)
    public void suuriTesti2() {
        testi(suuri2,333109);
    }

    @Test(timeout = 1000)
    public void suuriTesti3() {
        testi(suuri3,91324);
    }

    @Test(timeout = 1000)
    public void suuriTesti4() {
        testi(suuri4,0);
    }
}

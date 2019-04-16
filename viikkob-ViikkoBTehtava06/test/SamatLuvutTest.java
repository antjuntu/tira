import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;
import fi.helsinki.cs.tmc.edutestutils.Points;

@Points("B.6")
public class SamatLuvutTest {
    static int[] taulu1, taulu2, taulu3, taulu4;
    
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
    }        
    
    public void testi(int[] taulukko, long oikea) {
        SamatLuvut s = new SamatLuvut();
        long tulos = s.laske(taulukko);
        if (tulos == oikea) return;
        fail("Oikea tulos on "+oikea+", mutta metodisi antaa "+tulos);
    }
    
    @Test(timeout = 1000)
    public void pienetTestit() {
        testi(new int[] {1},0);
        testi(new int[] {1,1},1);
        testi(new int[] {1,2},0);
        testi(new int[] {1,1,1},3);
        testi(new int[] {1,1,2},1);
        testi(new int[] {1,2,1},1);
        testi(new int[] {2,1,1},1);
        testi(new int[] {1,2,3},0);
        testi(new int[] {1,1,2,2},2);
        testi(new int[] {1,2,1,2},2);
        testi(new int[] {1,2,3,4},0);
        testi(new int[] {1,1,1,1},6);
        testi(new int[] {1,1,2,2,1,2,3,1,2,3},13);
    }
    
    @Test(timeout = 1000)
    public void suuriTesti1() {
        testi(taulu1,499999500000L);
    }

    @Test(timeout = 1000)
    public void suuriTesti2() {
        testi(taulu2,0);
    }

    @Test(timeout = 1000)
    public void suuriTesti3() {
        testi(taulu3,99999559715L);
    }

    @Test(timeout = 1000)
    public void suuriTesti4() {
        testi(taulu4,511);
    }
}

import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;
import fi.helsinki.cs.tmc.edutestutils.Points;

@Points("B.10")
public class ParasKiertoTest {    
    static int[] taulu1, taulu2, taulu3, taulu4, taulu5, taulu6;
    
    @BeforeClass
    public static void luoTaulukot() {
        int n = 1000000;
        taulu1 = new int[n];
        for (int i = 0; i < n; i++) {
            taulu1[i] = i+1;
        }
        taulu2 = new int[n];
        for (int i = 0; i < n; i++) {
            taulu2[i] = n-i;
        }
        taulu3 = new int[n];
        for (int i = 0; i < n; i++) {
            taulu3[i] = i+1;
        }
        Random r = new Random(1337);
        for (int i = n-1; i >= 0; i--) {
            int k = r.nextInt(i+1);
            int t = taulu3[k]; taulu3[k] = taulu3[i]; taulu3[i] = t;
        }
        taulu4 = new int[n];
        for (int i = 0; i < n; i++) {
            taulu4[i] = i+1;
        }
        for (int i = n-1; i >= 0; i--) {
            int k = r.nextInt(i+1);
            int t = taulu4[k]; taulu4[k] = taulu4[i]; taulu4[i] = t;
        }
        taulu5 = new int[n];
        for (int i = 0; i < n; i++) {
            taulu5[i] = (i+n/2)%n+1;
        }
        taulu6 = new int[n];
        for (int i = 0; i < n/2; i++) {
            taulu6[i] = i+1;
        }
        for (int i = n/2; i < n; i++) {
            taulu6[i] = i+2;
        }
        taulu6[n-1] = n/2+1;
    }            
    
    public void testi(int[] taulukko1, int[] taulukko2, int oikea) {
        ParasKierto p = new ParasKierto();
        int tulos = p.laske(taulukko1, taulukko2);
        if (tulos == oikea) return;
        fail("Oikea tulos on "+oikea+", mutta metodisi antaa "+tulos);
    }

    @Test(timeout = 1000)
    public void pienetTestit() {
        testi(new int[] {1}, new int[] {1}, 1);
        testi(new int[] {1,2}, new int[] {1,2}, 2);
        testi(new int[] {1,2}, new int[] {2,1}, 2);
        testi(new int[] {1,2,3}, new int[] {1,2,3}, 3);
        testi(new int[] {1,2,3}, new int[] {1,3,2}, 1);
        testi(new int[] {1,2,3}, new int[] {2,1,3}, 1);
        testi(new int[] {1,2,3}, new int[] {2,3,1}, 3);
        testi(new int[] {1,2,3}, new int[] {3,1,2}, 3);
        testi(new int[] {1,2,3}, new int[] {3,2,1}, 1);
        testi(new int[] {1,4,2,3}, new int[] {4,3,2,1}, 2);
        testi(new int[] {2,1,4,3}, new int[] {1,2,3,4}, 2);
        testi(new int[] {2,3,4,1}, new int[] {4,1,2,3}, 4);
        testi(new int[] {4,3,2,1}, new int[] {1,2,3,4}, 2);
    }

    @Test(timeout = 1000)
    public void suuriTesti1() {
        testi(taulu1,taulu2,2);
    }

    @Test(timeout = 1000)
    public void suuriTesti2() {
        testi(taulu1,taulu5,1000000);
    }

    @Test(timeout = 1000)
    public void suuriTesti3() {
        testi(taulu3,taulu4,9);
    }

    @Test(timeout = 1000)
    public void suuriTesti4() {
        testi(taulu2,taulu4,8);
    }

    @Test(timeout = 1000)
    public void suuriTesti5() {
        testi(taulu2,taulu5,2);
    }

    @Test(timeout = 1000)
    public void suuriTesti6() {
        testi(taulu1,taulu6,500000);
    }
}

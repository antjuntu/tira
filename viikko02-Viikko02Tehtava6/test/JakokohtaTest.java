import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;
import fi.helsinki.cs.tmc.edutestutils.Points;

@Points("2.6")
public class JakokohtaTest {

    static int[] suuri1, suuri2, suuri3, suuri4, suuri5, suuri6;
    
    @BeforeClass
    public static void luoTaulukot() {
        Random r = new Random(1337);
        int n = 1000000;
        suuri1 = new int[n];
        for (int i = 0; i < n; i++) {
            suuri1[i] = i+1;
        }
        suuri2 = new int[n];
        for (int i = 0; i < n; i++) {
            suuri2[i] = 1000000000-i;
        }
        suuri3 = new int[n];
        for (int i = 0; i < n; i++) {
            suuri3[i] = i%2 == 0 ? 2+i: i;
        }
        suuri4 = new int[n];
        for (int i = 0; i < n; i++) {
            suuri4[i] = r.nextInt(1000000000)+1;
        }
        suuri5 = new int[n];
        for (int i = 0; i < n; i++) {
            suuri5[i] = 1;
        }
        suuri6 = new int[n];
        int a = 1;
        int b = 0;
        int k = 1;
        for (int i = 0; i < n; i++) {
            if (b == k) {
                k++;
                a += k;
                b = 0;
            }
            suuri6[i] = a-b;
            b++;
        }
    }
    
    private void testi(int[] taulukko, int oikea) {
        Jakokohta j = new Jakokohta();
        int tulos = j.laske(taulukko);
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
        testi(new int[] {1,2,3,4,5},4);
        testi(new int[] {5,4,3,2,1},0);
        testi(new int[] {3,2,1,5,4},1);
        testi(new int[] {1,1,1,1,1},0);
        testi(new int[] {1,1,1,2,2,2},1);
        testi(new int[] {2,2,2,1,1,1},0);
        testi(new int[] {2,1,4,3,6,5,8,7},3);
        testi(new int[] {2,3,1},0);
    }

    @Test(timeout = 1000)
    public void suuriTesti1() {
        testi(suuri1,999999);
    }

    @Test(timeout = 1000)
    public void suuriTesti2() {
        testi(suuri2,0);
    }

    @Test(timeout = 1000)
    public void suuriTesti3() {
        testi(suuri3,499999);
    }

    @Test(timeout = 1000)
    public void suuriTesti4() {
        testi(suuri4,0);
    }

    @Test(timeout = 1000)
    public void suuriTesti5() {
        testi(suuri5,0);
    }

    @Test(timeout = 1000)
    public void suuriTesti6() {
        testi(suuri6,1413);
    }
}

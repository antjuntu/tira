import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;
import fi.helsinki.cs.tmc.edutestutils.Points;

@Points("4.5")
public class ListanLyhennysTest {

    static int[] suuri1, suuri2, suuri3;
    
    @BeforeClass
    public static void luoTaulukot() {
        Random r = new Random(1337);
        int n = 1000000;
        suuri1 = new int[n];
        for (int i = 0; i < n; i++) {
            suuri1[i] = r.nextInt(1000000000)+1;
        }
        suuri2 = new int[n];
        for (int i = 0; i < n; i++) {
            suuri2[i] = 1;
        }
        suuri3 = new int[n];
        for (int i = 0; i < n; i++) {
            suuri3[i] = r.nextInt(2)+1;
        }
    }    
    
    private void testi(int[] taulukko, int oikea) {
        String kuvaus = "";
        if (taulukko.length <= 10) kuvaus = Arrays.toString(taulukko);
        ListanLyhennys l = new ListanLyhennys();
        int tulos = l.laske(taulukko);
        if (oikea == tulos) return;
        if (taulukko.length <= 10) {
            fail("Taulukolle "+kuvaus+" oikea tulos on "+oikea+" mutta metodisi antaa "+tulos);
        } else {
            fail("Oikea tulos on "+oikea+" mutta metodisi antaa "+tulos);
        }
    }
        
    @Test(timeout = 1000)
    public void pienetTestit() {
        testi(new int[] {1},1);
        testi(new int[] {1,1},0);
        testi(new int[] {1,2},2);
        testi(new int[] {1,1,1},1);
        testi(new int[] {1,2,3,4,5},5);
        testi(new int[] {1,2,3,4,4,3,2,1},0);
        testi(new int[] {1,2,3,4,1,2,3,4},8);
        testi(new int[] {1000000000,1000000000},0);
        testi(new int[] {1,2,2,1,1,2,2,1},0);
        testi(new int[] {1,2,2,1,2,1,2,2,1},1);
        testi(new int[] {1,2,2,2,2,2,2,2,2,1},0);
        testi(new int[] {1,2,2,2,2,2,2,2,1},3);
    }
    
    @Test(timeout = 1000)
    public void suuriTesti1() {
        testi(suuri1,1000000);
    }

    @Test(timeout = 1000)
    public void suuriTesti2() {
        testi(suuri2,0);
    }

    @Test(timeout = 1000)
    public void suuriTesti3() {
        testi(suuri3,666);
    }

}

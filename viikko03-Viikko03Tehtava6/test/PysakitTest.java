import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;
import fi.helsinki.cs.tmc.edutestutils.Points;

@Points("3.6")
public class PysakitTest {

    static int[] suuri;
    
    @BeforeClass
    public static void luoTaulukot() {
        Random r = new Random(1337);
        int n = 1000000;
        suuri = new int[n];
        for (int i = 0; i < n; i++) {
            suuri[i] = r.nextInt(1000000000)+1;
        }
    }
    
    private void testi(int[] talot, int x, int oikea) {
        String kuvaus = "";
        if (talot.length <= 10) kuvaus = Arrays.toString(talot);
        Pysakit p = new Pysakit();
        int tulos = p.laske(talot,x);
        if (tulos == oikea) return;
        if (talot.length <= 10) {
            fail("Kun talot ovat "+kuvaus+" ja x on " + x + ", oikea vastaus on "+oikea+", mutta metodisi antaa "+tulos);
        } else {
            fail("Oikea vastaus on "+oikea+", mutta metodisi antaa "+tulos); 
        }
    }
    
    @Test(timeout = 1000)
    public void pienetTestit() {
        testi(new int[] {1},1,1);
        testi(new int[] {1,2},1,1);
        testi(new int[] {1,2,3},1,1);
        testi(new int[] {1,1,1,1},1,1);
        testi(new int[] {1,2,1,2},1,1);
        testi(new int[] {7,2,9,8,5,1},1,3);
        testi(new int[] {7,2,9,8,5,1},2,2);
        testi(new int[] {7,2,9,8,5,1},3,2);
        testi(new int[] {7,2,9,8,5,1},4,1);
        testi(new int[] {7,2,9,8,5,1},5,1);
    }

    @Test(timeout = 1000)
    public void suuriTesti1() {
        testi(suuri,1,997495);
    }

    @Test(timeout = 1000)
    public void suuriTesti2() {
        testi(suuri,10,980010);
    }
    
    @Test(timeout = 1000)
    public void suuriTesti3() {
        testi(suuri,100,832906);
    }    

    @Test(timeout = 1000)
    public void suuriTesti4() {
        testi(suuri,1000,333049);
    }    

    @Test(timeout = 1000)
    public void suuriTesti5() {
        testi(suuri,10000,47626);
    }    

    @Test(timeout = 1000)
    public void suuriTesti6() {
        testi(suuri,1000000,500);
    }    

    @Test(timeout = 1000)
    public void suuriTesti7() {
        testi(suuri,100000000,5);
    }        
    
    @Test(timeout = 1000)
    public void suuriTesti8() {
        testi(suuri,1000000000,1);
    }    
}

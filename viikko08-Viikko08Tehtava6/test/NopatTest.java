import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;
import fi.helsinki.cs.tmc.edutestutils.Points;

@Points("8.6")
public class NopatTest {
    
    public void testi(int x, long oikea) {
        Nopat n = new Nopat();
        long tulos = n.laske(x);
        if (tulos == oikea) return;
        fail("Kun summa on "+x+", oikea vastaus on "+oikea+" mutta metodisi antaa "+tulos);
    }
    
    @Test(timeout = 1000)
    public void pienetTestit() {
        testi(1,1);
        testi(2,2);
        testi(3,4);
        testi(4,8);
        testi(5,16);
        testi(6,32);
        testi(7,63);
        testi(8,125);
        testi(9,248);
        testi(10,492);
    }

    @Test(timeout = 1000)
    public void suuriTesti1() {
        testi(15,15109);
    }

    @Test(timeout = 1000)
    public void suuriTesti2() {
        testi(25,14247536);
    }

    @Test(timeout = 1000)
    public void suuriTesti3() {
        testi(42,1623288080257L);
    }    
    
    @Test(timeout = 1000)
    public void suuriTesti4() {
        testi(50,389043663364337L);
    }
}

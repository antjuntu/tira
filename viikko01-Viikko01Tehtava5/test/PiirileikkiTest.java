import org.junit.Test;
import static org.junit.Assert.*;
import fi.helsinki.cs.tmc.edutestutils.Points;

@Points("1.5")
public class PiirileikkiTest {
    private void testi(int n, int oikea) {
        Piirileikki p = new Piirileikki();
        int tulos = p.viimeinen(n);
        if (tulos == oikea) return;
        fail("Tapauksessa n=" + n + " oikea vastaus on "+oikea+", mutta metodisi antaa "+tulos);
    }    
    
    @Test(timeout = 1000)
    public void pikkutesti() {
        int[] testit = {1,1,3,1,3,5,7,1,3,5};
        for (int i = 0; i < 10; i++) testi(i+1,testit[i]);
    }

    @Test(timeout = 1000)
    public void isotesti1() {
        testi(12345,8307);
    }

    @Test(timeout = 1000)
    public void isotesti2() {
        testi(54321,43107);
    }

    @Test(timeout = 1000)
    public void isotesti3() {
        testi(524288,1);
    }
    
    @Test(timeout = 1000)
    public void isotesti4() {
        testi(999999,951423);
    }
    
    @Test(timeout = 1000)
    public void isotesti5() {
        testi(1000000,951425);
    }
}

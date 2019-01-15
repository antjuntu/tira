import org.junit.Test;
import static org.junit.Assert.*;
import fi.helsinki.cs.tmc.edutestutils.Points;

@Points("1.3")
public class OnnenlukuTest {
    private void testi(int n, boolean oikea) {
        Onnenluku o = new Onnenluku();
        boolean tulos = o.tarkasta(n);
        if (tulos == oikea) return;
        if (oikea) fail("Luku "+n+" on onnenluku, mutta metodi palauttaa 'false'");
        if (!oikea) fail("Luku "+n+" ei ole onnenluku, mutta metodi palauttaa 'true'");
    }
    
    @Test(timeout = 1000)
    public void pikkutesti() {
        for (int i = 1; i <= 10; i++) {
            testi(i,i == 4 || i == 7);
        }
    }

    @Test(timeout = 1000)
    public void isotesti1() {
        testi(44,true);
        testi(47,true);
        testi(74,true);
        testi(77,true);
        testi(47474747,true);
        testi(74747474,true);
        testi(444444444,true);
        testi(477774777,true);
        testi(744474747,true);
        testi(777777777,true);
    }

    @Test(timeout = 1000)
    public void isotesti2() {
        testi(45,false);
        testi(123,false);
        testi(1777,false);
        testi(7177,false);
        testi(7717,false);
        testi(7771,false);
        testi(123456789,false);
        testi(474737474,false);
        testi(777777787,false);
        testi(1000000000,false);
    }    
}

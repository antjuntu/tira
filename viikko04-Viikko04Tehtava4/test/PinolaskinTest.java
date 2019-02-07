import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;
import fi.helsinki.cs.tmc.edutestutils.Points;

@Points("4.4")
public class PinolaskinTest {

    private void testi(String lasku, long oikea) {
        Pinolaskin p = new Pinolaskin();
        long tulos = p.laske(lasku);
        if (oikea == tulos) return;
        if (lasku.length() <= 30) {
            fail("Laskun "+lasku+" oikea tulos on "+oikea+" mutta metodisi antaa "+tulos);
        } else {
            fail("Laskun oikea tulos on "+oikea+" mutta metodisi antaa "+tulos);
        }
    }
        
    @Test(timeout = 1000)
    public void pienetTestit() {
        testi("1",1);
        testi("1 1 +",2);
        testi("1 1 *",1);
        testi("1 2 3 4 5 + + + +",15);
        testi("1 2 3 4 5 * * * *",120);
        testi("1 2 3 4 5 + * + *",29);
        testi("1 2 3 4 5 * + * +",47);
        testi("1 2 3 + 4 + 5 + +",15);
        testi("1000000000 1000000000 +",2000000000);
        testi("1000000000 1000000000 *",1000000000000000000L);
        testi("1 2 3 4 5 6 7 8 9 * * * * * * * * ",362880);
    }
    
    @Test(timeout = 1000)
    public void suuriTesti1() {
        String lasku = "1";
        for (int i = 0; i < 99; i++) lasku += " 1";
        for (int i = 0; i < 99; i++) lasku += " +";
        testi(lasku,100);
    }

    @Test(timeout = 1000)
    public void suuriTesti2() {
        String lasku = "2";
        for (int i = 0; i < 59; i++) lasku += " 2";
        for (int i = 0; i < 59; i++) lasku += " *";
        testi(lasku,1152921504606846976L);
    }
    
    @Test(timeout = 1000)
    public void suuriTesti3() {
        String lasku = "123456789";
        for (int i = 0; i < 59; i++) {
            lasku += " 1 +";
        }
        testi(lasku,123456848);
    }
}

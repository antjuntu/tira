import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;
import fi.helsinki.cs.tmc.edutestutils.Points;

@Points("5.7")
public class SamatArvotTest {
    @Test(timeout = 1000)
    public void testi() {
        SamatArvot s = new SamatArvot();
        String m1 = s.merkkijono1();
        String m2 = s.merkkijono2();
        if (m1.equals(m2)) fail("Merkkijonot ovat samat");
        if (m1.hashCode() != m2.hashCode()) fail("Hajautusarvot eivät ole samat");
    }
}

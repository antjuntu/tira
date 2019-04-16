import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;
import fi.helsinki.cs.tmc.edutestutils.Points;

@Points("B.9")
public class BittijonoTest {
    @Test(timeout = 1000)
    public void pieniTesti() {
        Bittijono b = new Bittijono();
        int u = 0;
        for (int i = 1; i <= 1000; i++) {
            u ^= i*b.haeBitti(i);
        }
        if (u == 532) return;
        fail("Metodisi toimii väärin pienessä testissä");
    }

    @Test(timeout = 1000)
    public void suuriTesti() {
        Bittijono b = new Bittijono();
        int u = 0;
        Random r = new Random(1337);
        for (int i = 1; i <= 1000; i++) {
            u ^= i*b.haeBitti(r.nextInt(1000000000)+1);
        }
        if (u == 205) return;
        fail("Metodisi toimii väärin suuressa testissä");
    }
}

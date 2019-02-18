import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;
import fi.helsinki.cs.tmc.edutestutils.Points;

@Points("6.8")
public class HotelliTest {
    
    @Test(timeout = 1000)
    public void pieniTesti() {
        Hotelli h = new Hotelli();
        h.lisaaHuone(3);
        h.lisaaHuone(8);
        h.lisaaHuone(4);
        h.lisaaHuone(4);
        boolean virhe = false;
        if (h.varaaHuone(2) != 3) virhe = true;
        if (h.varaaHuone(2) != 4) virhe = true;
        h.lisaaHuone(1);
        if (h.varaaHuone(2) != 4) virhe = true;
        h.lisaaHuone(9);
        if (h.varaaHuone(9) != 9) virhe = true;
        if (h.varaaHuone(9) != 0) virhe = true;
        if (h.varaaHuone(1) != 1) virhe = true;
        if (h.varaaHuone(1) != 8) virhe = true;
        if (h.varaaHuone(1) != 0) virhe = true;
        if (virhe) fail("Luokkasi toimii väärin pienessä testissä.");
    }

    @Test(timeout = 1000)
    public void suuriTesti1() {
        Hotelli h = new Hotelli();
        int n = 100000;
        for (int i = 1; i <= n; i++) h.lisaaHuone(i);
        long s = 0;
        for (int i = 1; i <= n; i++) s += h.varaaHuone(i);
        if (s != 5000050000L) fail("Luokkasi toimii väärin suuressa testissä.");
    }

    @Test(timeout = 1000)
    public void suuriTesti2() {
        Hotelli h = new Hotelli();
        Random r = new Random(1337);
        int n = 100000;
        for (int i = 1; i <= n; i++) h.lisaaHuone(r.nextInt(1000000000)+1);
        long s = 0;
        for (int i = 1; i <= n; i++) s += h.varaaHuone(r.nextInt(1000000000)+1);
        if (s != 49968666535173L) fail("Luokkasi toimii väärin suuressa testissä.");
    }

    @Test(timeout = 1000)
    public void suuriTesti3() {
        Hotelli h = new Hotelli();
        Random r = new Random(1337);
        int n = 100000;
        long s = 0;
        for (int i = 1; i <= n; i++) {
            h.lisaaHuone(r.nextInt(1000000000)+1);
            s += h.varaaHuone(r.nextInt(1000000000)+1);
        }
        if (s != 49564771831418L) fail("Luokkasi toimii väärin suuressa testissä.");
    }

    @Test(timeout = 1000)
    public void suuriTesti4() {
        Hotelli h = new Hotelli();
        int n = 100000;
        for (int i = 1; i <= n; i++) h.lisaaHuone(1000000000);
        long s = 0;
        for (int i = 1; i <= n; i++) s += h.varaaHuone(1);
        if (s != 100000000000000L) fail("Luokkasi toimii väärin suuressa testissä.");
    }

    @Test(timeout = 1000)
    public void suuriTesti5() {
        Hotelli h = new Hotelli();
        int n = 100000;
        for (int i = 1; i <= n; i++) h.lisaaHuone(1);
        long s = 0;
        for (int i = 1; i <= n; i++) s += h.varaaHuone(1000000000);
        if (s != 0) fail("Luokkasi toimii väärin suuressa testissä.");
    }

    @Test(timeout = 1000)
    public void suuriTesti6() {
        Hotelli h = new Hotelli();
        int n = 100000;
        for (int i = 1; i <= n; i++) h.lisaaHuone(1);
        long s = 0;
        for (int i = 1; i <= n; i++) s += h.varaaHuone(1);
        if (s != n) fail("Luokkasi toimii väärin suuressa testissä.");
    }
    
}

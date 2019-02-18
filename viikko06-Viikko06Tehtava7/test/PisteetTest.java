import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;
import fi.helsinki.cs.tmc.edutestutils.Points;

@Points("6.7")
public class PisteetTest {
    
    @Test(timeout = 1000)
    public void pieniTesti() {
        Pisteet p = new Pisteet();
        p.lisaaPiste(2);
        p.lisaaPiste(4);
        p.lisaaPiste(6);
        p.lisaaPiste(8);
        for (int i = 1; i <= 9; i++) {
            int e = p.etaisyys(i);
            if (e != i%2) fail("Luokkasi toimii väärin pienessä testissä.");
        }
    }

    @Test(timeout = 1000)
    public void suuriTesti1() {
        Pisteet p = new Pisteet();
        int n = 100000;
        for (int i = 1; i <= n; i++) p.lisaaPiste(i);
        long s = 0;
        for (int i = 1; i <= n; i++) s += p.etaisyys(i);
        if (s != 0) fail("Luokkasi toimii väärin suuressa testissä.");
    }

    @Test(timeout = 1000)
    public void suuriTesti2() {
        Pisteet p = new Pisteet();
        Random r = new Random(1337);
        int n = 100000;
        for (int i = 1; i <= n; i++) p.lisaaPiste(r.nextInt(1000000000)+1);
        long s = 0;
        for (int i = 1; i <= n; i++) s += p.etaisyys(r.nextInt(1000000000)+1);
        if (s != 496602530) fail("Luokkasi toimii väärin suuressa testissä.");
    }

    @Test(timeout = 1000)
    public void suuriTesti3() {
        Pisteet p = new Pisteet();
        Random r = new Random(1337);
        int n = 100000;
        long s = 0;
        for (int i = 1; i <= n; i++) {
            p.lisaaPiste(r.nextInt(1000000000)+1);
            s += p.etaisyys(r.nextInt(1000000000)+1);
        }
        if (s != 5592649318L) fail("Luokkasi toimii väärin suuressa testissä.");
    }    

    @Test(timeout = 1000)
    public void suuriTesti4() {
        Pisteet p = new Pisteet();
        int n = 100000;
        long s = 0;
        p.lisaaPiste(1);
        for (int i = 1; i <= n; i++) {
            s += p.etaisyys(1000000000);
        }
        if (s != 99999999900000L) fail("Luokkasi toimii väärin suuressa testissä.");
    }    
}

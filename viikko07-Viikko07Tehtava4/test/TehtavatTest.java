import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;
import fi.helsinki.cs.tmc.edutestutils.Points;

@Points("7.4")
public class TehtavatTest {
    
    @Test(timeout = 1000)
    public void pieniTesti() {
        Tehtavat t = new Tehtavat();
        t.lisaaTehtava("apina",10);
        t.lisaaTehtava("banaani",20);
        t.lisaaTehtava("cembalo",30);
        boolean virhe = false;
        if (!t.haeTehtava().equals("cembalo")) virhe = true;
        if (!t.haeTehtava().equals("banaani")) virhe = true;
        if (!t.haeTehtava().equals("apina")) virhe = true;
        t.lisaaTehtava("apina",10);
        t.lisaaTehtava("banaani",10);
        t.lisaaTehtava("cembalo",10);
        if (!t.haeTehtava().equals("apina")) virhe = true;
        if (!t.haeTehtava().equals("banaani")) virhe = true;
        if (!t.haeTehtava().equals("cembalo")) virhe = true;
        t.lisaaTehtava("aybabtu",50);
        t.lisaaTehtava("aybabtu",50);
        if (!t.haeTehtava().equals("aybabtu")) virhe = true;
        if (!t.haeTehtava().equals("aybabtu")) virhe = true;
        if (virhe) fail("Luokkasi toimii väärin pienessä testissä.");
    }

    @Test(timeout = 1000)
    public void suuriTesti1() {
        Tehtavat t = new Tehtavat();
        int n = 100000;
        for (int i = 1; i <= n; i++) t.lisaaTehtava("aybabtu",100);
        long s = 0;
        for (int i = 1; i <= n; i++) s += t.haeTehtava().hashCode();
        if (s != -54883621200000L) fail("Luokkasi toimii väärin suuressa testissä.");
    }    

    @Test(timeout = 1000)
    public void suuriTesti2() {
        Tehtavat t = new Tehtavat();
        int n = 100000;
        long s = 0;
        for (int i = 1; i <= n; i++) {
            t.lisaaTehtava("aybabtu",100);
            s += t.haeTehtava().hashCode();
        }
        if (s != -54883621200000L) fail("Luokkasi toimii väärin suuressa testissä.");
    }    

    @Test(timeout = 1000)
    public void suuriTesti3() {
        Tehtavat t = new Tehtavat();
        int n = 100000;
        Random r = new Random(1337);
        long s = 0;
        for (int i = 1; i <= n; i++) {
            t.lisaaTehtava("aybabtu",r.nextInt(100)+1);
        }
        for (int i = 1; i <= n/2; i++) {
            s += t.haeTehtava().hashCode();
        }
        if (s != -27441810600000L) fail("Luokkasi toimii väärin suuressa testissä.");
    }    

    @Test(timeout = 1000)
    public void suuriTesti4() {
        Tehtavat t = new Tehtavat();
        int n = 100000;
        Random r = new Random(1337);
        long s = 0;
        for (int i = 1; i <= n/3; i++) {
            t.lisaaTehtava("apina",r.nextInt(100)+1);
            t.lisaaTehtava("banaani",r.nextInt(100)+1);
            t.lisaaTehtava("cembalo",r.nextInt(100)+1);
        }
        for (int i = 1; i <= n/2; i++) {
            s += t.haeTehtava().hashCode();
        }
        if (s != 6908976482337L) fail("Luokkasi toimii väärin suuressa testissä.");
    }    
    
}

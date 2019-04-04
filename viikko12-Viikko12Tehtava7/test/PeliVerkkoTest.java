import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;
import fi.helsinki.cs.tmc.edutestutils.Points;

@Points("12.7")
public class PeliVerkkoTest {
    
    @Test(timeout = 1000)
    public void pieniTesti1() {
        PeliVerkko p = new PeliVerkko();
        boolean tulos = p.voikoPelata();
        if (tulos) return;
        fail("Luokkasi toimii väärin pienessä testissä");
    }

    @Test(timeout = 1000)
    public void pieniTesti2() {
        PeliVerkko p = new PeliVerkko();
        p.lisaaYhteys(1,2);
        boolean tulos = p.voikoPelata();
        if (tulos) return;
        fail("Luokkasi toimii väärin pienessä testissä");
    }

    @Test(timeout = 1000)
    public void pieniTesti3() {
        PeliVerkko p = new PeliVerkko();
        p.lisaaYhteys(1,2);
        p.lisaaYhteys(2,3);
        p.lisaaYhteys(3,4);
        p.lisaaYhteys(1,4);
        boolean tulos = p.voikoPelata();
        if (tulos) return;
        fail("Luokkasi toimii väärin pienessä testissä");
    }

    @Test(timeout = 1000)
    public void pieniTesti4() {
        PeliVerkko p = new PeliVerkko();
        p.lisaaYhteys(1,2);
        p.lisaaYhteys(2,3);
        p.lisaaYhteys(3,4);
        p.lisaaYhteys(4,5);
        p.lisaaYhteys(1,5);
        boolean tulos = p.voikoPelata();
        if (!tulos) return;
        fail("Luokkasi toimii väärin pienessä testissä");
    }
    
    @Test(timeout = 1000)
    public void pieniTesti5() {
        PeliVerkko p = new PeliVerkko();
        p.lisaaYhteys(1,2);
        p.lisaaYhteys(2,3);
        p.lisaaYhteys(1,3);
        p.lisaaYhteys(4,5);
        p.lisaaYhteys(5,6);
        p.lisaaYhteys(4,6);
        boolean tulos = p.voikoPelata();
        if (!tulos) return;
        fail("Luokkasi toimii väärin pienessä testissä");
    }

    @Test(timeout = 1000)
    public void pieniTesti6() {
        PeliVerkko p = new PeliVerkko();
        p.lisaaYhteys(1,2);
        p.lisaaYhteys(2,3);
        p.lisaaYhteys(3,4);
        p.lisaaYhteys(1,4);
        p.lisaaYhteys(5,6);
        p.lisaaYhteys(6,7);
        p.lisaaYhteys(7,8);
        p.lisaaYhteys(5,8);
        p.lisaaYhteys(1,8);
        p.lisaaYhteys(4,5);
        boolean tulos = p.voikoPelata();
        if (tulos) return;
        fail("Luokkasi toimii väärin pienessä testissä");
    }

    @Test(timeout = 1000)
    public void pieniTesti7() {
        PeliVerkko p = new PeliVerkko();
        p.lisaaYhteys(1,1);
        boolean tulos = p.voikoPelata();
        if (!tulos) return;
        fail("Luokkasi toimii väärin pienessä testissä");
    }
    
    @Test(timeout = 1000)
    public void suuriTesti1() {
        PeliVerkko p = new PeliVerkko();
        int n = 100000;
        for (int i = 1; i <= n-1; i++) {
            p.lisaaYhteys(i,i+1);
        }
        boolean tulos = p.voikoPelata();
        if (tulos) return;
        fail("Luokkasi toimii väärin suuressa testissä");
    }

    @Test(timeout = 1000)
    public void suuriTesti2() {
        PeliVerkko p = new PeliVerkko();
        int n = 100000;
        for (int i = 1; i <= n-1; i++) {
            p.lisaaYhteys(i,i+1);
        }
        p.lisaaYhteys(1,n);
        boolean tulos = p.voikoPelata();
        if (tulos) return;
        fail("Luokkasi toimii väärin suuressa testissä");
    }

    @Test(timeout = 1000)
    public void suuriTesti3() {
        PeliVerkko p = new PeliVerkko();
        int n = 99999;
        for (int i = 1; i <= n-1; i++) {
            p.lisaaYhteys(i,i+1);
        }
        p.lisaaYhteys(1,n);
        boolean tulos = p.voikoPelata();
        if (!tulos) return;
        fail("Luokkasi toimii väärin suuressa testissä");
    }
    
    @Test(timeout = 1000)
    public void suuriTesti4() {
        PeliVerkko p = new PeliVerkko();
        int n = 100;
        int m = 100000;
        Random r = new Random(1337);
        int c = 0;
        for (int i = 1; i <= m; i++) {
            int a = r.nextInt(n)+1;
            int b = r.nextInt(n)+1;
            p.lisaaYhteys(a,b);
            if (p.voikoPelata()) c++;
        }
        if (c == 67) return;
        fail("Luokkasi toimii väärin suuressa testissä");
    }

    @Test(timeout = 1000)
    public void suuriTesti5() {
        PeliVerkko p = new PeliVerkko();
        int n = 10000;
        int m = 100000;
        Random r = new Random(1337);
        int c = 0;
        for (int i = 1; i <= m; i++) {
            int a = r.nextInt(n)+1;
            int b = r.nextInt(n)+1;
            p.lisaaYhteys(a,b);
            if (p.voikoPelata()) c++;
        }
        if (c == 423) return;
        fail("Luokkasi toimii väärin suuressa testissä");
    }

    @Test(timeout = 1000)
    public void suuriTesti6() {
        PeliVerkko p = new PeliVerkko();
        int n = 100000;
        int m = 100000;
        Random r = new Random(1337);
        int c = 0;
        for (int i = 1; i <= m; i++) {
            int a = r.nextInt(n)+1;
            int b = r.nextInt(n)+1;
            p.lisaaYhteys(a,b);
            if (p.voikoPelata()) c++;
        }
        if (c == 51540) return;
        fail("Luokkasi toimii väärin suuressa testissä");
    }

    @Test(timeout = 1000)
    public void suuriTesti7() {
        PeliVerkko p = new PeliVerkko();
        int n = 1000000;
        int m = 100000;
        Random r = new Random(1337);
        int c = 0;
        for (int i = 1; i <= m; i++) {
            int a = r.nextInt(n)+1;
            int b = r.nextInt(n)+1;
            p.lisaaYhteys(a,b);
            if (p.voikoPelata()) c++;
        }
        if (c == 100000) return;
        fail("Luokkasi toimii väärin suuressa testissä");
    }

    @Test(timeout = 1000)
    public void suuriTesti8() {
        PeliVerkko p = new PeliVerkko();
        int n = 1000;
        int m = 100000;
        Random r = new Random(1337);
        int c = 0;
        for (int i = 1; i <= m; i++) {
            int a = 2*r.nextInt(n)+1;
            int b = 2*r.nextInt(n)+2;
            p.lisaaYhteys(a,b);
            if (p.voikoPelata()) c++;
        }
        if (c == 100000) return;
        fail("Luokkasi toimii väärin suuressa testissä");
    }

}

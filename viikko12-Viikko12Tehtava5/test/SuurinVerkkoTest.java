import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;
import fi.helsinki.cs.tmc.edutestutils.Points;

@Points("12.5")
public class SuurinVerkkoTest {
    
    @Test(timeout = 1000)
    public void pieniTesti1() {
        SuurinVerkko u = new SuurinVerkko();
        u.lisaaYhteys(1,2);
        int tulos = u.suurinVerkko();
        if (tulos == 2) return;
        fail("Luokkasi toimii väärin pienessä testissä");
    }

    @Test(timeout = 1000)
    public void pieniTesti2() {
        SuurinVerkko u = new SuurinVerkko();
        int tulos = u.suurinVerkko();
        if (tulos == 1) return;
        fail("Luokkasi toimii väärin pienessä testissä");
    }
    
    @Test(timeout = 1000)
    public void pieniTesti3() {
        SuurinVerkko u = new SuurinVerkko();
        u.lisaaYhteys(1,2);
        u.lisaaYhteys(3,4);
        u.lisaaYhteys(2,3);
        int tulos = u.suurinVerkko();
        if (tulos == 4) return;
        fail("Luokkasi toimii väärin pienessä testissä");
    }

    @Test(timeout = 1000)
    public void pieniTesti4() {
        SuurinVerkko u = new SuurinVerkko();
        u.lisaaYhteys(1,1);
        int tulos = u.suurinVerkko();
        if (tulos == 1) return;
        fail("Luokkasi toimii väärin pienessä testissä");
    }

    @Test(timeout = 1000)
    public void pieniTesti5() {
        SuurinVerkko u = new SuurinVerkko();
        u.lisaaYhteys(1,1000000);
        int tulos = u.suurinVerkko();
        if (tulos == 2) return;
        fail("Luokkasi toimii väärin pienessä testissä");
    }

    @Test(timeout = 1000)
    public void pieniTesti6() {
        SuurinVerkko u = new SuurinVerkko();
        u.lisaaYhteys(1,2);
        u.lisaaYhteys(2,3);
        u.lisaaYhteys(4,5);
        u.lisaaYhteys(5,6);
        int tulos = u.suurinVerkko();
        if (tulos == 3) return;
        fail("Luokkasi toimii väärin pienessä testissä");
    }
    
    @Test(timeout = 1000)
    public void suuriTesti1() {
        SuurinVerkko u = new SuurinVerkko();
        int m = 100000;
        for (int i = 1; i <= m-1; i++) {
            u.lisaaYhteys(i,i+1);
        }
        int tulos = u.suurinVerkko();
        if (tulos == m) return;
        fail("Luokkasi toimii väärin suuressa testissä");
    }

    @Test(timeout = 1000)
    public void suuriTesti2() {
        SuurinVerkko u = new SuurinVerkko();
        int n = 1000000;
        int m = 100000;
        Random r = new Random(1337);
        for (int i = 1; i <= m; i++) {
            u.lisaaYhteys(r.nextInt(n)+1,r.nextInt(n)+1);
        }
        int tulos = u.suurinVerkko();
        if (tulos == 14) return;
        fail("Luokkasi toimii väärin suuressa testissä");
    }

    @Test(timeout = 1000)
    public void suuriTesti3() {
        SuurinVerkko u = new SuurinVerkko();
        int n = 1000000;
        int m = 100000;
        Random r = new Random(1337);
        long summa = 0;
        for (int i = 1; i <= m; i++) {
            u.lisaaYhteys(r.nextInt(n)+1,r.nextInt(n)+1);
            summa += u.suurinVerkko();
        }
        if (summa == 783597) return;
        fail("Luokkasi toimii väärin suuressa testissä");
    }

    @Test(timeout = 1000)
    public void suuriTesti4() {
        SuurinVerkko u = new SuurinVerkko();
        int m = 100000;
        long summa = 0;
        for (int i = 1; i <= m; i++) {
            u.lisaaYhteys(i,i+1);
            summa += u.suurinVerkko();
        }
        if (summa == 5000150000L) return;
        fail("Luokkasi toimii väärin suuressa testissä");
    }

    @Test(timeout = 1000)
    public void suuriTesti5() {
        SuurinVerkko u = new SuurinVerkko();
        int m = 100000;
        for (int i = 1; i <= m; i++) {
            u.lisaaYhteys(1,2);
        }
        int tulos = u.suurinVerkko();
        if (tulos == 2) return;
        fail("Luokkasi toimii väärin suuressa testissä");
    }
}

import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;
import fi.helsinki.cs.tmc.edutestutils.Points;

@Points("12.4")
public class UusiVerkkoTest {
    
    @Test(timeout = 1000)
    public void pieniTesti1() {
        UusiVerkko u = new UusiVerkko();
        u.lisaaYhteys(1,2);
        boolean tulos = u.onkoSamassa(1,2);
        if (tulos) return;
        fail("Luokkasi toimii väärin pienessä testissä");
    }

    @Test(timeout = 1000)
    public void pieniTesti2() {
        UusiVerkko u = new UusiVerkko();
        boolean tulos = u.onkoSamassa(1,2);
        if (!tulos) return;
        fail("Luokkasi toimii väärin pienessä testissä");
    }
    
    @Test(timeout = 1000)
    public void pieniTesti3() {
        UusiVerkko u = new UusiVerkko();
        u.lisaaYhteys(1,2);
        u.lisaaYhteys(3,4);
        u.lisaaYhteys(2,3);
        boolean tulos = u.onkoSamassa(1,4);
        if (tulos) return;
        fail("Luokkasi toimii väärin pienessä testissä");
    }

    @Test(timeout = 1000)
    public void pieniTesti4() {
        UusiVerkko u = new UusiVerkko();
        u.lisaaYhteys(1,1);
        boolean tulos = u.onkoSamassa(1,1);
        if (tulos) return;
        fail("Luokkasi toimii väärin pienessä testissä");
    }

    @Test(timeout = 1000)
    public void pieniTesti5() {
        UusiVerkko u = new UusiVerkko();
        u.lisaaYhteys(1,1000000);
        boolean tulos = u.onkoSamassa(1,1000000);
        if (tulos) return;
        fail("Luokkasi toimii väärin pienessä testissä");
    }
    
    @Test(timeout = 1000)
    public void suuriTesti1() {
        UusiVerkko u = new UusiVerkko();
        int m = 100000;
        for (int i = 1; i <= m-1; i++) {
            u.lisaaYhteys(i,i+1);
        }
        int summa = 0;
        for (int i = 1; i <= m-1; i++) {
            if (u.onkoSamassa(i,i+1)) summa++;
        }
        if (summa == m-1) return;
        fail("Luokkasi toimii väärin suuressa testissä");
    }

    @Test(timeout = 1000)
    public void suuriTesti2() {
        UusiVerkko u = new UusiVerkko();
        int n = 1000000;
        int m = 100000;
        Random r = new Random(1337);
        for (int i = 1; i <= m; i++) {
            u.lisaaYhteys(r.nextInt(n)+1,r.nextInt(n)+1);
        }
        int summa = 0;
        for (int i = 1; i <= m; i++) {
            if (u.onkoSamassa(r.nextInt(n)+1,r.nextInt(n)+1)) summa++;
        }
        if (summa == 0) return;
        fail("Luokkasi toimii väärin suuressa testissä");
    }
    
    @Test(timeout = 1000)
    public void suuriTesti3() {
        UusiVerkko u = new UusiVerkko();
        int n = 1000000;
        int m = 100000;
        Random r = new Random(1337);
        int summa = 0;
        int a = r.nextInt(n)+1;
        for (int i = 1; i <= m; i++) {
            int b = r.nextInt(n)+1;
            u.lisaaYhteys(a,b);
            a = b;
            if (u.onkoSamassa(r.nextInt(n)+1,r.nextInt(n)+1)) summa++;
        }
        if (summa == 292) return;
        fail("Luokkasi toimii väärin suuressa testissä");
    }

    @Test(timeout = 1000)
    public void suuriTesti4() {
        UusiVerkko u = new UusiVerkko();
        int n = 1000000;
        int m = 100000;
        Random r = new Random(1337);
        int summa = 0;
        for (int i = 1; i <= m; i++) {
            u.lisaaYhteys(1,r.nextInt(n)+1);
            if (u.onkoSamassa(r.nextInt(n)+1,r.nextInt(n)+1)) summa++;
        }
        if (summa == 285) return;
        fail("Luokkasi toimii väärin suuressa testissä");
    }

    @Test(timeout = 1000)
    public void suuriTesti5() {
        UusiVerkko u = new UusiVerkko();
        int m = 100000;
        int summa = 0;
        for (int i = 1; i <= m; i++) {
            u.lisaaYhteys(1,2);
            if (u.onkoSamassa(1,2)) summa++;
        }
        if (summa == m) return;
        fail("Luokkasi toimii väärin suuressa testissä");
    }
    
    @Test(timeout = 1000)
    public void suuriTesti6() {
        UusiVerkko u = new UusiVerkko();
        int m = 100000;
        int summa = 0;
        for (int i = m-1; i >= 1; i--) {
            u.lisaaYhteys(i,i+1);
        }
        for (int i = 1; i <= 100000; i++) {
            if (u.onkoSamassa(1,m)) summa++;            
        }
        if (summa == 100000) return;
        fail("Luokkasi toimii väärin suuressa testissä");
    }    
}

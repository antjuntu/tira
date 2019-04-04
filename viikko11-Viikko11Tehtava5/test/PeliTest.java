import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;
import fi.helsinki.cs.tmc.edutestutils.Points;

@Points("11.5")
public class PeliTest {    
    @Test(timeout = 1000)
    public void pieniTesti1() {
        Peli p = new Peli();
        p.lisaaYhteys(1,2);
        p.lisaaYhteys(2,3);
        p.lisaaYhteys(3,4);
        int tulos = p.parasTulos(1,4);
        if (tulos == 4) return;
        fail("Luokkasi toimii väärin pienessä testissä");
    }

    @Test(timeout = 1000)
    public void pieniTesti2() {
        Peli p = new Peli();
        p.lisaaYhteys(1,2);
        p.lisaaYhteys(2,5);
        p.lisaaYhteys(1,3);
        p.lisaaYhteys(3,4);
        p.lisaaYhteys(4,5);
        int tulos = p.parasTulos(1,5);
        if (tulos == 4) return;
        fail("Luokkasi toimii väärin pienessä testissä");
    }

    @Test(timeout = 1000)
    public void pieniTesti3() {
        Peli p = new Peli();
        int tulos = p.parasTulos(1,5);
        if (tulos == -1) return;
        fail("Luokkasi toimii väärin pienessä testissä");
    }

    @Test(timeout = 1000)
    public void pieniTesti4() {
        Peli p = new Peli();
        int tulos = p.parasTulos(1,1);
        if (tulos == 1) return;
        fail("Luokkasi toimii väärin pienessä testissä");
    }    
    
    @Test(timeout = 1000)
    public void suuriTesti1() {
        Peli p = new Peli();
        int n = 500;
        for (int i = 1; i < n; i++) {
            p.lisaaYhteys(i,i+1);
        }
        int tulos = p.parasTulos(1,n);
        if (tulos == n) return;
        fail("Luokkasi toimii väärin suuressa testissä");
    }

    @Test(timeout = 1000)
    public void suuriTesti2() {
        Peli p = new Peli();
        int n = 500;
        int tulos = p.parasTulos(1,n);
        if (tulos == -1) return;
        fail("Luokkasi toimii väärin suuressa testissä");
    }    

    // ei toimi
    @Test(timeout = 1000)
    public void suuriTesti3() {
        Peli p = new Peli();
        int n = 500;
        Random r = new Random(1337);
        for (int i = 0; i < 10000; i++) {
            int a = 1+r.nextInt(n-1);
            int b = a+1+r.nextInt(n-a);
            p.lisaaYhteys(a,b);
        }
        int tulos = p.parasTulos(1,n);
        if (tulos == 99) return;
        fail("Luokkasi toimii väärin suuressa testissä");
    }    

    // ei toimi
    @Test(timeout = 1000)
    public void suuriTesti4() {
        Peli p = new Peli();
        int n = 500;
        Random r = new Random(1338);
        for (int i = 0; i < 10000; i++) {
            int a = 1+r.nextInt(n-1);
            int b = a+1+r.nextInt(n-a);
            p.lisaaYhteys(a,b);
        }
        int tulos = p.parasTulos(1,n);
        if (tulos == 105) return;
        fail("Luokkasi toimii väärin suuressa testissä");
    }    

    @Test(timeout = 1000)
    public void suuriTesti5() {
        Peli p = new Peli();
        int n = 500;
        for (int i = 0; i < 10000; i++) {
            p.lisaaYhteys(1,n);
        }
        int tulos = p.parasTulos(1,n);
        if (tulos == 2) return;
        fail("Luokkasi toimii väärin suuressa testissä");
    }    
}

import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;
import fi.helsinki.cs.tmc.edutestutils.Points;

@Points("11.6")
public class KolikotTest {    
    @Test(timeout = 1000)
    public void pieniTesti1() {
        Kolikot k = new Kolikot();
        k.lisaaYhteys(1,2);
        k.lisaaYhteys(2,3);
        k.lisaaYhteys(3,4);
        int tulos = k.parasTulos(1,4);
        if (tulos == 0) return;
        fail("Luokkasi toimii väärin pienessä testissä");
    }

    @Test(timeout = 1000)
    public void pieniTesti2() {
        Kolikot k = new Kolikot();
        k.lisaaKolikko(1);
        k.lisaaKolikko(1);
        k.lisaaKolikko(1);
        int tulos = k.parasTulos(1,1);
        if (tulos == 3) return;
        fail("Luokkasi toimii väärin pienessä testissä");
    }

    @Test(timeout = 1000)
    public void pieniTesti3() {
        Kolikot k = new Kolikot();
        k.lisaaKolikko(1);
        k.lisaaKolikko(1);
        k.lisaaKolikko(1);
        int tulos = k.parasTulos(1,1);
        if (tulos == 3) return;
        fail("Luokkasi toimii väärin pienessä testissä");
    }    

    @Test(timeout = 1000)
    public void pieniTesti4() {
        Kolikot k = new Kolikot();
        k.lisaaYhteys(1,2);
        k.lisaaYhteys(1,3);
        k.lisaaKolikko(2);
        k.lisaaKolikko(2);
        k.lisaaKolikko(2);
        int tulos = k.parasTulos(1,3);
        if (tulos == 0) return;
        fail("Luokkasi toimii väärin pienessä testissä");
    }    

    @Test(timeout = 1000)
    public void pieniTesti5() {
        Kolikot k = new Kolikot();
        k.lisaaYhteys(1,2);
        k.lisaaYhteys(1,3);
        k.lisaaYhteys(3,4);
        k.lisaaKolikko(1);
        k.lisaaKolikko(4);
        int tulos = k.parasTulos(1,4);
        if (tulos == 2) return;
        fail("Luokkasi toimii väärin pienessä testissä");
    }    
    
    @Test(timeout = 1000)
    public void suuriTesti1() {
        Kolikot k = new Kolikot();
        int n = 500;
        for (int i = 1; i <= n-1; i++) {
            k.lisaaYhteys(i,i+1);
        }
        int tulos = k.parasTulos(1,n);
        if (tulos == 0) return;
        fail("Luokkasi toimii väärin suuressa testissä");
    }    

    @Test(timeout = 1000)
    public void suuriTesti2() {
        Kolikot k = new Kolikot();
        int n = 500;
        for (int i = 1; i <= n-2; i++) {
            k.lisaaYhteys(i,i+1);
        }
        int tulos = k.parasTulos(1,n);
        if (tulos == -1) return;
        fail("Luokkasi toimii väärin suuressa testissä");
    }    

    @Test(timeout = 1000)
    public void suuriTesti3() {
        Kolikot k = new Kolikot();
        int n = 500;
        for (int i = 1; i <= n-1; i++) {
            k.lisaaYhteys(i,i+1);
        }
        Random r = new Random(1337);
        for (int i = 0; i < 10000; i++) {
            k.lisaaKolikko(r.nextInt(n)+1);
        }
        int tulos = k.parasTulos(1,n);
        if (tulos == 10000) return;
        fail("Luokkasi toimii väärin suuressa testissä");
    }    

    @Test(timeout = 1000)
    public void suuriTesti4() {
        Kolikot k = new Kolikot();
        int n = 500;
        Random r = new Random(1337);
        for (int i = 0; i < 10000; i++) {
            int a = 1+r.nextInt(n-1);
            int b = a+1+r.nextInt(n-a);
            k.lisaaYhteys(a,b);
        }
        for (int i = 0; i < 10000; i++) {
            k.lisaaKolikko(r.nextInt(n)+1);
        }
        int tulos = k.parasTulos(1,n);
        if (tulos == 2027) return;
        fail("Luokkasi toimii väärin suuressa testissä");
    }    

    @Test(timeout = 1000)
    public void suuriTesti5() {
        Kolikot k = new Kolikot();
        int n = 500;
        Random r = new Random(1337);
        for (int i = 0; i < 5000; i++) {
            int a = 1+r.nextInt(n-1);
            int b = a+1+r.nextInt(n-a);
            k.lisaaYhteys(a,b);
        }
        for (int i = 0; i < 10000; i++) {
            k.lisaaKolikko(r.nextInt(n)+1);
        }
        int tulos = k.parasTulos(1,n);
        if (tulos == 1338) return;
        fail("Luokkasi toimii väärin suuressa testissä");
    }    
    
}

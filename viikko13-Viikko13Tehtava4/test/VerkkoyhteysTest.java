import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;
import fi.helsinki.cs.tmc.edutestutils.Points;

@Points("13.4")
public class VerkkoyhteysTest {
    
    @Test(timeout = 1000)
    public void pieniTesti1() {
        Verkkoyhteys v = new Verkkoyhteys();
        v.lisaaYhteys(1,2,5);
        int oikea = 5;
        int tulos = v.laskeNopeus(1,2);
        if (tulos == oikea) return;
        fail("Luokkasi antaa tuloksen "+tulos+", vaikka oikea on "+oikea);
    }

    @Test(timeout = 1000)
    public void pieniTesti2() {
        Verkkoyhteys v = new Verkkoyhteys();
        int oikea = 0;
        int tulos = v.laskeNopeus(1,2);
        if (tulos == oikea) return;
        fail("Luokkasi antaa tuloksen "+tulos+", vaikka oikea on "+oikea);
    }

    @Test(timeout = 1000)
    public void pieniTesti3() {
        Verkkoyhteys v = new Verkkoyhteys();
        v.lisaaYhteys(1,2,4);
        v.lisaaYhteys(2,3,2);
        v.lisaaYhteys(2,4,2);
        v.lisaaYhteys(3,4,2);
        int oikea = 4;
        int tulos = v.laskeNopeus(1,2);
        if (tulos == oikea) return;
        fail("Luokkasi antaa tuloksen "+tulos+", vaikka oikea on "+oikea);
    }

    @Test(timeout = 1000)
    public void pieniTesti4() {
        Verkkoyhteys v = new Verkkoyhteys();
        v.lisaaYhteys(1,2,4);
        v.lisaaYhteys(2,3,3);
        v.lisaaYhteys(3,4,2);
        v.lisaaYhteys(4,5,1);
        int oikea = 1;
        int tulos = v.laskeNopeus(1,5);
        if (tulos == oikea) return;
        fail("Luokkasi antaa tuloksen "+tulos+", vaikka oikea on "+oikea);
    }

    @Test(timeout = 1000)
    public void pieniTesti5() {
        Verkkoyhteys v = new Verkkoyhteys();
        v.lisaaYhteys(1,2,2);
        v.lisaaYhteys(1,2,2);
        int oikea = 4;
        int tulos = v.laskeNopeus(1,2);
        if (tulos == oikea) return;
        fail("Luokkasi antaa tuloksen "+tulos+", vaikka oikea on "+oikea);
    }

    @Test(timeout = 1000)
    public void pieniTesti6() {
        Verkkoyhteys v = new Verkkoyhteys();
        v.lisaaYhteys(1,2,1);
        v.lisaaYhteys(2,3,1);
        v.lisaaYhteys(3,6,1);
        v.lisaaYhteys(1,5,1);
        v.lisaaYhteys(5,3,1);
        v.lisaaYhteys(2,4,1);
        v.lisaaYhteys(4,6,1);
        int oikea = 2;
        int tulos = v.laskeNopeus(1,6);
        if (tulos == oikea) return;
        fail("Luokkasi antaa tuloksen "+tulos+", vaikka oikea on "+oikea);
    }    
    
    @Test(timeout = 1000)
    public void suuriTesti1() {
        Verkkoyhteys v = new Verkkoyhteys();
        for (int i = 1; i <= 1000; i++) {
            v.lisaaYhteys(1,2,100);
        }
        int oikea = 100000;
        int tulos = v.laskeNopeus(1,2);
        if (tulos == oikea) return;
        fail("Luokkasi antaa tuloksen "+tulos+", vaikka oikea on "+oikea);
    }
    
    @Test(timeout = 1000)
    public void suuriTesti2() {
        Verkkoyhteys v = new Verkkoyhteys();
        int n = 10;
        Random r = new Random(1337);
        for (int i = 1; i <= 1000; i++) {
            int a = r.nextInt(n)+1;
            int b = r.nextInt(n)+1;
            if (a == b) {i--; continue;}
            v.lisaaYhteys(a,b,r.nextInt(100)+1);
        }
        int oikea = 4739;
        int tulos = v.laskeNopeus(1,n);
        if (tulos == oikea) return;
        fail("Luokkasi antaa tuloksen "+tulos+", vaikka oikea on "+oikea);
    }

    @Test(timeout = 1000)
    public void suuriTesti3() {
        Verkkoyhteys v = new Verkkoyhteys();
        int n = 50;
        Random r = new Random(1337);
        for (int i = 1; i <= 1000; i++) {
            int a = r.nextInt(n)+1;
            int b = r.nextInt(n)+1;
            if (a == b) {i--; continue;}
            v.lisaaYhteys(a,b,r.nextInt(100)+1);
        }
        int oikea = 664;
        int tulos = v.laskeNopeus(1,n);
        if (tulos == oikea) return;
        fail("Luokkasi antaa tuloksen "+tulos+", vaikka oikea on "+oikea);
    }

    @Test(timeout = 1000)
    public void suuriTesti4() {
        Verkkoyhteys v = new Verkkoyhteys();
        int n = 100;
        Random r = new Random(1337);
        for (int i = 1; i <= 1000; i++) {
            int a = r.nextInt(n)+1;
            int b = r.nextInt(n)+1;
            if (a == b) {i--; continue;}
            v.lisaaYhteys(a,b,r.nextInt(100)+1);
        }
        int oikea = 340;
        int tulos = v.laskeNopeus(1,n);
        if (tulos == oikea) return;
        fail("Luokkasi antaa tuloksen "+tulos+", vaikka oikea on "+oikea);
    }    
}

import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;
import fi.helsinki.cs.tmc.edutestutils.Points;

@Points("13.5")
public class PalvelimetTest {
    
    @Test(timeout = 1000)
    public void pieniTesti1() {
        Palvelimet p = new Palvelimet();
        p.lisaaPalvelin(1);
        p.lisaaYhteys(1,2,5);
        int oikea = 5;
        int tulos = p.laskeNopeus(2);
        if (tulos == oikea) return;
        fail("Luokkasi antaa tuloksen "+tulos+", vaikka oikea on "+oikea);
    }

    @Test(timeout = 1000)
    public void pieniTesti2() {
        Palvelimet p = new Palvelimet();
        p.lisaaPalvelin(1);
        int oikea = 0;
        int tulos = p.laskeNopeus(2);
        if (tulos == oikea) return;
        fail("Luokkasi antaa tuloksen "+tulos+", vaikka oikea on "+oikea);
    }
    
    @Test(timeout = 1000)
    public void pieniTesti3() {
        Palvelimet p = new Palvelimet();
        p.lisaaYhteys(1,2,5);
        int oikea = 0;
        int tulos = p.laskeNopeus(2);
        if (tulos == oikea) return;
        fail("Luokkasi antaa tuloksen "+tulos+", vaikka oikea on "+oikea);
    }

    @Test(timeout = 1000)
    public void pieniTesti4() {
        Palvelimet p = new Palvelimet();
        p.lisaaPalvelin(1);
        p.lisaaPalvelin(2);
        p.lisaaYhteys(1,2,1);
        p.lisaaYhteys(2,3,1);
        int oikea = 1;
        int tulos = p.laskeNopeus(3);
        if (tulos == oikea) return;
        fail("Luokkasi antaa tuloksen "+tulos+", vaikka oikea on "+oikea);
    }

    @Test(timeout = 1000)
    public void pieniTesti5() {
        Palvelimet p = new Palvelimet();
        p.lisaaPalvelin(1);
        p.lisaaPalvelin(2);
        p.lisaaYhteys(1,2,1);
        p.lisaaYhteys(2,3,1);
        p.lisaaYhteys(3,1,1);
        int oikea = 1;
        int tulos = p.laskeNopeus(3);
        if (tulos == oikea) return;
        fail("Luokkasi antaa tuloksen "+tulos+", vaikka oikea on "+oikea);
    }
    
    @Test(timeout = 1000)
    public void pieniTesti6() {
        Palvelimet p = new Palvelimet();
        p.lisaaPalvelin(1);
        p.lisaaPalvelin(2);
        p.lisaaYhteys(1,3,1);
        p.lisaaYhteys(1,3,1);
        p.lisaaYhteys(2,3,1);
        p.lisaaYhteys(2,3,1);
        int oikea = 4;
        int tulos = p.laskeNopeus(3);
        if (tulos == oikea) return;
        fail("Luokkasi antaa tuloksen "+tulos+", vaikka oikea on "+oikea);
    }
    
    @Test(timeout = 1000)
    public void suuriTesti1() {
        Palvelimet p = new Palvelimet();
        for (int i = 1; i <= 99; i++) {
            p.lisaaPalvelin(i);
        }
        for (int i = 1; i <= 1000; i++) {
            p.lisaaYhteys(i%99+1,100,100);
        }
        int oikea = 100000;
        int tulos = p.laskeNopeus(100);
        if (tulos == oikea) return;
        fail("Luokkasi antaa tuloksen "+tulos+", vaikka oikea on "+oikea);
    }
    
    @Test(timeout = 1000)
    public void suuriTesti2() {
        Palvelimet p = new Palvelimet();
        for (int i = 1; i <= 98; i++) {
            p.lisaaPalvelin(i);
        }
        for (int i = 1; i <= 1000; i++) {
            p.lisaaYhteys(i%98+1,99,100);
        }
        int oikea = 0;
        int tulos = p.laskeNopeus(100);
        if (tulos == oikea) return;
        fail("Luokkasi antaa tuloksen "+tulos+", vaikka oikea on "+oikea);
    }

    @Test(timeout = 1000)
    public void suuriTesti3() {
        Palvelimet p = new Palvelimet();
        Random r = new Random(1337);
        int n = 100;
        p.lisaaPalvelin(1);
        for (int i = 1; i <= 1000; i++) {
            int a = r.nextInt(n)+1;
            int b = r.nextInt(n)+1;
            if (a == b) {i--; continue;}
            p.lisaaYhteys(a,b,r.nextInt(100)+1);
        }
        int oikea = 340;
        int tulos = p.laskeNopeus(n);
        if (tulos == oikea) return;
        fail("Luokkasi antaa tuloksen "+tulos+", vaikka oikea on "+oikea);
    }

    @Test(timeout = 1000)
    public void suuriTesti4() {
        Palvelimet p = new Palvelimet();
        int n = 100;
        p.lisaaPalvelin(1);
        p.lisaaPalvelin(n);
        for (int i = 1; i+1 <= n/2; i++) {
            p.lisaaYhteys(i,i+1,1);
        }
        for (int i = n; i-1 >= n/2; i--) {
            p.lisaaYhteys(i,i-1,1);
        }
        int oikea = 2;
        int tulos = p.laskeNopeus(n/2);
        if (tulos == oikea) return;
        fail("Luokkasi antaa tuloksen "+tulos+", vaikka oikea on "+oikea);
    }

    @Test(timeout = 1000)
    public void suuriTesti5() {
        Palvelimet p = new Palvelimet();
        Random r = new Random(1337);
        int n = 100;
        for (int i = 1; i <= n/10; i++) {
            p.lisaaPalvelin(i);
        }
        for (int i = 1; i <= 1000; i++) {
            int a = r.nextInt(n)+1;
            int b = r.nextInt(n)+1;
            if (a == b) {i--; continue;}
            p.lisaaYhteys(a,b,r.nextInt(100)+1);
        }
        int oikea = 340;
        int tulos = p.laskeNopeus(n);
        if (tulos == oikea) return;
        fail("Luokkasi antaa tuloksen "+tulos+", vaikka oikea on "+oikea);
    }

    @Test(timeout = 1000)
    public void suuriTesti6() {
        Palvelimet p = new Palvelimet();
        Random r = new Random(1337);
        int n = 100;
        for (int i = 1; i <= n-1; i++) {
            p.lisaaPalvelin(i);
        }
        for (int i = 1; i <= 1000; i++) {
            int a = r.nextInt(n)+1;
            int b = r.nextInt(n)+1;
            if (a == b) {i--; continue;}
            p.lisaaYhteys(a,b,r.nextInt(100)+1);
        }
        int oikea = 340;
        int tulos = p.laskeNopeus(n);
        if (tulos == oikea) return;
        fail("Luokkasi antaa tuloksen "+tulos+", vaikka oikea on "+oikea);
    }
}

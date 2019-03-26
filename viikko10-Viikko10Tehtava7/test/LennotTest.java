import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;
import fi.helsinki.cs.tmc.edutestutils.Points;

@Points("10.7")
public class LennotTest {
    static String[] nimet;
    
    @BeforeClass
    public static void luoVerkot() {
        Random r = new Random(1337);
        int n = 500;
        nimet = new String[n];
        for (int i = 0; i < n; i++) {
            String nimi = "";
            nimi += (char)(65+r.nextInt(26));
            for (int j = 0; j < 9; j++) {
                nimi += (char)(97+r.nextInt(26));
            }
            nimet[i] = nimi;
        }
    }
    
    @Test(timeout = 1000)
    public void pieniTesti1() {
        Tarjous t = new Tarjous();
        t.lisaaYhteys("Ankkalinna","Hanhivaara",1000);
        t.lisaaYhteys("Hanhivaara","Sorsala",1000);
        t.lisaaYhteys("Ankkalinna","Kattivaara",100);
        t.lisaaYhteys("Kattivaara","Kurjenmutka",100);
        t.lisaaYhteys("Kurjenmutka","Sorsala",100);
        int oikea = 250;
        int hinta = t.reitinHinta("Ankkalinna", "Sorsala");
        if (hinta == oikea) return;
        fail("Hinnan tulisi olla "+oikea+", mutta metodisi antaa "+hinta);
    }

    @Test(timeout = 1000)
    public void pieniTesti2() {
        Tarjous t = new Tarjous();
        t.lisaaYhteys("Ankkalinna", "Sorsala", 250);
        t.lisaaYhteys("Ankkalinna", "Hanhivaara", 100);
        t.lisaaYhteys("Hanhivaara", "Sorsala", 100);
        t.lisaaYhteys("Sorsala", "Kurjenmutka", 200);
        int oikea = 300;
        int hinta = t.reitinHinta("Ankkalinna", "Kurjenmutka");
        if (hinta == oikea) return;
        fail("Hinnan tulisi olla "+oikea+", mutta metodisi antaa "+hinta);
    }
    
    @Test(timeout = 1000)
    public void suuriTesti1() {
        Tarjous t = new Tarjous();
        int n = 500;
        for (int i = 0; i < n-1; i++) {
            t.lisaaYhteys(nimet[i],nimet[i+1],1);
        }
        int oikea = 498;
        int hinta = t.reitinHinta(nimet[0],nimet[n-1]);
        if (hinta == oikea) return;
        fail("Hinnan tulisi olla "+oikea+", mutta metodisi antaa "+hinta);
    }    

    @Test(timeout = 1000)
    public void suuriTesti2() {
        Tarjous t = new Tarjous();
        int oikea = -1;
        int hinta = t.reitinHinta(nimet[0],nimet[1]);
        if (hinta == oikea) return;
        fail("Hinnan tulisi olla "+oikea+", mutta metodisi antaa "+hinta);
    }    

    @Test(timeout = 1000)
    public void suuriTesti3() {
        Tarjous t = new Tarjous();
        int n = 500;
        Random u = new Random(1337);
        for (int i = 0; i < 10000; i++) {
            int a = u.nextInt(n);
            int b = u.nextInt(n);
            int p = u.nextInt(1000)+1;
            t.lisaaYhteys(nimet[a],nimet[b],p);
        }
        int oikea = 222;
        int hinta = t.reitinHinta(nimet[0],nimet[n-1]);
        if (hinta == oikea) return;
        fail("Hinnan tulisi olla "+oikea+", mutta metodisi antaa "+hinta);
    }    

    @Test(timeout = 1000)
    public void suuriTesti4() {
        Tarjous t = new Tarjous();
        int n = 500;
        Random u = new Random(1337);
        for (int i = 0; i < 10000; i++) {
            int a = u.nextInt(n);
            int b = Math.min(n-1,a+u.nextInt(2));
            int p = u.nextInt(1000)+1;
            t.lisaaYhteys(nimet[a],nimet[b],p);
        }
        int oikea = 53126;
        int hinta = t.reitinHinta(nimet[0],nimet[n-1]);
        if (hinta == oikea) return;
        fail("Hinnan tulisi olla "+oikea+", mutta metodisi antaa "+hinta);
    }    

    @Test(timeout = 1000)
    public void suuriTesti5() {
        Tarjous t = new Tarjous();
        int n = 500;
        Random u = new Random(1337);
        for (int i = 0; i+3 < n; i += 3) {
            t.lisaaYhteys(nimet[i],nimet[i+1],u.nextInt(1000)+1);
            t.lisaaYhteys(nimet[i],nimet[i+2],u.nextInt(1000)+1);
            t.lisaaYhteys(nimet[i+1],nimet[i+3],u.nextInt(1000)+1);
            t.lisaaYhteys(nimet[i+2],nimet[i+3],u.nextInt(1000)+1);
            t.lisaaYhteys(nimet[i],nimet[i+3],u.nextInt(1000)+1);
        }
        int oikea = 67326;
        int hinta = t.reitinHinta(nimet[0],nimet[n-2]);
        if (hinta == oikea) return;
        fail("Hinnan tulisi olla "+oikea+", mutta metodisi antaa "+hinta);
    }    
}

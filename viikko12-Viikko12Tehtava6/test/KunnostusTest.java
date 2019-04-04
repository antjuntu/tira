import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;
import fi.helsinki.cs.tmc.edutestutils.Points;

@Points("12.6")
public class KunnostusTest {
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
        Kunnostus k = new Kunnostus();
        k.lisaaKaupunki("Helsinki");
        int tulos = k.halvinHinta();
        if (tulos == 0) return;
        fail("Luokkasi toimii väärin pienessä testissä");
    }

    @Test(timeout = 1000)
    public void pieniTesti2() {
        Kunnostus k = new Kunnostus();
        k.lisaaKaupunki("Helsinki");
        k.lisaaKaupunki("Turku");
        int tulos = k.halvinHinta();
        if (tulos == -1) return;
        fail("Luokkasi toimii väärin pienessä testissä");
    }

    @Test(timeout = 1000)
    public void pieniTesti3() {
        Kunnostus k = new Kunnostus();
        k.lisaaKaupunki("Helsinki");
        k.lisaaKaupunki("Turku");
        k.lisaaTie("Helsinki","Turku",100);
        int tulos = k.halvinHinta();
        if (tulos == 100) return;
        fail("Luokkasi toimii väärin pienessä testissä");
    }

    @Test(timeout = 1000)
    public void pieniTesti4() {
        Kunnostus k = new Kunnostus();
        k.lisaaKaupunki("Helsinki");
        k.lisaaKaupunki("Turku");
        k.lisaaTie("Helsinki","Turku",200);
        k.lisaaTie("Helsinki","Turku",100);
        int tulos = k.halvinHinta();
        if (tulos == 100) return;
        fail("Luokkasi toimii väärin pienessä testissä");
    }

    @Test(timeout = 1000)
    public void pieniTesti5() {
        Kunnostus k = new Kunnostus();
        k.lisaaKaupunki("Helsinki");
        k.lisaaKaupunki("Turku");
        k.lisaaKaupunki("Tampere");
        k.lisaaKaupunki("Vaasa");
        k.lisaaTie("Helsinki","Turku",300);
        k.lisaaTie("Helsinki","Tampere",100);
        k.lisaaTie("Tampere","Turku",100);
        k.lisaaTie("Tampere","Vaasa",250);
        k.lisaaTie("Turku","Vaasa",200);
        int tulos = k.halvinHinta();
        if (tulos == 400) return;
        fail("Luokkasi toimii väärin pienessä testissä");
    }

    @Test(timeout = 1000)
    public void suuriTesti1() {
        Kunnostus k = new Kunnostus();
        int n = 500;
        for (int i = 0; i < n; i++) {
            k.lisaaKaupunki(nimet[i]);
        }
        int tulos = k.halvinHinta();
        if (tulos == -1) return;
        fail("Luokkasi toimii väärin suuressa testissä");
    }

    @Test(timeout = 1000)
    public void suuriTesti2() {
        Kunnostus k = new Kunnostus();
        int n = 500;
        for (int i = 0; i < n; i++) {
            k.lisaaKaupunki(nimet[i]);
        }
        for (int i = 0; i < n-1; i++) {
            k.lisaaTie(nimet[i],nimet[i+1],100);
        }
        int tulos = k.halvinHinta();
        if (tulos == (n-1)*100) return;
        fail("Luokkasi toimii väärin suuressa testissä");
    }

    @Test(timeout = 1000)
    public void suuriTesti3() {
        Kunnostus k = new Kunnostus();
        int n = 500;
        for (int i = 0; i < n; i++) {
            k.lisaaKaupunki(nimet[i]);
        }
        int m = 1000;
        Random r = new Random(1337);
        for (int i = 0; i < m; i++) {
            k.lisaaTie(nimet[r.nextInt(n)],nimet[r.nextInt(n)],r.nextInt(1000)+1);
        }
        int tulos = k.halvinHinta();
        if (tulos == -1) return;
        fail("Luokkasi toimii väärin suuressa testissä");
    }
    
    @Test(timeout = 1000)
    public void suuriTesti4() {
        Kunnostus k = new Kunnostus();
        int n = 500;
        for (int i = 0; i < n; i++) {
            k.lisaaKaupunki(nimet[i]);
        }
        int m = 10000;
        Random r = new Random(1337);
        for (int i = 0; i < m; i++) {
            k.lisaaTie(nimet[r.nextInt(n)],nimet[r.nextInt(n)],r.nextInt(1000)+1);
        }
        int tulos = k.halvinHinta();
        if (tulos == 15525) return;
        fail("Luokkasi toimii väärin suuressa testissä");
    }
    
    @Test(timeout = 1000)
    public void suuriTesti5() {
        Kunnostus k = new Kunnostus();
        int n = 500;
        for (int i = 0; i < n; i++) {
            k.lisaaKaupunki(nimet[i]);
        }
        int m = 100000;
        Random r = new Random(1337);
        for (int i = 0; i < m; i++) {
            k.lisaaTie(nimet[r.nextInt(n)],nimet[r.nextInt(n)],r.nextInt(1000)+1);
        }
        int tulos = k.halvinHinta();
        if (tulos == 1697) return;
        fail("Luokkasi toimii väärin suuressa testissä");
    }
}

import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;
import fi.helsinki.cs.tmc.edutestutils.Points;

@Points("11.7")
public class LennotTest {
    static String[] nimet;
    
    @BeforeClass
    public static void luoNimet() {
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
        Lennot l = new Lennot();
        l.lisaaKaupunki("Helsinki");
        l.lisaaKaupunki("Turku");
        l.lisaaYhteys("Helsinki","Turku");
        boolean tulos = l.onkoKaikki();
        if (!tulos) return;
        fail("Luokkasi toimii väärin pienessä testissä");
    }

    @Test(timeout = 1000)
    public void pieniTesti2() {
        Lennot l = new Lennot();
        l.lisaaKaupunki("Helsinki");
        l.lisaaKaupunki("Turku");
        l.lisaaYhteys("Helsinki","Turku");
        l.lisaaYhteys("Turku","Helsinki");
        boolean tulos = l.onkoKaikki();
        if (tulos) return;
        fail("Luokkasi toimii väärin pienessä testissä");
    }
    
    @Test(timeout = 1000)
    public void pieniTesti3() {
        Lennot l = new Lennot();
        l.lisaaKaupunki("Helsinki");
        boolean tulos = l.onkoKaikki();
        if (tulos) return;
        fail("Luokkasi toimii väärin pienessä testissä");
    }

    @Test(timeout = 1000)
    public void pieniTesti4() {
        Lennot l = new Lennot();
        l.lisaaKaupunki("Helsinki");
        l.lisaaKaupunki("Turku");
        l.lisaaKaupunki("Tampere");
        l.lisaaKaupunki("Vaasa");
        l.lisaaYhteys("Helsinki","Turku");
        l.lisaaYhteys("Turku","Tampere");
        l.lisaaYhteys("Tampere","Vaasa");
        l.lisaaYhteys("Vaasa","Helsinki");
        boolean tulos = l.onkoKaikki();
        if (tulos) return;
        fail("Luokkasi toimii väärin pienessä testissä");
    }

    @Test(timeout = 1000)
    public void pieniTesti5() {
        Lennot l = new Lennot();
        l.lisaaKaupunki("Helsinki");
        l.lisaaKaupunki("Turku");
        l.lisaaYhteys("Turku","Helsinki");
        boolean tulos = l.onkoKaikki();
        if (!tulos) return;
        fail("Luokkasi toimii väärin pienessä testissä");
    }

    @Test(timeout = 1000)
    public void suuriTesti1() {
        Lennot l = new Lennot();
        int n = 500;
        for (int i = 0; i < n; i++) {
            l.lisaaKaupunki(nimet[i]);
        }
        boolean tulos = l.onkoKaikki();
        if (!tulos) return;
        fail("Luokkasi toimii väärin suuressa testissä");
    }

    @Test(timeout = 1000)
    public void suuriTesti2() {
        Lennot l = new Lennot();
        int n = 500;
        for (int i = 0; i < n; i++) {
            l.lisaaKaupunki(nimet[i]);
        }
        for (int i = 0; i < n-1; i++) {
            l.lisaaYhteys(nimet[i],nimet[i+1]);
        }
        l.lisaaYhteys(nimet[n-1],nimet[0]);
        boolean tulos = l.onkoKaikki();
        if (tulos) return;
        fail("Luokkasi toimii väärin suuressa testissä");
    }
    
    @Test(timeout = 1000)
    public void suuriTesti3() {
        Lennot l = new Lennot();
        int n = 500;
        for (int i = 0; i < n; i++) {
            l.lisaaKaupunki(nimet[i]);
        }
        Random r = new Random(1337);
        for (int i = 0; i < 3371; i++) {
            int a = r.nextInt(n);
            int b = r.nextInt(n);
            l.lisaaYhteys(nimet[a],nimet[b]);
        }
        boolean tulos = l.onkoKaikki();
        if (!tulos) return;
        fail("Luokkasi toimii väärin suuressa testissä");
    }

    @Test(timeout = 1000)
    public void suuriTesti4() {
        Lennot l = new Lennot();
        int n = 500;
        for (int i = 0; i < n; i++) {
            l.lisaaKaupunki(nimet[i]);
        }
        Random r = new Random(1337);
        for (int i = 0; i < 3372; i++) {
            int a = r.nextInt(n);
            int b = r.nextInt(n);
            l.lisaaYhteys(nimet[a],nimet[b]);
        }
        boolean tulos = l.onkoKaikki();
        if (tulos) return;
        fail("Luokkasi toimii väärin suuressa testissä");
    }

    @Test(timeout = 1000)
    public void suuriTesti5() {
        Lennot l = new Lennot();
        int n = 500;
        for (int i = 0; i < n; i++) {
            l.lisaaKaupunki(nimet[i]);
        }
        Random r = new Random(1337);
        for (int i = 0; i < 3372; i++) {
            int a = r.nextInt(n);
            int b = r.nextInt(n);
            l.lisaaYhteys(nimet[a],nimet[b]);
        }
        boolean tulos = l.onkoKaikki();
        if (tulos) return;
        fail("Luokkasi toimii väärin suuressa testissä");
    }

    @Test(timeout = 1000)
    public void suuriTesti6() {
        Lennot l = new Lennot();
        int n = 500;
        for (int i = 0; i < n; i++) {
            l.lisaaKaupunki(nimet[i]);
        }
        Random r = new Random(1337);
        int tulos = 0;
        for (int i = 0; i < 10000; i++) {
            int a = r.nextInt(n);
            int b = r.nextInt(n);
            l.lisaaYhteys(nimet[a],nimet[b]);
            if (i%10 == 0 && l.onkoKaikki()) tulos++;
        }
        if (tulos == 662) return;
        fail("Luokkasi toimii väärin suuressa testissä");
    }

    @Test(timeout = 1000)
    public void suuriTesti7() {
        Lennot l = new Lennot();
        int n = 500;
        for (int i = 0; i < n; i++) {
            l.lisaaKaupunki(nimet[i]);
        }
        Random r = new Random(1337);
        int tulos = 0;
        l.lisaaYhteys(nimet[0],nimet[n-1]);
        for (int i = 0; i < 9999; i++) {
            int a = r.nextInt(n-1);
            int b = r.nextInt(n-1);
            l.lisaaYhteys(nimet[a],nimet[b]);
            if (i%10 == 0 && l.onkoKaikki()) tulos++;
        }
        if (tulos == 0) return;
        fail("Luokkasi toimii väärin suuressa testissä");
    }
    
}

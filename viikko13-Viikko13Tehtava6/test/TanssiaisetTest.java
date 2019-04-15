import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;
import fi.helsinki.cs.tmc.edutestutils.Points;

@Points("13.6")
public class TanssiaisetTest {
    static String[] kumpula, viikki;
    
    @BeforeClass
    public static void luoNimet() {
        Random r = new Random(1337);
        int n = 100;
        kumpula = new String[n];
        viikki = new String[n];
        for (int i = 0; i < n; i++) {
            String nimi = "";
            nimi += (char)(65+r.nextInt(26));
            for (int j = 0; j < 9; j++) {
                nimi += (char)(97+r.nextInt(26));
            }
            kumpula[i] = nimi;
        }
        for (int i = 0; i < n; i++) {
            String nimi = "";
            nimi += (char)(65+r.nextInt(26));
            for (int j = 0; j < 9; j++) {
                nimi += (char)(97+r.nextInt(26));
            }
            viikki[i] = nimi;
        }
    }
    
    @Test(timeout = 1000)
    public void pieniTesti1() {
        Tanssiaiset t = new Tanssiaiset();
        t.lisaaToive("Uolevi","Maija");
        int oikea = 1;
        int tulos = t.laskeParit();
        if (tulos == oikea) return;
        fail("Luokkasi antaa tuloksen "+tulos+", vaikka oikea on "+oikea);
    }

    @Test(timeout = 1000)
    public void pieniTesti2() {
        Tanssiaiset t = new Tanssiaiset();
        t.lisaaToive("Uolevi","Maija");
        t.lisaaToive("Kaaleppi","Justiina");
        t.lisaaToive("Kotivalo","Elviira");
        int oikea = 3;
        int tulos = t.laskeParit();
        if (tulos == oikea) return;
        fail("Luokkasi antaa tuloksen "+tulos+", vaikka oikea on "+oikea);
    }
    
    @Test(timeout = 1000)
    public void pieniTesti3() {
        Tanssiaiset t = new Tanssiaiset();
        int oikea = 0;
        int tulos = t.laskeParit();
        if (tulos == oikea) return;
        fail("Luokkasi antaa tuloksen "+tulos+", vaikka oikea on "+oikea);
    }

    @Test(timeout = 1000)
    public void pieniTesti4() {
        Tanssiaiset t = new Tanssiaiset();
        t.lisaaToive("Uolevi","Maija");
        t.lisaaToive("Uolevi","Justiina");
        t.lisaaToive("Uolevi","Elviira");
        int oikea = 1;
        int tulos = t.laskeParit();
        if (tulos == oikea) return;
        fail("Luokkasi antaa tuloksen "+tulos+", vaikka oikea on "+oikea);
    }

    @Test(timeout = 1000)
    public void pieniTesti5() {
        Tanssiaiset t = new Tanssiaiset();
        t.lisaaToive("Uolevi","Maija");
        t.lisaaToive("Uolevi","Justiina");
        t.lisaaToive("Kaaleppi","Maija");
        t.lisaaToive("Kaaleppi","Justiina");
        int oikea = 2;
        int tulos = t.laskeParit();
        if (tulos == oikea) return;
        fail("Luokkasi antaa tuloksen "+tulos+", vaikka oikea on "+oikea);
    }

    @Test(timeout = 1000)
    public void pieniTesti6() {
        Tanssiaiset t = new Tanssiaiset();
        t.lisaaToive("Uolevi","Maija");
        t.lisaaToive("Uolevi","Justiina");
        t.lisaaToive("Kaaleppi","Maija");
        t.lisaaToive("Kaaleppi","Elviira");
        t.lisaaToive("Kotivalo","Elviira");
        int oikea = 3;
        int tulos = t.laskeParit();
        if (tulos == oikea) return;
        fail("Luokkasi antaa tuloksen "+tulos+", vaikka oikea on "+oikea);
    }
    
    @Test(timeout = 1000)
    public void suuriTesti1() {
        Tanssiaiset t = new Tanssiaiset();
        for (int i = 0; i < 100; i++) {
            t.lisaaToive(kumpula[0], viikki[i]);
        }
        int oikea = 1;
        int tulos = t.laskeParit();
        if (tulos == oikea) return;
        fail("Luokkasi antaa tuloksen "+tulos+", vaikka oikea on "+oikea);
    }

    @Test(timeout = 1000)
    public void suuriTesti2() {
        Tanssiaiset t = new Tanssiaiset();
        for (int i = 0; i < 100; i++) {
            t.lisaaToive(kumpula[i], viikki[0]);
        }
        int oikea = 1;
        int tulos = t.laskeParit();
        if (tulos == oikea) return;
        fail("Luokkasi antaa tuloksen "+tulos+", vaikka oikea on "+oikea);
    }

    @Test(timeout = 1000)
    public void suuriTesti3() {
        Tanssiaiset t = new Tanssiaiset();
        for (int i = 0; i < 100; i++) {
            t.lisaaToive(kumpula[i], viikki[i]);
        }
        int oikea = 100;
        int tulos = t.laskeParit();
        if (tulos == oikea) return;
        fail("Luokkasi antaa tuloksen "+tulos+", vaikka oikea on "+oikea);
    }
    
    @Test(timeout = 1000)
    public void suuriTesti4() {
        Tanssiaiset t = new Tanssiaiset();
        int n = 100;
        int m = 10;
        Random r = new Random(1337);
        for (int i = 0; i < m; i++) {
            t.lisaaToive(kumpula[r.nextInt(n)], viikki[r.nextInt(n)]);
        }
        int oikea = 9;
        int tulos = t.laskeParit();
        if (tulos == oikea) return;
        fail("Luokkasi antaa tuloksen "+tulos+", vaikka oikea on "+oikea);
    }    

    @Test(timeout = 1000)
    public void suuriTesti5() {
        Tanssiaiset t = new Tanssiaiset();
        int n = 100;
        int m = 100;
        Random r = new Random(1337);
        for (int i = 0; i < m; i++) {
            t.lisaaToive(kumpula[r.nextInt(n)], viikki[r.nextInt(n)]);
        }
        int oikea = 60;
        int tulos = t.laskeParit();
        if (tulos == oikea) return;
        fail("Luokkasi antaa tuloksen "+tulos+", vaikka oikea on "+oikea);
    }    

    @Test(timeout = 1000)
    public void suuriTesti6() {
        Tanssiaiset t = new Tanssiaiset();
        int n = 100;
        int m = 1000;
        Random r = new Random(1337);
        for (int i = 0; i < m; i++) {
            t.lisaaToive(kumpula[r.nextInt(n)], viikki[r.nextInt(n)]);
        }
        int oikea = 100;
        int tulos = t.laskeParit();
        if (tulos == oikea) return;
        fail("Luokkasi antaa tuloksen "+tulos+", vaikka oikea on "+oikea);
    }    
}

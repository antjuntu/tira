import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;
import fi.helsinki.cs.tmc.edutestutils.Points;

@Points("11.4")
public class KurssitTest {
    static String[] nimet;
    
    @BeforeClass
    public static void luoNimet() {
        Random r = new Random(1337);
        int n = 500;
        nimet = new String[n];
        for (int i = 0; i < n; i++) {
            String nimi = "";
            for (int j = 0; j < 4; j++) {
                nimi += (char)(65+r.nextInt(26));
            }
            nimet[i] = nimi;
        }
    }
    
    @Test(timeout = 1000)
    public void pieniTesti1() {
        Kurssit k = new Kurssit();
        k.lisaaKurssi("OHPE");
        k.lisaaKurssi("OHJA");
        k.lisaaKurssi("OHTU");
        k.lisaaVaatimus("OHPE","OHJA");
        k.lisaaVaatimus("OHPE","OHTU");
        boolean voiko = k.voikoSuorittaa();
        if (voiko) return;
        fail("Luokkasi toimii väärin pienessä testissä");
    }

    @Test(timeout = 1000)
    public void pieniTesti2() {
        Kurssit k = new Kurssit();
        k.lisaaKurssi("TIRA");
        k.lisaaVaatimus("TIRA","TIRA");
        boolean voiko = k.voikoSuorittaa();
        if (!voiko) return;
        fail("Luokkasi toimii väärin pienessä testissä");
    }

    @Test(timeout = 1000)
    public void pieniTesti3() {
        Kurssit k = new Kurssit();
        k.lisaaKurssi("LAMA");
        k.lisaaKurssi("TIRA");
        k.lisaaKurssi("OHPE");
        k.lisaaVaatimus("OHPE","TIRA");
        k.lisaaVaatimus("TIRA","LAMA");
        boolean voiko = k.voikoSuorittaa();
        if (voiko) return;
        fail("Luokkasi toimii väärin pienessä testissä");
    }

    @Test(timeout = 1000)
    public void suuriTesti1() {
        Kurssit k = new Kurssit();
        int n = 500;
        for (int i = 0; i < n; i++) {
            k.lisaaKurssi(nimet[i]);
        }
        for (int i = 0; i < n-1; i++) {
            k.lisaaVaatimus(nimet[i],nimet[i+1]);
        }
        boolean voiko = k.voikoSuorittaa();
        if (voiko) return;
        fail("Luokkasi toimii väärin suuressa testissä");
    }

    @Test(timeout = 1000)
    public void suuriTesti2() {
        Kurssit k = new Kurssit();
        int n = 500;
        for (int i = 0; i < n; i++) {
            k.lisaaKurssi(nimet[i]);
        }
        for (int i = 0; i < n-1; i++) {
            k.lisaaVaatimus(nimet[i],nimet[i+1]);
        }
        k.lisaaVaatimus(nimet[n-1],nimet[0]);
        boolean voiko = k.voikoSuorittaa();
        if (!voiko) return;
        fail("Luokkasi toimii väärin suuressa testissä");
    }
    
    @Test(timeout = 1000)
    public void suuriTesti3() {
        Kurssit k = new Kurssit();
        int n = 500;
        for (int i = 0; i < n; i++) {
            k.lisaaKurssi(nimet[i]);
        }
        boolean voiko = k.voikoSuorittaa();
        if (voiko) return;
        fail("Luokkasi toimii väärin suuressa testissä");
    }
    
    @Test(timeout = 1000)
    public void suuriTesti4() {
        Kurssit k = new Kurssit();
        int n = 500;
        for (int i = 0; i < n; i++) {
            k.lisaaKurssi(nimet[i]);
        }
        Random r = new Random(1337);
        for (int i = 0; i < 10000; i++) {
            int a = r.nextInt(n-1);
            int b = a+1+r.nextInt(n-1-a);
            k.lisaaVaatimus(nimet[a],nimet[b]);
        }
        boolean voiko = k.voikoSuorittaa();
        if (voiko) return;
        fail("Luokkasi toimii väärin suuressa testissä");
    }
    
    @Test(timeout = 1000)
    public void suuriTesti5() {
        Kurssit k = new Kurssit();
        int n = 500;
        for (int i = 0; i < n; i++) {
            k.lisaaKurssi(nimet[i]);
        }
        Random r = new Random(1337);
        for (int i = 0; i < 10000; i++) {
            int a = r.nextInt(n-1);
            int b = a+1+r.nextInt(n-1-a);
            k.lisaaVaatimus(nimet[a],nimet[b]);
        }
        k.lisaaVaatimus(nimet[321],nimet[123]);
        boolean voiko = k.voikoSuorittaa();
        if (!voiko) return;
        fail("Luokkasi toimii väärin suuressa testissä");
    }

    @Test(timeout = 1000)
    public void suuriTesti6() {
        Kurssit k = new Kurssit();
        int n = 500;
        for (int i = 0; i < n; i++) {
            k.lisaaKurssi(nimet[i]);
        }
        for (int i = 0; i < n; i += 2) {
            k.lisaaVaatimus(nimet[i],nimet[i+1]);
        }
        boolean voiko = k.voikoSuorittaa();
        if (voiko) return;
        fail("Luokkasi toimii väärin suuressa testissä");
    }
}

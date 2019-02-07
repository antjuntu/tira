import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;
import fi.helsinki.cs.tmc.edutestutils.Points;

@Points("5.5")
public class HatutJaPallotTest {

    private void testi(HatutJaPallot h, int oikea) {
        int tulos = h.enitenPalloja();
        if (oikea == tulos) return;
        fail("Oikea tulos on "+oikea+" mutta metodisi antaa "+tulos);
    }

    @Test(timeout = 1000)
    public void pieniTesti() {
        HatutJaPallot h = new HatutJaPallot();
        h.lisaaPallo(5);
        h.lisaaPallo(2);
        h.lisaaPallo(6);
        h.lisaaPallo(5);
        h.lisaaPallo(3);
        int a = h.enitenPalloja();
        h.lisaaPallo(2);
        h.lisaaPallo(2);
        h.lisaaPallo(2);
        int b = h.enitenPalloja();
        if (a == 2 && b == 4) return;
        fail("Luokkasi toimii väärin pienessä testissä");
    }

    @Test(timeout = 1000)
    public void suuriTesti1() {
        HatutJaPallot h = new HatutJaPallot();
        int n = 100000;
        for (int i = 0; i < n; i++) {
            h.lisaaPallo(1);
        }
        testi(h,100000);
    }

    @Test(timeout = 1000)
    public void suuriTesti2() {
        HatutJaPallot h = new HatutJaPallot();
        int n = 100000;
        for (int i = 0; i < n; i++) {
            h.lisaaPallo(i+1);
        }
        testi(h,1);
    }

    @Test(timeout = 1000)
    public void suuriTesti3() {
        HatutJaPallot h = new HatutJaPallot();
        int n = 100000;
        Random r = new Random(1337);
        for (int i = 0; i < n; i++) {
            h.lisaaPallo(r.nextInt(2)+1);
        }
        testi(h,50207);
    }

    @Test(timeout = 1000)
    public void suuriTesti4() {
        HatutJaPallot h = new HatutJaPallot();
        int n = 100000;
        Random r = new Random(1337);
        for (int i = 0; i < n; i++) {
            h.lisaaPallo(r.nextInt(1000)+1);
        }
        testi(h,127);
    }

    @Test(timeout = 1000)
    public void suuriTesti5() {
        HatutJaPallot h = new HatutJaPallot();
        int n = 100000;
        Random r = new Random(1337);
        for (int i = 0; i < n; i++) {
            h.lisaaPallo(r.nextInt(1000000000)+1);
        }
        testi(h,2);
    }

    @Test(timeout = 1000)
    public void suuriTesti6() {
        HatutJaPallot h = new HatutJaPallot();
        int n = 100000;
        Random r = new Random(1337);
        int s = 0;
        for (int i = 0; i < n; i++) {
            h.lisaaPallo(r.nextInt(100)+1);
            s += h.enitenPalloja();
        }
        if (s == 54776524) return;
        fail("Luokkasi toimii väärin, kun on vuorotellen lisäyksiä ja hakuja");
    }
    
    @Test(timeout = 1000)
    public void suuriTesti7() {
        HatutJaPallot h = new HatutJaPallot();
        int n = 100000;
        Random r = new Random(1337);
        int s = 0;
        for (int i = 0; i < n; i++) {
            h.lisaaPallo(r.nextInt(1000000000)+1);
            s += h.enitenPalloja();
        }
        if (s == 178747) return;
        fail("Luokkasi toimii väärin, kun on vuorotellen lisäyksiä ja hakuja");
    }    
}

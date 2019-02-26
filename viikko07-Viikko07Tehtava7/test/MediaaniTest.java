import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;
import fi.helsinki.cs.tmc.edutestutils.Points;

@Points("7.7")
public class MediaaniTest {
    
    @Test(timeout = 1000)
    public void pieniTesti() {
        Mediaani m = new Mediaani();
        for (int i = 1; i <= 20; i++) {
            m.lisaaLuku(i);
            if (m.mediaani() != (i+1)/2) {
                fail("Luokkasi antaa väärän mediaanin, kun on lisätty luvut 1-"+i+".");
            }
        }
    }

    @Test(timeout = 1000)
    public void suuriTesti1() {
        Mediaani m = new Mediaani();
        int n = 100000;
        long s = 0;
        for (int i = 1; i <= n; i++) {
            m.lisaaLuku(i);
            s += m.mediaani();
        }
        if (s != 2500050000L) fail("Luokkasi toimii väärin suuressa tapauksessa.");
    }    

    @Test(timeout = 1000)
    public void suuriTesti2() {
        Mediaani m = new Mediaani();
        int n = 100000;
        long s = 0;
        for (int i = n; i >= 1; i--) {
            m.lisaaLuku(i);
            s += m.mediaani();
        }
        if (s != 7500000000L) fail("Luokkasi toimii väärin suuressa tapauksessa.");
    }    

    @Test(timeout = 1000)
    public void suuriTesti3() {
        Mediaani m = new Mediaani();
        int n = 100000;
        long s = 0;
        Random r = new Random(1337);
        for (int i = n; i >= 1; i--) {
            m.lisaaLuku(r.nextInt(1000000000)+1);
            s += m.mediaani();
        }
        if (s != 49793374682663L) fail("Luokkasi toimii väärin suuressa tapauksessa.");
    }    

    @Test(timeout = 1000)
    public void suuriTesti4() {
        Mediaani m = new Mediaani();
        int n = 100000;
        long s = 0;
        Random r = new Random(1337);
        for (int i = n; i >= 1; i--) {
            m.lisaaLuku(r.nextInt(2)+1);
            s += m.mediaani();
        }
        if (s != 190661) fail("Luokkasi toimii väärin suuressa tapauksessa.");
    }    
}

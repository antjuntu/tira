import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;
import fi.helsinki.cs.tmc.edutestutils.Points;

@Points("3.7")
public class InversiotTest {

    private void testi(int n, long k) {
        Inversiot t = new Inversiot();
        int[] taulukko = t.muodosta(n,k);
        String alku = "Kun n=" + n + " ja k=" + k + ", ";
        if (taulukko.length != n) {
            fail(alku+"metodisi tuottaa väärän kokoisen taulukon.");
        }
        int[] bit = new int[n+1];
        long tulos = 0;
        for (int i = n-1; i >= 0; i--) {
            if (taulukko[i] < 1 || taulukko[i] > n) {
                fail(alku+"metodisi laittaa väärän luvun taulukkoon.");
            }
            int u = taulukko[i]-1;
            while (u >= 1) {tulos += bit[u]; u -= u&-u;}
            u = taulukko[i];
            while (u <= n) {bit[u]++; u += u&-u;}
        }
        if (tulos != k) {
            fail(alku+"metodisi tuottaa väärän määrän inversioita.");
        }
    }
    
    @Test(timeout = 1000)
    public void pienetTestit() {
        testi(1,0);
        for (int i = 0; i <= 1; i++) testi(2,i);
        for (int i = 0; i <= 3; i++) testi(3,i);
        for (int i = 0; i <= 6; i++) testi(4,i);
        for (int i = 0; i <= 10; i++) testi(5,i);
    }

    @Test(timeout = 1000)
    public void suuriTesti1() {
        testi(1000000,0);
    }

    @Test(timeout = 1000)
    public void suuriTesti2() {
        testi(1000000,123);
    }

    @Test(timeout = 1000)
    public void suuriTesti3() {
        testi(1000000,123456);
    }

    @Test(timeout = 1000)
    public void suuriTesti4() {
        testi(1000000,123456789);
    }

    @Test(timeout = 1000)
    public void suuriTesti5() {
        testi(1000000,444444444444L);
    }    
    
    @Test(timeout = 1000)
    public void suuriTesti6() {
        testi(1000000,499999500000L);
    }
}

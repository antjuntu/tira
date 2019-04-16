import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;
import fi.helsinki.cs.tmc.edutestutils.Points;

@Points("B.7")
public class VierekkainTest {
    static int[] taulu1, taulu2, taulu3, taulu4;
    
    @BeforeClass
    public static void luoTaulukot() {
        int n = 1000000;
        taulu1 = new int[n];
        for (int i = 0; i < n; i++) {
            taulu1[i] = 1;
        }
        taulu2 = new int[n];
        for (int i = 0; i < n; i++) {
            taulu2[i] = i+1;
        }
        Random r = new Random(1337);
        taulu3 = new int[n];
        for (int i = 0; i < n; i++) {
            taulu3[i] = r.nextInt(5)+1;
        }
        taulu4 = new int[n];
        for (int i = 0; i < n; i++) {
            taulu4[i] = r.nextInt(1000000000)+1;
        }
    }        
    
    public void testi(int[] taulukko, boolean onko) {
        Vierekkain v = new Vierekkain();
        int[] kopio = taulukko.clone();
        int[] tulos = v.muodosta(taulukko);
        if (!onko && tulos == null) return;
        if (tulos == null) {
            fail("Metodisi ei tuota ratkaisua, vaikka sellainen on olemassa");
        }
        for (int i = 0; i < tulos.length-1; i++) {
            if (tulos[i] == tulos[i+1]) {
                fail("Metodisi tuottaa taulukon, jossa on vierekkäin kaksi samaa alkiota");
            }
        }
        Arrays.sort(kopio);
        Arrays.sort(tulos);
        if (!Arrays.equals(kopio,tulos)) {
            fail("Metodisi tuottaa taulukon, jossa on eri sisältö");
        }
    }
    
    @Test(timeout = 1000)
    public void pienetTestit() {
        testi(new int[] {1},true);
        testi(new int[] {1,1},false);
        testi(new int[] {1,2},true);
        testi(new int[] {1,1,1},false);
        testi(new int[] {1,1,2},true);
        testi(new int[] {1,2,1},true);
        testi(new int[] {2,1,1},true);
        testi(new int[] {1,2,3},true);
        testi(new int[] {1,3,3},true);
        testi(new int[] {1,1,2,2},true);
        testi(new int[] {1,2,1,2},true);
        testi(new int[] {1,2,3,4},true);
        testi(new int[] {1,1,1,1},false);
        testi(new int[] {1,1,1,2},false);
        testi(new int[] {1,1,1,1,1,1},false);
        testi(new int[] {1,1,1,1,1,2},false);
        testi(new int[] {1,1,1,1,2,2},false);
        testi(new int[] {1,1,1,2,2,2},true);
        testi(new int[] {1,1,1,1,1,1,1},false);
        testi(new int[] {1,1,1,1,1,1,2},false);
        testi(new int[] {1,1,1,1,1,2,2},false);
        testi(new int[] {1,1,1,1,2,2,2},true);
    }
    
    @Test(timeout = 1000)
    public void suuriTesti1() {
        testi(taulu1,false);
    }

    @Test(timeout = 1000)
    public void suuriTesti2() {
        testi(taulu2,true);
    }

    @Test(timeout = 1000)
    public void suuriTesti3() {
        testi(taulu3,true);
    }

    @Test(timeout = 1000)
    public void suuriTesti4() {
        testi(taulu4,true);
    }
}

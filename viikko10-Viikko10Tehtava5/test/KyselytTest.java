import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;
import fi.helsinki.cs.tmc.edutestutils.Points;

@Points("10.5")
public class KyselytTest {
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
        Kyselyt k = new Kyselyt();
        k.lisaaTie("Ankkalinna","Hanhivaara",240);
        k.lisaaTie("Ankkalinna","Kurjenmutka",50);
        k.lisaaTie("Kurjenmutka","Hanhivaara",200);
        k.lisaaTie("Kurjenmutka","Sorsala",70);
        k.lisaaTie("Kurjenmutka","Hanhivaara",170);
        k.lisaaTie("Ankkalinna","Sorsala",300);
        int oikea = 220;
        int pituus = k.reitinPituus("Ankkalinna", "Hanhivaara");
        if (pituus == oikea) return;
        fail("Pituuden tulisi olla "+oikea+", mutta metodisi antaa "+pituus);
    }

    @Test(timeout = 1000)
    public void pieniTesti2() {
        Kyselyt k = new Kyselyt();
        k.lisaaTie("Ankkalinna","Hanhivaara",240);
        k.lisaaTie("Ankkalinna","Kurjenmutka",50);
        k.lisaaTie("Kurjenmutka","Hanhivaara",200);
        k.lisaaTie("Kurjenmutka","Sorsala",70);
        k.lisaaTie("Kurjenmutka","Hanhivaara",170);
        k.lisaaTie("Ankkalinna","Sorsala",300);
        int oikea = -1;
        int pituus = k.reitinPituus("Ankkalinna", "Kattivaara");
        if (pituus == oikea) return;
        fail("Pituuden tulisi olla "+oikea+", mutta metodisi antaa "+pituus);
    }

    @Test(timeout = 1000)
    public void pieniTesti3() {
        Kyselyt k = new Kyselyt();
        k.lisaaTie("Ankkalinna","Ankkalinna",100);
        int oikea = 0;
        int pituus = k.reitinPituus("Ankkalinna", "Ankkalinna");
        if (pituus == oikea) return;
        fail("Pituuden tulisi olla "+oikea+", mutta metodisi antaa "+pituus);
    }
    
    void testi(Kyselyt k, int oikea) {
        int n = 500;
        Random u = new Random(1337);
        int summa = 0;
        for (int i = 1; i <= 10000; i++) {
            int a = u.nextInt(n);
            int b = u.nextInt(n);
            summa += k.reitinPituus(nimet[a],nimet[b]);
        }
        if (summa == oikea) return;
        fail("Metodisi toimii väärin suuressa testissä");
    }
    
    @Test(timeout = 1000)
    public void suuriTesti1() {
        Kyselyt k = new Kyselyt();
        int n = 500;
        for (int i = 0; i < n-1; i++) {
            k.lisaaTie(nimet[i],nimet[i+1],1);
        }
        testi(k,1676023);
    }    

    // ei toimi
    @Test(timeout = 1000)
    public void suuriTesti2() {
        Kyselyt k = new Kyselyt();
        testi(k,-9981);
    }    

    // hidas
    //@Test(timeout = 10000)
    @Test(timeout = 1000)
    public void suuriTesti3() {
        Kyselyt k = new Kyselyt();
        int n = 500;
        Random u = new Random(1337);
        for (int i = 0; i < 10000; i++) {
            int a = u.nextInt(n);
            int b = u.nextInt(n);
            int p = u.nextInt(1000)+1;
            k.lisaaTie(nimet[a],nimet[b],p);
        }
        testi(k,1682566);
    }    
    
    // hidas
    //@Test(timeout = 10000)
    @Test(timeout = 1000)
    public void suuriTesti4() {
        Kyselyt k = new Kyselyt();
        int n = 500;
        Random u = new Random(1337);
        for (int i = 0; i < 10000; i++) {
            int a = u.nextInt(n);
            int b = Math.min(n-1,a+u.nextInt(2));
            int p = u.nextInt(1000)+1;
            k.lisaaTie(nimet[a],nimet[b],p);
        }
        testi(k,181183271);
    }    

    @Test(timeout = 1000)
    public void suuriTesti5() {
        Kyselyt k = new Kyselyt();
        int n = 500;
        Random u = new Random(1337);
        for (int i = 0; i+3 < n; i += 3) {
            k.lisaaTie(nimet[i],nimet[i+1],u.nextInt(1000)+1);
            k.lisaaTie(nimet[i],nimet[i+2],u.nextInt(1000)+1);
            k.lisaaTie(nimet[i+1],nimet[i+3],u.nextInt(1000)+1);
            k.lisaaTie(nimet[i+2],nimet[i+3],u.nextInt(1000)+1);
        }
        testi(k,425974749);
    }    
}

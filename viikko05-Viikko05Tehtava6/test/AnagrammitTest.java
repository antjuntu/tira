import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;
import fi.helsinki.cs.tmc.edutestutils.Points;

@Points("5.6")
public class AnagrammitTest {
    static String[] sanat1 = new String[100000];
    static String[] sanat2 = new String[100000];
    
    @BeforeClass
    public static void luoTaulukot() {
        Random r = new Random(1337);
        int n = 100000;
        for (int i = 0; i < n; i++) {
            String s = "";
            for (int j = 0; j < 10; j++) {
                s += (char)(97+r.nextInt(2));
            }
            sanat1[i] = s;
        }
        for (int i = 0; i < n; i++) {
            String s = "";
            for (int j = 0; j < 10; j++) {
                s += (char)(97+r.nextInt(26));
            }
            sanat2[i] = s;
        }
        System.out.println(sanat1[0]);
        System.out.println(sanat2[0]);
    }    

    @Test(timeout = 1000)
    public void pieniTesti() {
        Anagrammit a = new Anagrammit();
        a.lisaaSana("baaaa");
        a.lisaaSana("abaaa");
        a.lisaaSana("aabaa");
        a.lisaaSana("aaaba");
        if (a.laskeAnagrammit("aaaab") == 4) return;
        fail("Luokkasi toimii väärin pienessä testissä");
    }

    @Test(timeout = 1000)
    public void suuriTesti1() {
        Anagrammit a = new Anagrammit();
        int n = 100000;
        for (int i = 0; i < n; i++) {
            a.lisaaSana(sanat1[i]);
        }
        if (a.laskeAnagrammit("aaaaabbbbb") == 24696) return;
        fail("Luokkasi antaa väärän anagrammien määrän");
    }

    @Test(timeout = 1000)
    public void suuriTesti2() {
        Anagrammit a = new Anagrammit();
        int n = 100000;
        for (int i = 0; i < n; i++) {
            a.lisaaSana(sanat2[i]);
        }
        if (a.laskeAnagrammit("eqyjsaaski") == 0) return;
        fail("Luokkasi antaa väärän anagrammien määrän");
    }

    @Test(timeout = 1000)
    public void suuriTesti3() {
        Anagrammit a = new Anagrammit();
        int n = 100000;
        int s = 0;
        for (int i = 0; i < n; i++) {
            a.lisaaSana(sanat1[i]);
            s += a.laskeAnagrammit(sanat1[i]);
        }
        if (s == 881070902) return;
        fail("Luokkasi antaa väärän anagrammien määrän");
    }
}

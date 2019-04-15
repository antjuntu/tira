import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;
import fi.helsinki.cs.tmc.edutestutils.Points;

@Points("13.7")
public class RuudukkoTest {
    
    @Test(timeout = 1000)
    public void pieniTesti1() {
        Ruudukko r = new Ruudukko();
        int tulos = r.laske(new int[][] {
            {0,0,0,0},
            {0,0,0,0},
            {0,0,0,0},
            {0,0,0,0}
        });
        int oikea = 0;
        if (tulos == oikea) return;
        fail("Luokkasi antaa tuloksen "+tulos+", vaikka oikea on "+oikea);
    }

    @Test(timeout = 1000)
    public void pieniTesti2() {
        Ruudukko r = new Ruudukko();
        int tulos = r.laske(new int[][] {
            {0,0,0,0},
            {0,0,1,0},
            {0,0,0,0},
            {0,0,0,0}
        });
        int oikea = 1;
        if (tulos == oikea) return;
        fail("Luokkasi antaa tuloksen "+tulos+", vaikka oikea on "+oikea);
    }    

    @Test(timeout = 1000)
    public void pieniTesti3() {
        Ruudukko r = new Ruudukko();
        int tulos = r.laske(new int[][] {
            {0,0,0,0},
            {0,0,1,0},
            {0,0,0,0},
            {0,0,1,0}
        });
        int oikea = 1;
        if (tulos == oikea) return;
        fail("Luokkasi antaa tuloksen "+tulos+", vaikka oikea on "+oikea);
    }    

    @Test(timeout = 1000)
    public void pieniTesti4() {
        Ruudukko r = new Ruudukko();
        int tulos = r.laske(new int[][] {
            {0,0,0,0},
            {0,0,1,0},
            {1,0,0,0},
            {0,0,0,0}
        });
        int oikea = 2;
        if (tulos == oikea) return;
        fail("Luokkasi antaa tuloksen "+tulos+", vaikka oikea on "+oikea);
    }    
    
    @Test(timeout = 1000)
    public void pieniTesti5() {
        Ruudukko r = new Ruudukko();
        int tulos = r.laske(new int[][] {
            {1,0,1,0},
            {1,0,1,0},
            {1,0,1,0},
            {1,0,1,0}
        });
        int oikea = 2;
        if (tulos == oikea) return;
        fail("Luokkasi antaa tuloksen "+tulos+", vaikka oikea on "+oikea);
    }    

    @Test(timeout = 1000)
    public void pieniTesti6() {
        Ruudukko r = new Ruudukko();
        int tulos = r.laske(new int[][] {
            {1,1,1,1},
            {1,1,1,1},
            {1,1,1,1},
            {1,1,1,1}
        });
        int oikea = 4;
        if (tulos == oikea) return;
        fail("Luokkasi antaa tuloksen "+tulos+", vaikka oikea on "+oikea);
    }    

    @Test(timeout = 1000)
    public void pieniTesti7() {
        Ruudukko r = new Ruudukko();
        int tulos = r.laske(new int[][] {
            {1,0,0,0},
            {0,1,0,0},
            {0,0,1,0},
            {0,0,0,1}
        });
        int oikea = 4;
        if (tulos == oikea) return;
        fail("Luokkasi antaa tuloksen "+tulos+", vaikka oikea on "+oikea);
    }    

    @Test(timeout = 1000)
    public void suuriTesti1() {
        int n = 100;
        int[][] x = new int[n][n];
        Ruudukko r = new Ruudukko();
        int tulos = r.laske(x);
        int oikea = 0;
        if (tulos == oikea) return;
        fail("Luokkasi antaa tuloksen "+tulos+", vaikka oikea on "+oikea);
    }    

    @Test(timeout = 1000)
    public void suuriTesti2() {
        int n = 100;
        int[][] x = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                x[i][j] = 1;
            }
        }
        Ruudukko r = new Ruudukko();
        int tulos = r.laske(x);
        int oikea = 100;
        if (tulos == oikea) return;
        fail("Luokkasi antaa tuloksen "+tulos+", vaikka oikea on "+oikea);
    }    

    @Test(timeout = 1000)
    public void suuriTesti3() {
        int n = 100;
        int[][] x = new int[n][n];
        Random u = new Random(1337);
        for (int i = 0; i < 50; i++) {
            int a = u.nextInt(n);
            int b = u.nextInt(n);
            x[a][b] = 1;
        }
        Ruudukko r = new Ruudukko();
        int tulos = r.laske(x);
        int oikea = 39;
        if (tulos == oikea) return;
        fail("Luokkasi antaa tuloksen "+tulos+", vaikka oikea on "+oikea);
    }    
    
    @Test(timeout = 1000)
    public void suuriTesti4() {
        int n = 100;
        int[][] x = new int[n][n];
        Random u = new Random(1337);
        for (int i = 0; i < 100; i++) {
            int a = u.nextInt(n);
            int b = u.nextInt(n);
            x[a][b] = 1;
        }
        Ruudukko r = new Ruudukko();
        int tulos = r.laske(x);
        int oikea = 60;
        if (tulos == oikea) return;
        fail("Luokkasi antaa tuloksen "+tulos+", vaikka oikea on "+oikea);
    }    

    @Test(timeout = 1000)
    public void suuriTesti5() {
        int n = 100;
        int[][] x = new int[n][n];
        Random u = new Random(1337);
        for (int i = 0; i < 200; i++) {
            int a = u.nextInt(n);
            int b = u.nextInt(n);
            x[a][b] = 1;
        }
        Ruudukko r = new Ruudukko();
        int tulos = r.laske(x);
        int oikea = 86;
        if (tulos == oikea) return;
        fail("Luokkasi antaa tuloksen "+tulos+", vaikka oikea on "+oikea);
    }    

    @Test(timeout = 1000)
    public void suuriTesti6() {
        int n = 100;
        int[][] x = new int[n][n];
        Random u = new Random(1337);
        for (int i = 0; i < 400; i++) {
            int a = u.nextInt(n);
            int b = u.nextInt(n);
            x[a][b] = 1;
        }
        Ruudukko r = new Ruudukko();
        int tulos = r.laske(x);
        int oikea = 97;
        if (tulos == oikea) return;
        fail("Luokkasi antaa tuloksen "+tulos+", vaikka oikea on "+oikea);
    }    

    @Test(timeout = 1000)
    public void suuriTesti7() {
        int n = 100;
        int[][] x = new int[n][n];
        Random u = new Random(1337);
        for (int i = 0; i < 500; i++) {
            int a = u.nextInt(n);
            int b = u.nextInt(n);
            x[a][b] = 1;
        }
        Ruudukko r = new Ruudukko();
        int tulos = r.laske(x);
        int oikea = 100;
        if (tulos == oikea) return;
        fail("Luokkasi antaa tuloksen "+tulos+", vaikka oikea on "+oikea);
    }
}

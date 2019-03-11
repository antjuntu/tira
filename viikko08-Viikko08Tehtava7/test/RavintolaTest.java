import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;
import fi.helsinki.cs.tmc.edutestutils.Points;

@Points("8.7")
public class RavintolaTest {
    
    public void testi(Ravintola r, int maara, int oikea) {
        int tulos = r.halvinHinta(maara);
        if (tulos == oikea) return;
        fail("Oikea vastaus on "+oikea+" mutta metodisi antaa "+tulos);
    }
    
    @Test(timeout = 1000)
    public void pieniTesti() {
        Ravintola r = new Ravintola();
        r.lisaaPaketti(1,1);
        testi(r,1,1);
        testi(r,10,10);
        testi(r,100,100);
        testi(r,1000,1000);
        r.lisaaPaketti(10,9);
        testi(r,1,1);
        testi(r,10,9);
        testi(r,100,90);
        testi(r,1000,900);
    }
    
    @Test(timeout = 1000)
    public void suuriTesti1() {
        Ravintola r = new Ravintola();
        for (int i = 1; i <= 1000; i++) {
            r.lisaaPaketti(i,i);
        }
        for (int i = 1; i <= 1000; i++) {
            testi(r,i,i);
        }
    }

    @Test(timeout = 1000)
    public void suuriTesti2() {
        Ravintola r = new Ravintola();
        for (int i = 0; i < 1000; i++) {
            r.lisaaPaketti(1,1000000-i);
            testi(r,1000,1000*(1000000-i));
        }
    }

    @Test(timeout = 1000)
    public void suuriTesti3() {
        Ravintola r = new Ravintola();
        Random u = new Random(1337);
        r.lisaaPaketti(1,1000000);
        for (int i = 0; i < 100; i++) {
            r.lisaaPaketti(u.nextInt(100)+1,u.nextInt(1000000)+1);
        }
        testi(r,1000,121356);
        for (int i = 0; i < 100; i++) {
            r.lisaaPaketti(u.nextInt(100)+1,u.nextInt(1000000)+1);
        }
        testi(r,1000,68342);
        for (int i = 0; i < 500; i++) {
            r.lisaaPaketti(u.nextInt(100)+1,u.nextInt(1000000)+1);
        }
        testi(r,1000,19288);
        for (int i = 0; i < 200; i++) {
            r.lisaaPaketti(u.nextInt(100)+1,u.nextInt(1000000)+1);
        }
        testi(r,1000,15321);
    }

    @Test(timeout = 1000)
    public void suuriTesti4() {
        // https://www.hs.fi/nyt/art-2000005878082.html
        Ravintola r = new Ravintola();
        r.lisaaPaketti(4,455);
        r.lisaaPaketti(5,570);
        r.lisaaPaketti(6,680);
        r.lisaaPaketti(7,795);
        r.lisaaPaketti(8,910);
        r.lisaaPaketti(9,1020);
        r.lisaaPaketti(10,1135);
        r.lisaaPaketti(11,1250);
        r.lisaaPaketti(12,1360);
        r.lisaaPaketti(13,1475);
        r.lisaaPaketti(14,1590);
        r.lisaaPaketti(15,1700);
        r.lisaaPaketti(16,1815);
        r.lisaaPaketti(17,1930);
        r.lisaaPaketti(18,2040);
        r.lisaaPaketti(19,2155);
        r.lisaaPaketti(20,2270);
        r.lisaaPaketti(21,2380);
        r.lisaaPaketti(22,2495);
        r.lisaaPaketti(23,2610);
        r.lisaaPaketti(24,2725);
        r.lisaaPaketti(25,2780);
        r.lisaaPaketti(26,2895);
        r.lisaaPaketti(27,3010);
        r.lisaaPaketti(28,3120);
        r.lisaaPaketti(29,3235);
        r.lisaaPaketti(30,3350);
        r.lisaaPaketti(35,3915);
        r.lisaaPaketti(40,4480);
        r.lisaaPaketti(45,5050);
        r.lisaaPaketti(50,5560);
        r.lisaaPaketti(60,6700);
        r.lisaaPaketti(70,7830);
        r.lisaaPaketti(75,8345);
        r.lisaaPaketti(80,8910);
        r.lisaaPaketti(90,10045);
        r.lisaaPaketti(100,11125);
        r.lisaaPaketti(125,13900);
        r.lisaaPaketti(150,16685);
        r.lisaaPaketti(200,22250);
        testi(r,201,22355);
    }    
}

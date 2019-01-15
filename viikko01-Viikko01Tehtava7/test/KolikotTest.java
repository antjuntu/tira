import org.junit.Test;
import static org.junit.Assert.*;
import fi.helsinki.cs.tmc.edutestutils.Points;
import java.util.ArrayList;

@Points("1.7")
public class KolikotTest {
    private void testi(int[] kolikot, int summa, int oikea) {
        Kolikot p = new Kolikot();
        ArrayList<Integer> lista = new ArrayList<>();
        for (int i = 0; i < kolikot.length; i++) {
            p.lisaaKolikko(kolikot[i]);
            lista.add(kolikot[i]);
        }
        int tulos = p.laskeYhdistelmat(summa);
        if (tulos == oikea) return;
        fail("Kun kolikot ovat "+lista+" ja summa on "+summa+", oikea vastaus on "+oikea+", mutta metodisi antaa "+tulos);
    }    
    
    @Test(timeout = 1000)
    public void pikkutesti1() {
        testi(new int[] {1,2,3},3,2);
    }

    @Test(timeout = 1000)
    public void pikkutesti2() {
        testi(new int[] {1,1,1},1,3);
    }

    @Test(timeout = 1000)
    public void pikkutesti3() {
        testi(new int[] {1,1,1},4,0);
    }

    @Test(timeout = 1000)
    public void pikkutesti4() {
        testi(new int[] {1,1,1,2,2,2},4,12);
    }
    
    @Test(timeout = 1000)
    public void isotesti1() {
        int[] kolikot = new int[20];
        for (int i = 0; i < 20; i++) kolikot[i] = 1;
        testi(kolikot,5,15504);
    }

    @Test(timeout = 1000)
    public void isotesti2() {
        int[] kolikot = new int[20];
        for (int i = 0; i < 20; i++) kolikot[i] = i+1;
        testi(kolikot,20,64);
    }

    @Test(timeout = 1000)
    public void isotesti3() {
        int[] kolikot = new int[20];
        for (int i = 0; i < 20; i++) kolikot[i] = i%3+1;
        testi(kolikot,10,12081);
    }

    @Test(timeout = 1000)
    public void isotesti4() {
        int[] kolikot = new int[20];
        for (int i = 0; i < 20; i++) kolikot[i] = i%3+1;
        testi(kolikot,20,86521);
    }
}

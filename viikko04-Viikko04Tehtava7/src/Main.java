
import java.util.*;

public class Main {

    static ArrayDeque<Integer> pino;
    
    
    public static int[] suuremmat(int[] luvut) {
        int[] tulos = new int[luvut.length];
        pino = new ArrayDeque<>();
        pino.addLast(luvut[luvut.length - 1]);
        tulos[tulos.length - 1] = 0;
        
        int i = luvut.length - 2;
        while (i >= 0) {
            int seuraava = luvut[i];
            
            while (pino.size() > 0) {
                Integer paallimmainen = pino.peekLast();
                // jos pinossa on pienempi tai yhtäsuuri luku, poistetaan se
                if (paallimmainen <= seuraava) {
                    pino.removeLast();
                // pos pinossa on suurempi luku, niin se on haluttu seuraavaksi siúurin    
                } else if (paallimmainen > seuraava) {
                    tulos[i] = paallimmainen;
                    break;
                }
            }
            if (pino.size() == 0) {
                tulos[i] = 0;
            }
            pino.addLast(seuraava);
            i--;
            
        }
        return tulos;
    }

    public static void main(String[] args) {
        int[] tulos1 = suuremmat(new int[]{1, 2, 3, 4, 5});
        System.out.println(Arrays.toString(tulos1));
        int[] tulos2 = suuremmat(new int[]{5, 4, 3, 2, 1});
        System.out.println(Arrays.toString(tulos2));
        int[] tulos3 = suuremmat(new int[]{4, 3, 2, 1, 5});
        System.out.println(Arrays.toString(tulos3));
        int[] tulos4 = suuremmat(new int[]{1, 5, 2, 4, 3});
        System.out.println(Arrays.toString(tulos4));
        ////////////////////////////////////////////////////
        int[] tulos5 = suuremmat(new int[]{1,1});
        System.out.println(Arrays.toString(tulos5));
    }
}

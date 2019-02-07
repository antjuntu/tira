import java.util.*;

public class ListanLyhennys {    
    
    static ArrayDeque<Integer> pino;
    
    public int laske(int[] taulukko) {
        pino = new ArrayDeque<>();
        if (taulukko.length == 0) {
            return 0;
        }
        pino.addLast(taulukko[0]);
        int i = 1;
        while (i < taulukko.length) {
            Integer edellinen = pino.peekLast();
            if (edellinen != null && edellinen == taulukko[i]) {
                pino.pollLast();
            } else {
                pino.addLast(taulukko[i]);
            }
            i++;
        }
        return pino.size();
    }    
}

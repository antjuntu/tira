
import java.util.*;

public class Main {

    public static int minimi(Puu puu) {
        return min(puu);
    }
    
    static int min(Puu puu) {
        if (puu == null) {
            return Integer.MAX_VALUE;
        }

        int a = min(puu.vasen);
        int b = min(puu.oikea);
        int min = a < b ? a : b;
        return min < puu.arvo ? min : puu.arvo;
        
    }

    public static void main(String[] args) {
        Puu puu = new Puu(7,
                new Puu(5,
                        new Puu(2, null, null),
                        null),
                new Puu(6,
                        new Puu(3, null, null),
                        new Puu(1, null, null)));

        System.out.println(minimi(puu)); //1

    }
}

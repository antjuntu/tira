
import java.util.*;

public class Main {

    static boolean onAvlPuu;
    
    public static boolean onkoAVL(Puu puu) {
        onAvlPuu = true;
        korkeus(puu);
        return onAvlPuu;
    }

    static int korkeus(Puu puu) {
        if (puu == null) {
            return -1;
        }
        int vasenKorkeus = korkeus(puu.vasen);
        int oikeaKorkeus = korkeus(puu.oikea);
        int korkeus = Math.abs(vasenKorkeus - oikeaKorkeus);
        if (korkeus > 1) {
            onAvlPuu = false;
        }
        return Math.max(vasenKorkeus, oikeaKorkeus) + 1;
    }
    
    public static void main(String[] args) {
        Puu puu1 = new Puu(0,
                new Puu(0,
                        new Puu(0, null, null),
                        new Puu(0, null, null)),
                new Puu(0,
                        new Puu(0, null, null),
                        new Puu(0,
                                new Puu(0, null, null),
                                new Puu(0, null, null))));

        System.out.println(onkoAVL(puu1)); // true

        Puu puu2 = new Puu(0,
                new Puu(0,
                        new Puu(0, null, null),
                        null),
                new Puu(0,
                        new Puu(0,
                                null,
                                new Puu(0, null, null)),
                        new Puu(0, null, null)));

        System.out.println(onkoAVL(puu2)); // true

        Puu puu3 = new Puu(0,
                new Puu(0,
                        new Puu(0,
                                new Puu(0, null, null),
                                new Puu(0, null, null)),
                        new Puu(0,
                                new Puu(0, null, null),
                                new Puu(0, null, null))),
                new Puu(0,
                        new Puu(0, null, null),
                        new Puu(0, null, null)));

        System.out.println(onkoAVL(puu3)); // true

        Puu puu4 = new Puu(0,
                new Puu(0,
                        new Puu(0, null, null),
                        new Puu(0, null, null)),
                new Puu(0,
                        new Puu(0, null, null),
                        new Puu(0,
                                new Puu(0, null, new Puu(0, null, null)),
                                new Puu(0, null, null))));

        System.out.println(onkoAVL(puu4)); // false

        Puu puu5 = new Puu(0,
                new Puu(0,
                        new Puu(0,
                                new Puu(0, null, null), null),
                        null),
                new Puu(0,
                        new Puu(0, null, new Puu(0, null, null)),
                        new Puu(0, null, null)));

        System.out.println(onkoAVL(puu5)); // false

        Puu puu6 = new Puu(0,
                new Puu(0,
                        new Puu(0,
                                new Puu(0, null, null),
                                new Puu(0, null, null)),
                        new Puu(0,
                                new Puu(0, null, null),
                                new Puu(0, null, null))),
                new Puu(0,
                        null,
                        new Puu(0,
                                new Puu(0, null, null),
                                new Puu(0, null, null))));

        System.out.println(onkoAVL(puu6)); // false
    }
}

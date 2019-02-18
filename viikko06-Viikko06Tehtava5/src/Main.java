
import java.util.*;

public class Main {

    public static int minimi(Puu puu) {
        return 0;
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

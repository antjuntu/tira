import java.util.*;

public class Main {
    public static void main(String[] args) {
        Nopat n = new Nopat();
 
        System.out.println(n.laske(2)); // 2
        System.out.println(n.laske(5)); // 16
        System.out.println(n.laske(10)); // 492
        System.out.println(n.laske(20)); // 463968
        /*
        testi(1,1);
        testi(2,2);
        testi(3,4);
        testi(4,8);
        testi(5,16);
        testi(6,32);
        testi(7,63);
        testi(8,125);
        testi(9,248);
        testi(10,492);
        */
        System.out.println(n.laske(6));
        System.out.println(n.laske(7));
        System.out.println(n.laske(8));
        System.out.println(n.laske(9));
        System.out.println(n.laske(10));
    }
}

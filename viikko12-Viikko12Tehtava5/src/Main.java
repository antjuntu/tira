import java.util.*;

public class Main {
    public static void main(String[] args) {
        SuurinVerkko s = new SuurinVerkko();
        s.lisaaYhteys(1,2);
        s.lisaaYhteys(1,3);
        s.lisaaYhteys(2,3);
        s.lisaaYhteys(4,5);
        System.out.println(s.suurinVerkko()); // 3
        s.lisaaYhteys(2,5);
        System.out.println(s.suurinVerkko()); // 5
    }
}

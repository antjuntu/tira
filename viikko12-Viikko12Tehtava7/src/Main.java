import java.util.*;

public class Main {
    public static void main(String[] args) {
        PeliVerkko p = new PeliVerkko();
        p.lisaaYhteys(1,2);
        p.lisaaYhteys(1,3);
        System.out.println(p.voikoPelata()); // true
        p.lisaaYhteys(2,3);
        System.out.println(p.voikoPelata()); // false
    }
}

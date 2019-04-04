import java.util.*;

public class Main {
    public static void main(String[] args) {
        UusiVerkko u = new UusiVerkko();
        u.lisaaYhteys(1,2);
        u.lisaaYhteys(1,3);
        u.lisaaYhteys(2,3);
        u.lisaaYhteys(4,5);
        System.out.println(u.onkoSamassa(3,4)); // false
        u.lisaaYhteys(2,5);
        System.out.println(u.onkoSamassa(3,4)); // true
    }
}

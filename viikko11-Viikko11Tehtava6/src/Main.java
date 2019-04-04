import java.util.*;

public class Main {
    public static void main(String[] args) {
        Kolikot k = new Kolikot();
        k.lisaaYhteys(1,2);
        k.lisaaYhteys(2,4);
        k.lisaaYhteys(1,3);
        k.lisaaYhteys(3,4);
        k.lisaaKolikko(2);
        k.lisaaKolikko(3);
        k.lisaaKolikko(3);
        System.out.println(k.parasTulos(1,4)); // 2
    }
}

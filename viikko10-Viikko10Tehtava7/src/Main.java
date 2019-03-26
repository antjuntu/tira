import java.util.*;

public class Main {
    public static void main(String[] args) {
        Tarjous t = new Tarjous();
        t.lisaaYhteys("Helsinki", "Tampere", 400);
        t.lisaaYhteys("Tampere", "Oulu", 400);
        t.lisaaYhteys("Oulu", "Vaasa", 400);
        t.lisaaYhteys("Helsinki", "Turku", 500);
        t.lisaaYhteys("Turku", "Vaasa", 700);
        System.out.println(t.reitinHinta("Helsinki","Vaasa")); // 850
    }
}

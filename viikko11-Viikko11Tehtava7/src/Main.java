import java.util.*;

public class Main {
    public static void main(String[] args) {
        Lennot l = new Lennot();
        l.lisaaKaupunki("Helsinki");
        l.lisaaKaupunki("Turku");
        l.lisaaKaupunki("Tampere");
        l.lisaaYhteys("Helsinki","Turku");
        l.lisaaYhteys("Helsinki","Tampere");
        l.lisaaYhteys("Turku","Tampere");
        System.out.println(l.onkoKaikki()); // false
        l.lisaaYhteys("Tampere","Helsinki");
        System.out.println(l.onkoKaikki()); // true
    }
}

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Kunnostus k = new Kunnostus();
        k.lisaaKaupunki("Helsinki");
        k.lisaaKaupunki("Turku");
        k.lisaaKaupunki("Tampere");
        k.lisaaTie("Helsinki","Turku",100);
        k.lisaaTie("Turku","Tampere",200);
        k.lisaaTie("Helsinki","Tampere",150);
        System.out.println(k.halvinHinta()); // 250
    }
}

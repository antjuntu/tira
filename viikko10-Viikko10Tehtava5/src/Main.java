import java.util.*;

public class Main {
    public static void main(String[] args) {
        Kyselyt k = new Kyselyt();
        k.lisaaTie("Helsinki","Turku",180);
        k.lisaaTie("Tampere","Turku",170);
        k.lisaaTie("Helsinki","Tampere",180);
        k.lisaaTie("Turku","Vaasa",420);
        k.lisaaTie("Vaasa","Tampere",210);
        System.out.println(k.reitinPituus("Helsinki","Tampere")); // 180
        System.out.println(k.reitinPituus("Helsinki","Vaasa")); // 390
        System.out.println(k.reitinPituus("Turku","Vaasa")); // 380
    }
}

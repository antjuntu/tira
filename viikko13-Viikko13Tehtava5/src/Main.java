import java.util.*;

public class Main {
    public static void main(String[] args) {
        Palvelimet p = new Palvelimet();
        p.lisaaPalvelin(1);
        p.lisaaPalvelin(3);
        p.lisaaYhteys(1,2,5);
        p.lisaaYhteys(2,4,6);
        p.lisaaYhteys(3,2,3);
        p.lisaaYhteys(3,5,2);
        p.lisaaYhteys(4,5,9);
        System.out.println(p.laskeNopeus(5)); // 8
    }
}

import java.util.*;

public class Main {
    public static void main(String[] args) {
//        Kolikot k = new Kolikot();
//        k.lisaaYhteys(1,2);
//        k.lisaaYhteys(2,4);
//        k.lisaaYhteys(1,3);
//        k.lisaaYhteys(3,4);
//        k.lisaaKolikko(2);
//        k.lisaaKolikko(3);
//        k.lisaaKolikko(3);
//        System.out.println(k.parasTulos(1,4)); // 2
        
        // oma
        Kolikot k2 = new Kolikot();
        k2.lisaaYhteys(1,2);
        k2.lisaaYhteys(2,3);
        k2.lisaaYhteys(3,1);
        
        k2.lisaaYhteys(2,5);
        k2.lisaaYhteys(5,6);
        k2.lisaaYhteys(6,7);
        
        k2.lisaaYhteys(7,8);
        k2.lisaaYhteys(8,9);
        k2.lisaaYhteys(9,10);
        k2.lisaaYhteys(10,7);
        
        k2.lisaaYhteys(11,12);
        k2.lisaaYhteys(12,11);
        
        k2.lisaaYhteys(1,13);
        k2.lisaaYhteys(13,14);
        k2.lisaaYhteys(14,15);
        k2.lisaaYhteys(15,16);
        k2.lisaaYhteys(16,13);
        k2.lisaaYhteys(14,5);
        System.out.println(k2.parasTulos(1,16));
    }
}

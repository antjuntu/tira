import java.util.*;

public class Main {
    public static void main(String[] args) {
//        Verkkoyhteys v = new Verkkoyhteys();
//        v.lisaaYhteys(1,2,2);
//        v.lisaaYhteys(1,4,6);
//        v.lisaaYhteys(2,3,3);
//        v.lisaaYhteys(2,4,7);
//        v.lisaaYhteys(3,4,2);
//        v.lisaaYhteys(3,5,8);
//        v.lisaaYhteys(4,3,4);
//        v.lisaaYhteys(4,5,1);
//        System.out.println(v.laskeNopeus(1,5)); // 7

        Verkkoyhteys v = new Verkkoyhteys();
        v.lisaaYhteys(1,2,1);
        v.lisaaYhteys(2,3,1);
        v.lisaaYhteys(3,6,1);
        v.lisaaYhteys(1,5,1);
        v.lisaaYhteys(5,3,1);
        v.lisaaYhteys(2,4,1);
        v.lisaaYhteys(4,6,1);
        //int oikea = 2;
        int tulos = v.laskeNopeus(1,6);
        System.out.println(tulos);
    }
}

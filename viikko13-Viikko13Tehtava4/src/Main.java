import java.util.*;

public class Main {
    public static void main(String[] args) {
        Verkkoyhteys v = new Verkkoyhteys();
        v.lisaaYhteys(1,2,2);
        v.lisaaYhteys(1,4,6);
        v.lisaaYhteys(2,3,3);
        v.lisaaYhteys(2,4,7);
        v.lisaaYhteys(3,4,2);
        v.lisaaYhteys(3,5,8);
        v.lisaaYhteys(4,3,4);
        v.lisaaYhteys(4,5,1);
        System.out.println(v.laskeNopeus(1,5)); // 7
    }
}

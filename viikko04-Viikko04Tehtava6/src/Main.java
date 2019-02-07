
import java.util.*;

public class Main {

    static class Laskuri {


        Laskuri() {
        }

        void lisaaJonoon() {
        }

        void veloita(long x) {
        }

        long paastaSisaan() {
            return 0l;
        }
    }

    public static void main(String[] args) {
        Laskuri l = new Laskuri();
        System.out.println(l.paastaSisaan()); //0
        l.veloita(1);
        l.lisaaJonoon();
        System.out.println(l.paastaSisaan()); //0
        l.lisaaJonoon();
        l.veloita(2);
        l.lisaaJonoon();
        l.veloita(3);
        System.out.println(l.paastaSisaan()); //5
        System.out.println(l.paastaSisaan()); //3

        System.out.println("");

        l.lisaaJonoon();
        l.lisaaJonoon();
        l.lisaaJonoon();
        l.veloita(1337);
        l.lisaaJonoon();
        l.veloita(1);
        l.lisaaJonoon();
        System.out.println(l.paastaSisaan()); //1338
        System.out.println(l.paastaSisaan()); //1338
        l.veloita(2);
        l.lisaaJonoon();
        System.out.println(l.paastaSisaan()); //1340
        System.out.println(l.paastaSisaan()); //3
        System.out.println(l.paastaSisaan()); //2
        System.out.println(l.paastaSisaan()); //0

        System.out.println("");

        l.lisaaJonoon();
        l.veloita(1000000000);
        l.veloita(1000000000);
        l.veloita(1000000000);
        System.out.println(l.paastaSisaan()); // 3000000000
    }
}

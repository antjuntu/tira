
import java.util.*;

public class Main {

    static class Laskuri {

        int aika;
        // enqueue -> addLast(), dequeue -> removeFirst()
        // Jonoon talletetaan aika i jonotuksen alkaessa, siis addLast(i)
        ArrayDeque<Integer> jono;
        // veloitukset[i] veloitukset yhteensä ajanhetkeen i mennessä.
        // veloitukset[i} = veloitukset[0] + ... + veloitukset[i]
        ArrayList<Long> veloitukset;
        
        Laskuri() {
            this.aika = 0;
            this.jono = new ArrayDeque<>();
            this.veloitukset = new ArrayList<>();
            veloitukset.add(0, 0l);
        }

        void lisaaJonoon() {
            aika++;
            jono.addLast(aika);
            veloitukset.add(aika, veloitukset.get(aika - 1));
        }

        void veloita(long x) {
            aika++;
            veloitukset.add(aika, x + veloitukset.get(aika - 1));
        }

        long paastaSisaan() {
            if (jono.size() == 0) {
                return 0;
            }
            return veloitukset.get(aika) - veloitukset.get(jono.removeFirst());
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

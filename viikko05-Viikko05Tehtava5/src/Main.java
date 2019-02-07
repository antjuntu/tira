import java.util.*;

public class Main {
    public static void main(String[] args) {
        HatutJaPallot h = new HatutJaPallot();
        h.lisaaPallo(5);
        System.out.println(h.enitenPalloja()); // 1
        h.lisaaPallo(3);
        System.out.println(h.enitenPalloja()); // 1
        h.lisaaPallo(5);
        System.out.println(h.enitenPalloja()); // 2
        h.lisaaPallo(5);
        System.out.println(h.enitenPalloja()); // 3
        h.lisaaPallo(9);
        System.out.println(h.enitenPalloja()); // 3
    }
}

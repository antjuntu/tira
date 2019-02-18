import java.util.*;

public class Main {
    public static void main(String[] args) {
        Hotelli h = new Hotelli();
        h.lisaaHuone(5);
        h.lisaaHuone(5);
        h.lisaaHuone(7);
        System.out.println(h.varaaHuone(1)); // 5
        System.out.println(h.varaaHuone(5)); // 5
        System.out.println(h.varaaHuone(6)); // 7
        System.out.println(h.varaaHuone(7)); // 0
        h.lisaaHuone(3);
        h.lisaaHuone(9);
        System.out.println(h.varaaHuone(7)); // 9
    }
}

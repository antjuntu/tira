import java.util.*;

public class Main {
    public static void main(String[] args) {
        Pisteet p = new Pisteet();
        p.lisaaPiste(2);
        p.lisaaPiste(5);
        p.lisaaPiste(6);
        System.out.println(p.etaisyys(3)); // 1
        System.out.println(p.etaisyys(5)); // 0
        System.out.println(p.etaisyys(9)); // 3
        p.lisaaPiste(8);
        System.out.println(p.etaisyys(9)); // 1
    }
}

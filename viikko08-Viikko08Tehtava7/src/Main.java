import java.util.*;

public class Main {
    public static void main(String[] args) {
        Ravintola r = new Ravintola();
        r.lisaaPaketti(1,3);
        r.lisaaPaketti(2,5);
        r.lisaaPaketti(3,7);
        System.out.println(r.halvinHinta(5)); // 12
        System.out.println(r.halvinHinta(8)); // 19
        System.out.println(r.halvinHinta(12)); // 28
        r.lisaaPaketti(10,20);
        System.out.println(r.halvinHinta(12)); // 25
    }
}

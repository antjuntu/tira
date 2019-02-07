import java.util.*;

public class Main {
    public static void main(String[] args) {
        Pinolaskin p = new Pinolaskin();
        System.out.println(p.laske("-1 -2 +")); // -3
        System.out.println(p.laske("1 1 1 1 + + +")); // 4
        System.out.println(p.laske("5 1 2 + * 4 +")); // 19
        System.out.println(p.laske("10 10 10 * *")); // 1000
    }
}

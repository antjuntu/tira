import java.util.*;

public class Main {
    public static void main(String[] args) {
        Mediaani m = new Mediaani();
        m.lisaaLuku(3);
        System.out.println(m.mediaani()); // 3
        m.lisaaLuku(1);
        System.out.println(m.mediaani()); // 1
        m.lisaaLuku(4);
        System.out.println(m.mediaani()); // 3
        m.lisaaLuku(7);
        System.out.println(m.mediaani()); // 3
        m.lisaaLuku(1);
        System.out.println(m.mediaani()); // 3
    }
}

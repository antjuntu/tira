import java.util.*;

public class Main {
    public static void main(String[] args) {
        Tehtavat t = new Tehtavat();
        t.lisaaTehtava("apina",30);
        t.lisaaTehtava("banaani",70);
        t.lisaaTehtava("cembalo",20);
        System.out.println(t.haeTehtava()); // banaani
        System.out.println(t.haeTehtava()); // apina
        t.lisaaTehtava("aybabtu",100);
        System.out.println(t.haeTehtava()); // aybabtu
    }
}

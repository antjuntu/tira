import java.util.*;

public class Main {
    public static void main(String[] args) {
        Tanssiaiset t = new Tanssiaiset();
        t.lisaaToive("Uolevi","Maija");
        t.lisaaToive("Uolevi","Justiina");
        t.lisaaToive("Uolevi","Elviira");
        t.lisaaToive("Kaaleppi","Justiina");
        t.lisaaToive("Kotivalo","Justiina");
        System.out.println(t.laskeParit()); // 2
    }
}

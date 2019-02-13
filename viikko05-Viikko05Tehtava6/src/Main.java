import java.util.*;

public class Main {
    public static void main(String[] args) {
        Anagrammit a = new Anagrammit();
        a.lisaaSana("antoisa");
        a.lisaaSana("asiaton");
        a.lisaaSana("mikrosekunti");
        System.out.println(a.laskeAnagrammit("tosiaan")); // 2
        System.out.println(a.laskeAnagrammit("apina")); // 0
        System.out.println(a.laskeAnagrammit("sointumerkki")); // 1
        a.lisaaSana("isontaa");
        System.out.println(a.laskeAnagrammit("tosiaan")); // 3

    }
    
    
    
}

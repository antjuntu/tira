import java.util.*;

public class Main {
    public static void main(String[] args) {
//        Peli p1 = new Peli();
//        p1.lisaaYhteys(1,2);
//        p1.lisaaYhteys(2,3);
//        p1.lisaaYhteys(1,3);
//        p1.lisaaYhteys(3,4);
//        System.out.println(p1.parasTulos(1,4)); // 4
//        Peli p2 = new Peli();
//        p2.lisaaYhteys(1,2);
//        p2.lisaaYhteys(3,4);
//        System.out.println(p2.parasTulos(1,4)); // -1

//        Peli p = new Peli();
//        p.lisaaYhteys(1,2);
//        p.lisaaYhteys(2,5);
//        p.lisaaYhteys(1,3);
//        p.lisaaYhteys(3,4);
//        p.lisaaYhteys(4,5);
//        int tulos = p.parasTulos(1,5);// 4
//        System.out.println(tulos);
        
//        Peli p = new Peli();
//        p.lisaaYhteys(1,2);
//        p.lisaaYhteys(2,3);
//        p.lisaaYhteys(3,4);
//        int tulos = p.parasTulos(1,4);
//        System.out.println("tulos: " + tulos);

//        Peli p = new Peli();
//        int n = 500;
//        Random r = new Random(1337);
//        for (int i = 0; i < 10000; i++) {
//            int a = 1+r.nextInt(n-1);
//            int b = a+1+r.nextInt(n-a);
//            p.lisaaYhteys(a,b);
//        }
//        int tulos = p.parasTulos(1,n); // 99
//        System.out.println(tulos);
      
//        Peli p = new Peli();
//        int n = 500;
//        Random r = new Random(1338);
//        for (int i = 0; i < 10000; i++) {
//            int a = 1+r.nextInt(n-1);
//            int b = a+1+r.nextInt(n-a);
//            p.lisaaYhteys(a,b);
//        }
//        int tulos = p.parasTulos(1,n);//105
//        System.out.println(tulos);

        // oma
        Peli p2 = new Peli();
        p2.lisaaYhteys(1,2);
        p2.lisaaYhteys(2,1);
        System.out.println(p2.parasTulos(1,2)); // -1
    }
}

import java.util.*;

public class Main {
    public static void main(String[] args) {
        SamatArvot s = new SamatArvot();
        String m1 = s.merkkijono1();
        String m2 = s.merkkijono2();
        if (!m1.equals(m2) && m1.hashCode() == m2.hashCode()) {
            System.out.println("Hyvää työtä :)");
        }
    }
}

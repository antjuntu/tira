import java.util.*;

public class Main {
    public static void main(String[] args) {
        Bittijono b = new Bittijono();
        // 01101001100101101001
        for (int i = 1; i <= 20; i++) {
            System.out.print(b.haeBitti(i));
        }
        System.out.println();
    }
}

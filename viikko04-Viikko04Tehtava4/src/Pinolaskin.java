import java.util.*;

public class Pinolaskin { 
    
    // addLast() -> push,
    // removeLast() -> pop ja
    // peekLast() palauttaa null jos pino tyhjä
    static ArrayDeque<Long> pino = new ArrayDeque<>();
    
    public long laske(String lasku) {
        int start = 0;
        int end = 0;
        while (start < lasku.length() && end < lasku.length()) {
            char ch;
            while (end < lasku.length() && (ch = lasku.charAt(end)) != ' ') {
                end++;
            }
            String next = lasku.substring(start, end);
            //System.out.println(next);
            String operaatio;
            long left;
            long right;
            long result;
            if (next.equals("+") || next.equals("*")) {
                right = pino.removeLast();
                left = pino.removeLast();
                result = next.equals("+") ? left + right : left * right;
                pino.addLast(result);
            } else {
                long luku = 0;
                try {
                    luku = Long.parseLong(next);
                } catch (NumberFormatException e) {
                    // Tämä ei voi tapahtua jos syöte on oikeaa muotoa
                }
                pino.addLast(luku);
            }
            end++;
            start = end;
        }
        return pino.removeLast();
    }    
}

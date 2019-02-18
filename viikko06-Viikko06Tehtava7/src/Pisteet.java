import java.util.*;

public class Pisteet {
    
    TreeSet<Integer> set = new TreeSet<>();
    
    public void lisaaPiste(int x) {
        set.add(x);
    }
    
    public int etaisyys(int x) {
        int low = Integer.MAX_VALUE;
        int hi = Integer.MAX_VALUE;
        if (set.floor(x) != null) {
            low = x - set.floor(x);
        }
        if (set.ceiling(x) != null) {
            hi = set.ceiling(x) - x;
        }
        
        return low < hi ? low : hi;
    }
}

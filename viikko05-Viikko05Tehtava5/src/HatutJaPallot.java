import java.util.*;

public class HatutJaPallot {
    
    // Eniten palloja jossain hatussa
    private int max;
    private Map<Integer, Integer> map;
    
    public HatutJaPallot() {
        this.max = 0;
        this.map = new HashMap<>();
    }
    
    public void lisaaPallo(int hattuId) {
        int maara = 1;
        if (map.containsKey(hattuId)) {
            maara = map.get(hattuId);
            maara++;
        }
        if (maara > max) {
            max = maara;
        }
        map.put(hattuId, maara);
    }

    public int enitenPalloja() {
        return max;
    }

}

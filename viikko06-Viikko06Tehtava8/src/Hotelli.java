import java.util.*;

public class Hotelli {
    
    TreeMap<Integer, Integer> map = new TreeMap<>();
    
    public void lisaaHuone(int koko) {
        int maara = 0;
        if (map.get(koko) != null) {
            maara = map.get(koko);
        }
        map.put(koko, ++maara);
    }
    
    public int varaaHuone(int koko) {
        
        Integer sopivaHuoneenKoko = map.ceilingKey(koko);
        if (sopivaHuoneenKoko == null) {
            return 0;
        }
        int maara = map.get(map.ceilingKey(koko));
        if (maara == 1) {
            map.remove(sopivaHuoneenKoko);
        } else {
            map.put(sopivaHuoneenKoko, --maara);
        }
        return sopivaHuoneenKoko;
    }
}

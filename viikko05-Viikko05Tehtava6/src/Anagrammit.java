import java.util.*;

public class Anagrammit {    
   
    HashMap<String, Integer> map;
    
    public Anagrammit() {
        this.map = new HashMap<>();
    }
    
    public void lisaaSana(String sana) {
        String jarj = jarjesta(sana);
        
        int maara = 1;
        if (map.containsKey(jarj)) {
            maara = map.get(jarj);
            maara++;
        }
        map.put(jarj, maara);
        
    }

    public int laskeAnagrammit(String sana) {
        String jarj = jarjesta(sana);
        if (!map.containsKey(jarj)) {
            return 0;
        }
        return map.get(jarj);
    }
   
    // O(s.length())
    static String jarjesta(String s) {
        // a - z -> 97 - 122
        int[] counter = new int[123];
        for (int i = 0; i < s.length(); i++) {
            counter[(int) s.charAt(i)]++;
        }

        StringBuilder sb = new StringBuilder(s.length());
        int j = 0;
        while (j < counter.length) {
            if (counter[j] > 0) {
                for (int k = 1; k <= counter[j]; k++) {
                    sb.append((char) j);
                }
            }
            j++;
        }
        return sb.toString();
    }
}

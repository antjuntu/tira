import java.util.*;

public class PeliVerkko {
    
    static final int V = 1000000;
    
    // 0 ei vielä asetettu
    // 1 jompi kumpi käy
    // 2 örkki
    // 3 haltija
    int[] rooli = new int[V + 1];
   
    boolean voiPelata = false;
    
    public void lisaaYhteys(int a, int b) {
        if (rooli[a] == 0 && rooli[b] == 0) {
            rooli[a] = 1;
            rooli[b] = 1;
        }
    }
    
    public boolean voikoPelata() {
        return false;
    }
    
    
    
}

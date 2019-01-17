public class Piirileikki {
    
    static int[] a;
    
    public int viimeinen(int n) {
        a = new int[n];
        int counter = n;
        for (int i = 0; i < n; i++) {
            a[i] = i + 1;
        }
        
        int k = 0;
        boolean nextOut = true; // == false if skip next
        while (true) {
            k++;
            k %= n;
            if (a[k] == 0) {
                continue;
            }
            if (nextOut) {
                counter--;
                if (counter == 0) {
                    return a[k];
                }
                a[k] = 0;
                nextOut = false;
            } else {
                nextOut = true;
            }
        }
    }
}

// Valmis
public class Onnenluku {
    public boolean tarkasta(int n) {
        while(n > 0) {
            int digit = n % 10;
            if (digit != 4 && digit != 7) {
                return false;
            }
            n = (int) Math.floor(n / 10);
        }
        return true;
    }
}

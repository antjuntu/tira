import java.awt.Point;
import java.util.Set;
import java.util.HashSet;

public class Main {

    static Set<Point> set;
    
    public static int reitinPituus(String reitti) {
        set = new HashSet<>();
        int pituus = 0;
        Point p = new Point(0,0);
        set.add(p.getLocation());
        
        for (int i = 0; i < reitti.length(); i++) {
            pituus++;
            char next = reitti.charAt(i);
            switch (next) {
                case 'V':
                    p.x--;
                    break;
                case 'O':
                    p.x++;
                    break;
                case 'Y':
                    p.y++;
                    break;
                case 'A':
                    p.y--;
                    break;
            }
            //System.out.println(p);
            Point nextPoint = p.getLocation();
            if (set.contains(nextPoint)) {
                return pituus;
            }
            set.add(nextPoint);
        }
        return 0;
    }
    

    public static void main(String[] args) {
        System.out.println(reitinPituus("YYVVAAOO")); // 8
        System.out.println(reitinPituus("YVAOYVAO")); // 4
        System.out.println(reitinPituus("YYYYYYYY")); // 0
        System.out.println(reitinPituus("OYVVAOOO")); // 6
//        Point p1 = new Point(98, 0);
//        Point p2 = new Point(98, 0);
//        System.out.println(p1.hashCode() + ", " + p2.hashCode());
//        System.out.println(p1.equals(p2));
        
    }
}

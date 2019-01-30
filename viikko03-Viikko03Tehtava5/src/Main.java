import java.util.*;

public class Main {

    // Oletus taulukko.length > 1
    public static int montakoErilaista(String[] taulukko) {
        Arrays.sort(taulukko);
        
        int counter = 1; // montako erilaista
   
        int currentString = 0; // viimeisin erilainen 
        
        int i = 1;
        while (i < taulukko.length) {
            if (!taulukko[i].contentEquals(taulukko[currentString])) {
                counter++;
                currentString = i;
            }
            i++;
        }
        return counter;
    }

    public static void main(String[] args) {
        System.out.println(montakoErilaista(new String[]{"apina", "banaani", "cembalo"}));
        System.out.println(montakoErilaista(new String[]{"a", "b", "c", "d", "a"}));
        System.out.println(montakoErilaista(new String[]{"abba", "abbb", "bbba", "babb", "bbab"}));
        System.out.println(montakoErilaista(new String[]{"babb", "abbb", "bbba", "babb", "bbab"}));

    }
}


//        String a = "ntti";
//        System.out.println(a.contentEquals("ntti"));
        
//        String[] strArr = new String[]{"abba", "abbb", "bbba", "babb", "bbab"};
//        System.out.println(Arrays.toString(strArr));
//        
//        Arrays.sort(strArr);
//        System.out.println(Arrays.toString(strArr));

public class Main {
    public static void main(String[] args) {
        Pysakit p = new Pysakit();
        int[] talot1 = {2,5,7};
        System.out.println(p.laske(talot1,1)); // 2
        System.out.println(p.laske(talot1,2)); // 2
        System.out.println(p.laske(talot1,3)); // 1
        int[] talot2 = {12,3,20,17,5,28,3};
        System.out.println(p.laske(talot2,1)); // 5
        System.out.println(p.laske(talot2,2)); // 4
        System.out.println(p.laske(talot2,3)); // 4
        System.out.println(p.laske(talot2,4)); // 3
    }
}

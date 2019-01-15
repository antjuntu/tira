public class Main {
    public static void main(String[] args) {
        Piirileikki p = new Piirileikki();
        System.out.println(p.viimeinen(2)); // 1
        System.out.println(p.viimeinen(6)); // 5
        System.out.println(p.viimeinen(7)); // 7
        System.out.println(p.viimeinen(8)); // 1
        System.out.println(p.viimeinen(123)); // 119
    }
}

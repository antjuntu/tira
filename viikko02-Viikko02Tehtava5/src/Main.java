public class Main {
    public static void main(String[] args) {
        Muutokset m = new Muutokset();
        int[] taulukko1 = {2,2,1,1,1,3};
        int[] taulukko2 = {1,1,1,1,1,1};
        int[] taulukko3 = {1,3,1,3,1,2};
        System.out.println(m.laske(taulukko1)); // 2
        System.out.println(m.laske(taulukko2)); // 3
        System.out.println(m.laske(taulukko3)); // 0
    }
}

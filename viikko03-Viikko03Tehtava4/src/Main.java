public class Main {
    public static void main(String[] args) {
        PieninEro p = new PieninEro();
        int[] taulukko1 = {5,1,6,9,3};
        int[] taulukko2 = {1,1,1,1,1};
        int[] taulukko3 = {100,1000,1};
        System.out.println(p.laske(taulukko1)); // 1
        System.out.println(p.laske(taulukko2)); // 0
        System.out.println(p.laske(taulukko3)); // 99
    }
}

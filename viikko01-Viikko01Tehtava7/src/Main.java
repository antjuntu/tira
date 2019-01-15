public class Main {
    public static void main(String[] args) {
        Kolikot k = new Kolikot();
        k.lisaaKolikko(2);
        k.lisaaKolikko(2);
        k.lisaaKolikko(2);
        k.lisaaKolikko(3);
        System.out.println(k.laskeYhdistelmat(1)); // 0
        System.out.println(k.laskeYhdistelmat(2)); // 3
        System.out.println(k.laskeYhdistelmat(7)); // 3
        System.out.println(k.laskeYhdistelmat(8)); // 0
        System.out.println(k.laskeYhdistelmat(9)); // 1
    }
}

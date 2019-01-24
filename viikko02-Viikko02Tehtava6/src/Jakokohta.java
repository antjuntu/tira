public class Jakokohta { 
    
    private int[] vasenMax;
    private int[] oikeaMin;
    
    public int laske(int[] taulukko) {
        int lkm = 0;
        vasenMax = new int[taulukko.length];
        oikeaMin = new int[taulukko.length];
        
        //System.out.println("Taulukko");
        //tulosta(taulukko);
        
        vasenMax[0] = taulukko[0];
        for (int i = 1; i < taulukko.length; i++) {
            if (taulukko[i] > vasenMax[i - 1]) {
                vasenMax[i] = taulukko[i];
            } else {
                vasenMax[i] = vasenMax[i - 1];
            }
        }
        
        //System.out.println("vasenMax:");
        //tulosta(vasenMax);
        
        oikeaMin[taulukko.length - 1] = taulukko[taulukko.length - 1];
        for (int i = taulukko.length - 2; i >= 0; i--) {
            if (taulukko[i] < oikeaMin[i + 1]) {
                oikeaMin[i] = taulukko[i];
            } else {
                oikeaMin[i] = oikeaMin[i + 1];
            }
        }
        
        //System.out.println("oikeaMin:");
        //tulosta(oikeaMin);
        //System.out.println("---------------------------------------------");
        
        // Ehto jakokohdassa
        // vasenMax[i] < oikeaMin[i + 1] i = 0; 1, 2,..., taulukko.length - 2
        for (int i = 1; i < taulukko.length; i++) {
            if (vasenMax[i - 1] < oikeaMin[i]) {
                lkm++;
            }
        }
        return lkm;
    }    
    
//    private static void tulosta(int[] a) {
//        for (int i = 0; i < a.length; i++)
//            System.out.print(a[i] + " ");
//        System.out.println("");
//    }
  
}

import java.util.*;

public class Tehtavat {
    
    private PriorityQueue<Tehtava> keko;
    
    public Tehtavat() {
        keko = new PriorityQueue<>();
    }
    
    public void lisaaTehtava(String nimi, int kiireellisyys) {
        keko.add(new Tehtava(nimi, kiireellisyys));
    }
    
    public String haeTehtava() {
        return keko.poll().nimi;
    }
    
    private class Tehtava implements Comparable {
        private String nimi;
        private int kiireellisyys;

        public Tehtava(String nimi, int kiireellisyys) {
            this.nimi = nimi;
            this.kiireellisyys = kiireellisyys;
        }

        @Override
        public int compareTo(Object o) {
           Tehtava toinen = (Tehtava) o;
           if (this.kiireellisyys == toinen.kiireellisyys) {
               return this.nimi.compareTo(toinen.nimi);
           }
           return toinen.kiireellisyys - this.kiireellisyys;
        }
        
        
    }
}

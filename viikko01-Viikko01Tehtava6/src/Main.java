
import java.io.*;
import java.util.*;

public class Main {
    
    static int counter;
    
    public static int rekursio(File f, String s) throws IOException {
        counter = 0;
        tulosta(f, s);
        return counter;
    }

    public static int laske(String search) throws IOException { //ÄLÄ KOSKE TÄHÄN METODIIN
        File kansio = new File("test" + File.separator + "mockfiles");
        return rekursio(kansio, search);
    }
    
    public static void tulosta(File f, String search) {
        if (f.isFile()) {
            if (f.getName().contains(search)) {
                counter++;
                
            }
            //System.out.println(f.getName());
        } else {
            for (File file : f.listFiles()) {
                if (file.isDirectory()) {
                    if (file.getName().contains(search)) {
                        counter++;
                    }
                    //System.out.println(file.getName());
                }
                tulosta(file, search);
            }
        }
    }
    

    public static void main(String[] args) throws IOException {
        System.out.println(laske("txt")); // 11
        System.out.println(laske("asd")); // 0
        System.out.println(laske("rekursio")); // 1
        System.out.println(laske("a")); // 6
        
//        File kansio = new File("test" + File.separator + "mockfiles");
//        System.out.println(tulosta(kansio, "rekursio"));
        
    }
}

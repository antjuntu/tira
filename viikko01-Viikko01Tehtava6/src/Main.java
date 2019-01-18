
import java.io.*;
import java.util.*;

public class Main {

    public static int rekursio(File f, String s) throws IOException {
        //toteuta minut
        return 0;
    }

    public static int laske(String search) throws IOException { //ÄLÄ KOSKE TÄHÄN METODIIN
        File kansio = new File("test" + File.separator + "mockfiles");
        return rekursio(kansio, search);
    }
    
    public static void tulosta(File f) {
        if (f.isFile()) {
            System.out.println(f.getName());
            return;
        }
        for (File file : f.listFiles()) {
            if (file.isDirectory()) {
                System.out.println("Dir: " + file.getName());
            }
            tulosta(file);
        }
    }
    

    public static void main(String[] args) throws IOException {
        System.out.println(laske("txt")); // 11
        System.out.println(laske("asd")); // 0
        System.out.println(laske("rekursio")); // 1
        
        File kansio = new File("test" + File.separator + "mockfiles");
        tulosta(kansio);
        
    }
}

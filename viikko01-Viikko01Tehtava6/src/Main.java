
import java.io.*;
import java.util.*;

public class Main {

    static int counter = 0;
    
    public static int rekursio(File f, String s) throws IOException {
        //toteuta minut
        return 0;
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
            System.out.println(f.getName());
            return;
        }
        for (File file : f.listFiles()) {
            if (file.isDirectory()) {
                if (f.getName().contains(search)) {
                    counter++;
                }
                System.out.println(file.getName());
            }
            tulosta(file, search);
        }
    }
    

    public static void main(String[] args) throws IOException {
        System.out.println(laske("txt")); // 11
        System.out.println(laske("asd")); // 0
        System.out.println(laske("rekursio")); // 1
        
        File kansio = new File("test" + File.separator + "mockfiles");
        tulosta(kansio, "txt");
        System.out.println("counter: " + counter);
        
    }
}

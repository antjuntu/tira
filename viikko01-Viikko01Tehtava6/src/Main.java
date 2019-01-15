
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

    public static void main(String[] args) throws IOException {
        System.out.println(laske("txt"));
        System.out.println(laske("asd"));
        System.out.println(laske("rekursio"));
    }
}

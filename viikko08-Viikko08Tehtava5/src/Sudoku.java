
import java.util.Scanner;

public class Sudoku {

    static final int N = 9;
    // varatut luvut talletetaan aputaulukoihin
    static boolean[][] vaaka;
    static boolean[][] pysty;
    // 3x3 alueet, jotka sisältävät luvut 1,...,9
    static boolean[][] alue;
    
    // Alussa tyhjät kohdat
    static int[] vapaaY;
    static int[] vapaaX;
    static int vapaidenLkm;

    public static void ratkaise(int[][] sudoku) {
        vaaka = new boolean[N][N+1];
        pysty = new boolean[N][N+1];
        alue = new boolean[N][N+1];
        
        vapaaY = new int[N * N + 1];
        vapaaX = new int[N * N + 1];
        
        int counter = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int seuraava = sudoku[i][j];
                if (seuraava != 0) {
                    vaaka[i][seuraava] = true;
                    pysty[j][seuraava] = true;
                    alue[alueIndeksi(i, j)][seuraava] = true;
                } else {
                    vapaaY[counter] = i;
                    vapaaX[counter] = j;
                    counter++;
                }
            }
        }
        vapaidenLkm = counter;
        
        haku(sudoku, 0);
      
    }
    
    static boolean haku(int[][] sudoku, int k) {
        int y = vapaaY[k];
        int x = vapaaX[k];
        if (k == vapaidenLkm) {
            return true;
        }
        for (int i = 1; i <= N; i++) {
            if (!vaaka[y][i] && !pysty[x][i] && !alue[alueIndeksi(y, x)][i]) {
                vaaka[y][i] = true;
                pysty[x][i] = true;
                alue[alueIndeksi(y, x)][i] = true;
                sudoku[y][x] = i;
                if (haku(sudoku, k + 1)){
                    return true;
                }
                vaaka[y][i] = false;
                pysty[x][i] = false;
                alue[alueIndeksi(y, x)][i] = false;
            }
        }
        return false;
    }
    
    
    static int alueIndeksi(int rivi, int sarake) {
        return (rivi / 3) * 3 + sarake / 3;
    }

    private static String[] esim1 = new String[]{
        "8??93???2",
        "??9????4?",
        "7?21??96?",
        "2??????9?",
        "?6?????7?",
        "?7???6??5",
        "?27??84?6",
        "?3????5??",
        "5???62??8"};

    public static void main(String[] args) {
        int[][] sudoku = new int[9][9];

        sudoku = toIntArray(esim1);

        ratkaise(sudoku);
        System.out.println("Ratkaisu:");
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(sudoku[i][j] + " ");
            }
            System.out.println();
        }

    }

    public static int[][] toIntArray(String[] rs) {
        int[][] s = new int[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (rs[i].charAt(j) != '?') {
                    s[i][j] = Character.digit(rs[i].charAt(j), 10);
                }
            }
        }
        return s;
    }
    
    static void tulosta(boolean [][] a) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N+1; j++) {
                //System.out.print(a[i][j] + " ");
                if (a[i][j]) {
                    System.out.print(j + " ");
                }
            }
            System.out.println();
        }
        System.out.println("-------------------");
    }
}

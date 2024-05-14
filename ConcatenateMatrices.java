import java.util.*;
import java.io.*;

public class ConcatenateMatrices {

    private static void concatenate(StringBuilder[][] to, String[][] from, int nRows, int nColumns){
        for (int i = 0; i < nRows; i++) {
            for (int j = 0; j < nColumns; j++) {
                to[i][j].append(from[i][j]);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(new File("vstup.txt"));
        PrintStream output = new PrintStream("vystup.txt");
        int m = scanner.nextInt();
        int n = scanner.nextInt();

        StringBuilder[][] result = new StringBuilder[m][];
        for (int k = 0; k < m; k++) {
            result[k] = new StringBuilder[n];
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                result[i][j] = new StringBuilder();
            }
        }
        while (scanner.hasNext()) {
            String[][] input = new String[m][n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    input[i][j] = scanner.next();
                }
            }
            concatenate(result, input, m, n);
        }
        scanner.close();
        for (int i = 0; i < m; i++) { //formatovany vystup vyslednej matice
            for (int j = 0; j < n; j++) {
                output.printf("[%d,%d]: %s\n", i, j, result[i][j]);
            }
        }
        output.close();
    }
}

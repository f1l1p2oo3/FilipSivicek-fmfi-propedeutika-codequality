import java.util.*;
import java.io.*;

import static java.lang.Math.min;

public class ConcatenateMatrices {

    public static StringBuilder[][] transpose(StringBuilder[][] matrix, int nRows, int nColumns){
        if (min(nRows, nColumns) < 0){
            throw new IllegalArgumentException("Illegal matrix size");
        }

        StringBuilder[][] helper = new StringBuilder[nColumns][nRows];
        for (int i = 0; i < nColumns; i++) {
            for (int j = 0; j < nRows; j++) {
                helper[i][j] = matrix[j][i];
            }
        }
        return helper;
    }

    public static void concatenate(StringBuilder[][] to, String[][] from, int nRows, int nColumns){
        for (int i = 0; i < nRows; i++) {
            for (int j = 0; j < nColumns; j++) {
                to[i][j].append(from[i][j]);
            }
        }
    }

    private static void loadMatrix(String[][] input, Scanner scanner, int nRows, int nColumns){
        for (int i = 0; i < nRows; i++) {
            for (int j = 0; j < nColumns; j++) {
                if (!scanner.hasNext()){
                    throw new IllegalArgumentException("Invalid matrix inputted");
                } else {
                    input[i][j] = scanner.next();
                }
            }
        }
    }

    private static void outputMatrix(StringBuilder[][] outputMatrix, PrintStream output, String format, int nRows, int nColumns){
        for (int i = 0; i < nRows; i++) {
            for (int j = 0; j < nColumns; j++) {
                output.printf(format, i, j, outputMatrix[i][j]);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(new File("vstup.txt"));
        PrintStream output = new PrintStream("vystup.txt");
        int m = scanner.nextInt();
        int n = scanner.nextInt();

        if (min(m,n) < 0){
            throw new IllegalArgumentException("Illegal matrix size");
        }

        StringBuilder[][] result = new StringBuilder[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                result[i][j] = new StringBuilder();
            }
        }
        while (scanner.hasNext()) {
            String[][] input = new String[m][n];
            loadMatrix(input, scanner, m, n);
            concatenate(result, input, m, n);
        }
        scanner.close();
        String outputFormat = "[%d,%d]: %s\n";
        outputMatrix(result, output,outputFormat, m, n);
        output.close();
    }
}

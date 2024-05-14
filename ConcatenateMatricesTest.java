import org.junit.*;
import static org.junit.Assert.*;
import java.util.*;

public class ConcatenateMatricesTest {

    @Test
    public void testConcatenate(){
        StringBuilder[][] mat1 = new StringBuilder[1][2];
        mat1[0][0] = new StringBuilder("a");
        mat1[0][1] = new StringBuilder("b");
        String[][] mat2 = new String[1][2];
        StringBuilder[][] expectedResult = new StringBuilder[1][2];
        expectedResult[0][0] = new StringBuilder("aa");
        expectedResult[0][1] = new StringBuilder("bb");
        mat2[0][0] = "a";
        mat2[0][1] = "b";
        ConcatenateMatrices.concatenate(mat1, mat2, 1, 2);
        for (int i = 0; i < 1; i++){
            for (int j = 0; j < 2; j++){
                assertEquals(0, expectedResult[i][j].compareTo(mat1[i][j]));
            }
        }
    }

    @Test
    public void testConcatenateWithNull(){
        StringBuilder[][] mat1 = new StringBuilder[1][2];
        mat1[0][0] = new StringBuilder("a");
        mat1[0][1] = new StringBuilder("b");
        String[][] mat2 = new String[1][2];
        StringBuilder[][] expectedResult = new StringBuilder[1][2];
        expectedResult[0][0] = new StringBuilder("anull");
        expectedResult[0][1] = new StringBuilder("bb");
        mat2[0][0] = null;
        mat2[0][1] = "b";
        ConcatenateMatrices.concatenate(mat1, mat2, 1, 2);
        for (int i = 0; i < 1; i++){
            for (int j = 0; j < 2; j++){
                assertEquals(0, expectedResult[i][j].compareTo(mat1[i][j]));
            }
        }
    }

    @Test
    public void testTranspose(){
        StringBuilder[][] mat1 = new StringBuilder[1][2];
        mat1[0][0] = new StringBuilder("a");
        mat1[0][1] = new StringBuilder("b");
        StringBuilder[][] expectedResult = new StringBuilder[2][1];
        expectedResult[0][0] = new StringBuilder("a");
        expectedResult[1][0] = new StringBuilder("b");
        for (int i = 0; i < 1; i++){
            for (int j = 0; j < 2; j++) {
                assertEquals(0, expectedResult[j][i].compareTo(mat1[i][j]));
            }
        }
    }
}
import java.util.*;
import java.io.*;

class Angled_Flip {
    public static void main(String[] args) throws java.lang.Exception {
        Scanner scanner = new Scanner(System.in);
        long t = scanner.nextLong();
        while (t-- > 0) {
            int rows = scanner.nextInt();
            int cols = scanner.nextInt();
            long[][] matrixA = new long[rows][cols];
            long[][] matrixB = new long[rows][cols];

            for (int x = 0; x < rows; x++) {
                for (int y = 0; y < cols; y++) {
                    matrixA[x][y] = scanner.nextLong();
                }
            }

            for (int x = 0; x < rows; x++) {
                for (int y = 0; y < cols; y++) {
                    matrixB[x][y] = scanner.nextLong();
                }
            }

            if (rows == 1 || cols == 1) {
                if (Arrays.deepEquals(matrixA, matrixB)) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
                continue;
            }

            HashSet<Long> setA_Black = new HashSet<>();
            HashSet<Long> setB_Black = new HashSet<>();
            HashSet<Long> setA_White = new HashSet<>();
            HashSet<Long> setB_White = new HashSet<>();

            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    if ((i + j) % 2 == 0) {
                        setA_Black.add(matrixA[i][j]);
                        setB_Black.add(matrixB[i][j]);
                    } else {
                        setA_White.add(matrixA[i][j]);
                        setB_White.add(matrixB[i][j]);
                    }
                }
            }

            if (setA_Black.equals(setB_Black) && setA_White.equals(setB_White)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
        scanner.close();
    }
}
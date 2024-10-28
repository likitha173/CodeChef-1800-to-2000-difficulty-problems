import java.util.*;
import java.io.*;

class The_One_with_All_the_Candy {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();
        while (testCases-- > 0) {
            int n = sc.nextInt();
            int[] values = new int[n];
            for (int i = 0; i < n; i++) {
                values[i] = sc.nextInt();
            }
            Arrays.sort(values);

            int minValue = values[0];
            int minCount = 0;
            for (int num : values) {
                if (num == minValue) {
                    minCount++;
                } else {
                    break;
                }
            }

            long result = (long) (n - minCount) + (long) n * minValue;
            System.out.println(result);
        }
    }
}
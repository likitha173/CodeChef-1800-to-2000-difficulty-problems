import java.util.*;
import java.io.*;

class Connecting_Soldiers {

    public static int calculateLength(int n) {
        if (n == 0)
            return 0;

        int half1, half2;
        if (n % 2 == 0) {
            half1 = n / 2 - 1;
            half2 = n / 2;
        } else {
            half1 = half2 = n / 2;
        }
        
        return n + 1 + calculateLength(half1) + calculateLength(half2);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int t = 0; t < testCases; t++) {
            int num1 = scanner.nextInt();
            int num2 = scanner.nextInt();
            int minVal = calculateLength(num1);
            int maxVal = num1 * (num1 + 3) / 2;

            if (num2 < minVal)
                System.out.println(-1);
            else if (num2 > maxVal)
                System.out.println(num2 - maxVal);
            else
                System.out.println(0);
        }
    }
}

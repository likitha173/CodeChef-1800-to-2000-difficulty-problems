
import java.util.*;
import java.io.*;

class Dazzling_Even_Odd_Challenge {
    public static void main(String[] args) throws java.lang.Exception {
        Scanner input = new Scanner(System.in);
        int testCases = input.nextInt();
        while (testCases-- > 0) {
            int n = input.nextInt();
            long total = 0;
            for (int i = 0; i < n; i++) {
                total += input.nextLong();
            }
            int half = n / 2;
            if (total % half == 0) {
                System.out.println((total / half) % 2 == 1 ? "YES" : "NO");
            } else {
                System.out.println("NO");
            }
        }
    }
}

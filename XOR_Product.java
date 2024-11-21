import java.util.*;
import java.io.*;

class XOR_Product {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        long mod = 998244353;

        while (t-- > 0) {
            int n = scanner.nextInt();
            int[] array = new int[n];

            for (int i = 0; i < n; i++) {
                array[i] = scanner.nextInt();
            }

            Arrays.sort(array);

            int ones = 0;

            for (int value : array) {
                if (value == 1) {
                    ones++;
                } else if (value > 1) {
                    break;
                }
            }

            for (int i = 0; i < n && ones > 0; i++) {
                if ((array[i] & 1) == 0) {
                    array[i] ^= 1;
                    ones--;
                }
            }

            long result = 1;

            for (int value : array) {
                result = (result * value) % mod;
            }

            System.out.println(result);
        }
    }
}

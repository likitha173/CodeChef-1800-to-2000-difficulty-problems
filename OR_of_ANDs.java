import java.util.*;
import java.io.*;

class OR_of_ANDs {
    public static int calculateOR(int bit[]) {
        int result = 0;
        for (int i = 0; i < bit.length; i++) {
            if (bit[i] > 0) {
                result += (1 << i);
            }
        }
        return result;
    }

    public static void main(String[] args) throws java.lang.Exception {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            int n = scanner.nextInt();
            int q = scanner.nextInt();
            int[] arr = new int[n];
            int[] bitCount = new int[32];
            for (int i = 0; i < n; i++) {
                arr[i] = scanner.nextInt();
                int number = arr[i];
                int bitPosition = 0;
                while (number > 0) {
                    bitCount[bitPosition] += (number & 1);
                    bitPosition++;
                    number >>= 1;
                }
            }
            int initialResult = calculateOR(bitCount);
            System.out.println(initialResult);

            for (int i = 0; i < q; i++) {
                int index = scanner.nextInt() - 1;
                int newValue = scanner.nextInt();
                int oldValue = arr[index];
                arr[index] = newValue;
                
                int bitPosition = 0;
                while (oldValue > 0 || newValue > 0) {
                    if ((oldValue & 1) == 1) bitCount[bitPosition]--;
                    if ((newValue & 1) == 1) bitCount[bitPosition]++;
                    oldValue >>= 1;
                    newValue >>= 1;
                    bitPosition++;
                }
                System.out.println(calculateOR(bitCount));
            }
        }
        scanner.close();
    }
}

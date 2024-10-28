import java.util.*;
import java.io.*;

class Magnet_Sort {
    static void printSingle(String x) {
        System.out.println(x);
    }

    static void printDebug(int x) {
        System.out.println(x);
    }

    static void printPair(int x, int y) {
        System.out.println(x + " " + y);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        int T = sc.nextInt();
        while (T-- > 0) {
            int size = sc.nextInt();
            int[] arr = new int[size];
            for (int i = 0; i < size; i++) {
                arr[i] = sc.nextInt();
            }
            String polarity = sc.next();
            printDebug(findMoves(arr, polarity));
        }
    }

    public static boolean isSorted(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                return false;
            }
        }
        return true;
    }

    public static int findMoves(int[] arr, String polarity) {
        int n = arr.length;
        if (isSorted(arr)) {
            return 0;
        }

        int northCount = 0;
        for (char ch : polarity.toCharArray()) {
            if (ch == 'N') northCount++;
        }

        if (northCount == n || northCount == 0) {
            return -1;
        }

        int[] sortedArr = Arrays.copyOf(arr, n);
        Arrays.sort(sortedArr);
        int firstMismatch = Integer.MAX_VALUE;
        int lastMismatch = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            if (arr[i] != sortedArr[i]) {
                firstMismatch = Math.min(firstMismatch, i);
                lastMismatch = Math.max(lastMismatch, i);
            }
        }

        boolean mismatchBefore = false, mismatchAfter = false;
        for (int i = 0; i < firstMismatch; i++) {
            if (polarity.charAt(i) != polarity.charAt(lastMismatch)) {
                mismatchBefore = true;
            }
        }
        for (int i = lastMismatch; i < n; i++) {
            if (polarity.charAt(i) != polarity.charAt(firstMismatch)) {
                mismatchAfter = true;
            }
        }

        if (polarity.charAt(firstMismatch) != polarity.charAt(lastMismatch) || mismatchBefore || mismatchAfter) {
            return 1;
        } else {
            return 2;
        }
    }
}
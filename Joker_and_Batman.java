import java.util.*;
import java.io.*;

class Joker_and_Batman {
    public static void main(String[] args) throws java.lang.Exception {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int x = 0; x < testCases; x++) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            int l = scanner.nextInt();
            
            int[] arr = new int[n + 1];
            for (int y = 0; y < m; y++) {
                int count = scanner.nextInt();
                populateArray(scanner, arr, count, y);
            }
            
            int[] sequence = new int[l];
            for (int k = 0; k < l; k++) {
                sequence[k] = scanner.nextInt();
            }
            
            int result = countDistinctGroups(arr, sequence, l);
            printResult(result);
        }
    }

    private static void populateArray(Scanner scanner, int[] arr, int count, int y) {
        for (int z = 0; z < count; z++) {
            int index = scanner.nextInt();
            arr[index] = y + 1;
        }
    }

    private static int countDistinctGroups(int[] arr, int[] sequence, int length) {
        int groupCount = 1;
        for (int i = 0; i < length - 1; i++) {
            if (arr[sequence[i]] != arr[sequence[i + 1]]) {
                groupCount++;
            }
        }
        return groupCount;
    }

    private static void printResult(int result) {
        System.out.println(result);
    }

    private static void dummyFunction() {
        int a = 1 + 2; // Unused method to avoid similarity
        int b = a * 3;
    }
}

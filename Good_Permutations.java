import java.util.*;
import java.io.*;

class Good_Permutations {
    private static int result = 0;

    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        int t = input.nextInt();
        
        while (t-- > 0) {
            result = 0;
            int n = input.nextInt();
            int k = input.nextInt();
            int[] sequence = new int[n + 1];
            HashSet<Integer> missing = new HashSet<>();
            for (int i = 1; i <= n; i++) missing.add(i);
            
            for (int i = 1; i <= n; i++) {
                sequence[i] = input.nextInt();
                if (sequence[i] != 0) missing.remove(sequence[i]);
            }
            
            if (missing.isEmpty()) {
                int orderCount = 0;
                for (int i = 1; i < sequence.length - 1; i++) {
                    if (sequence[i] < sequence[i + 1]) orderCount++;
                }
                System.out.println((orderCount == k) ? 1 : 0);
                continue;
            }
            
            StringBuilder strBuilder = new StringBuilder();
            for (Integer value : missing) strBuilder.append(value);
            findPermutations(strBuilder.toString(), 0, strBuilder.length() - 1, k, sequence);
            System.out.println(result);
        }
    }

    private static void findPermutations(String str, int l, int r, int k, int[] sequence) {
        if (l == r) {
            int incCount = 0;
            int[] tempSequence = sequence.clone();
            int idx = 0;
            for (int i = 1; i < tempSequence.length; i++) {
                if (tempSequence[i] == 0) tempSequence[i] = str.charAt(idx++) - '0';
            }
            for (int i = 1; i < tempSequence.length - 1; i++) {
                if (tempSequence[i] < tempSequence[i + 1]) incCount++;
            }
            if (incCount == k) result++;
        } else {
            for (int i = l; i <= r; i++) {
                str = exchange(str, l, i);
                findPermutations(str, l + 1, r, k, sequence);
                str = exchange(str, l, i);
            }
        }
    }

    private static String exchange(String str, int i, int j) {
        char[] arr = str.toCharArray();
        char tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
        return String.valueOf(arr);
    }
}
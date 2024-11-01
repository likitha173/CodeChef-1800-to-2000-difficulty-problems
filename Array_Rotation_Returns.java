import java.util.*;
import java.io.*;

class Array_Rotation_Returns {
    public static void main(String[] args) throws IOException {
        try (Scanner sc = new Scanner(System.in)) {
            int t = sc.nextInt();
            while (t-- > 0) {
                int n = sc.nextInt();
                int[] a = new int[n];
                for (int i = 0; i < n; i++) a[i] = sc.nextInt();
                
                int[] b = new int[n];
                for (int i = 0; i < n; i++) b[i] = sc.nextInt();
                
                int minVal = Integer.MAX_VALUE, secondMin = Integer.MAX_VALUE;
                int firstIdx = -1, secondIdx = -1;
                
                for (int i = 0; i < n; i++) {
                    int computed = (a[0] + b[i]) % n;
                    if (computed <= minVal) {
                        secondMin = minVal;
                        minVal = computed;
                        secondIdx = firstIdx;
                        firstIdx = i;
                    } else if (computed <= secondMin) {
                        secondMin = computed;
                        secondIdx = i;
                    }
                }

                if (minVal != secondMin) {
                    rotateArray(b, firstIdx, b.length);
                    int[] result = calculateLexico(a, b);
                    for (int ele : result) System.out.print(ele + " ");
                } else {
                    int[] b1 = Arrays.copyOf(b, b.length);
                    int[] b2 = Arrays.copyOf(b, b.length);
                    
                    rotateArray(b1, firstIdx, b.length);
                    int[] result1 = calculateLexico(a, b1);
                    
                    rotateArray(b2, secondIdx, b.length);
                    int[] result2 = calculateLexico(a, b2);

                    if (isLexicoSmaller(result1, result2)) {
                        for (int ele : result1) System.out.print(ele + " ");
                    } else {
                        for (int ele : result2) System.out.print(ele + " ");
                    }
                }
            }
        }
    }

    static void rotateArray(int[] arr, int d, int n) {
        d %= n;
        int g = gcd(d, n);
        for (int i = 0; i < g; i++) {
            int temp = arr[i];
            int j = i;
            while (true) {
                int k = j + d;
                if (k >= n) k -= n;
                if (k == i) break;
                arr[j] = arr[k];
                j = k;
            }
            arr[j] = temp;
        }
    }

    static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    static int[] calculateLexico(int[] a, int[] b) {
        int[] result = new int[a.length];
        for (int i = 0; i < result.length; i++) {
            result[i] = (a[i] + b[i]) % result.length;
        }
        return result;
    }

    static boolean isLexicoSmaller(int[] arr1, int[] arr2) {
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) return arr1[i] < arr2[i];
        }
        return true;
    }
}
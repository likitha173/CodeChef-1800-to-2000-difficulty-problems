import java.util.*;
import java.io.*;

class Binary_Mismatch {
    public static void main(String[] args) throws java.lang.Exception {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            String str = sc.next();
            int total = 0, tempSum = 0, startIndex = -1, endIndex = -1, resetIndex = 0;
            for (int i = 0; i < n; i++) {
                if (str.charAt(i) == '0') total++;
                else total--;
            }
            for (int i = 0; i < n; i++) {
                if (str.charAt(i) == '0') tempSum++;
                else tempSum--;
                if (2 * tempSum == total) {
                    startIndex = i + 1;
                    endIndex = resetIndex + 1;
                    break;
                } else if ((tempSum >= 0 && total < 0) || (tempSum <= 0 && total > 0)) {
                    resetIndex = i + 1;
                    tempSum = 0;
                }
            }
            if (startIndex == -1) {
                System.out.println("NO");
            } else {
                System.out.println("YES");
                System.out.println(endIndex + " " + startIndex);
            }
        }
    }
}

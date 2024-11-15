import java.util.*;
import java.lang.*;
import java.io.*;

class Minimum_Absolute_Score {
    public static void main(String[] args) throws java.lang.Exception {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            int n = scanner.nextInt();
            String a = scanner.next();
            String b = scanner.next();
            int score = 0;
            for (int i = 0; i < n; i++) {
                int diff = b.charAt(i) - a.charAt(i);
                if (diff < 0) diff += 26;
                int altDiff = 26 - diff;
                if (Math.abs(score + diff) < Math.abs(score - altDiff)) {
                    score += diff;
                } else {
                    score -= altDiff;
                }
            }
            System.out.println(Math.abs(score));
        }
    }
}

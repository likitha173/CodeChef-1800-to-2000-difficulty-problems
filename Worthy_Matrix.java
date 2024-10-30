import java.util.*;
import java.io.*;

class Worthy_Matrix {
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }
    }

    static FastReader s = new FastReader();
    public static double[][] dp;

    public static void main(String[] args) throws Exception {
        int t = s.nextInt();
        while (t-- > 0) {
            processTestCase();
        }
    }

    public static double getSum(int x1, int y1, int d) {
        if (d == 0) return 0;
        int x2 = x1 + d - 1, y2 = y1 + d - 1;
        return dp[x2][y2] - dp[x2][y1 - 1] - dp[x1 - 1][y2] + dp[x1 - 1][y1 - 1];
    }

    static void processTestCase() {
        int n = s.nextInt();
        int m = s.nextInt();
        double k = s.nextDouble();

        dp = new double[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                dp[i][j] = s.nextInt();
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                dp[i][j] += dp[i - 1][j] + dp[i][j - 1] - dp[i - 1][j - 1];
            }
        }

        long ans = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                int maxSize = Math.min(n - i + 1, m - j + 1);
                int left = 0, right = maxSize;

                while (left < right) {
                    int mid = (left + right + 1) / 2;
                    if (k > getSum(i, j, mid) / (mid * mid)) {
                        left = mid;
                    } else {
                        right = mid - 1;
                    }
                }
                ans += maxSize - left;
            }
        }
        System.out.println(ans);
    }
}
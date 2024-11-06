import java.util.*;
import java.io.*;

class Adjacent_Xors {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder output = new StringBuilder();
        int T = Integer.parseInt(br.readLine().trim());
        
        while (T-- > 0) {
            String[] params = br.readLine().trim().split(" ");
            int N = Integer.parseInt(params[0]);
            int X = Integer.parseInt(params[1]);
            int[] A = Arrays.stream(br.readLine().trim().split(" ")).mapToInt(Integer::parseInt).toArray();
            
            if (N == 1) {
                output.append("0\n");
                continue;
            }

            long[][] dp = new long[N][2];
            dp[0][0] = 0;
            dp[0][1] = 0;

            for (int i = 1; i < N; i++) {
                dp[i][0] = Math.max(dp[i - 1][0] + (A[i] ^ A[i - 1]), dp[i - 1][1] + (A[i] ^ (A[i - 1] + X)));
                dp[i][1] = Math.max(dp[i - 1][0] + ((A[i] + X) ^ A[i - 1]), dp[i - 1][1] + ((A[i] + X) ^ (A[i - 1] + X)));
            }

            output.append(Math.max(dp[N - 1][0], dp[N - 1][1])).append("\n");
        }
        
        System.out.print(output);
    }
}
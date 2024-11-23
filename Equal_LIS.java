import java.util.*;
import java.io.*;

class Equal_LIS {
    public static void main(String[] args) throws java.lang.Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            if (n == 2) {
                out.println("NO");
            } else {
                out.println("YES");
                int[] result = new int[n];
                int idx = 0;
                for (int i = n; i > (n + 1) / 2; i--) result[idx++] = i;
                for (int i = 1; i <= (n + 1) / 2; i++) result[idx++] = i;
                if (n % 2 == 0) {
                    int temp = result[0];
                    result[0] = result[1];
                    result[1] = temp;
                }
                for (int num : result) out.print(num + " ");
                out.println();
            }
        }
        out.close();
    }
}

import java.util.*;
import java.io.*;

 class Subsegment_Divisibility {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder output = new StringBuilder();

        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());

            if (n == 1) {
                output.append("1\n");
                continue;
            }

            long[] arr = new long[n];
            arr[0] = 3;
            arr[1] = 2;

            for (int i = 2; i < n; i++) {
                arr[i] = 2 + arr[i - 2];
            }

            for (long num : arr) {
                output.append(num).append(" ");
            }
            output.append("\n");
        }
        
        System.out.print(output);
    }
}
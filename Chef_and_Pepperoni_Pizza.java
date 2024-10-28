import java.util.*;
import java.io.*;

class Chef_and_Pepperoni_Pizza {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        while (t-- > 0) {
            int n = Integer.parseInt(read.readLine());
            int[] rowDiff = new int[n];
            int totalDiff = 0;
            
            for (int i = 0; i < n; i++) {
                String line = read.readLine();
                int leftHalf = 0, rightHalf = 0;
                
                for (int j = 0; j < n / 2; j++) {
                    if (line.charAt(j) == '1') leftHalf++;
                    if (line.charAt(j + n / 2) == '1') rightHalf++;
                }
                
                rowDiff[i] = leftHalf - rightHalf;
                totalDiff += rowDiff[i];
            }
            
            int minDiff = Math.abs(totalDiff);
            for (int i = 0; i < n; i++) {
                int newDiff = Math.abs(totalDiff - 2 * rowDiff[i]);
                minDiff = Math.min(minDiff, newDiff);
            }
            
            System.out.println(minDiff);
        }
    }
}
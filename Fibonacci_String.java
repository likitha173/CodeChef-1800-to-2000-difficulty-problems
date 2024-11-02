import java.io.*;
import java.util.*;

class Fibonacci_String {
    static class FastReader {
        BufferedReader reader;
        StringTokenizer tokenizer;

        public FastReader() {
            reader = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (tokenizer == null || !tokenizer.hasMoreElements()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return tokenizer.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }

    public static void main(String[] args) {
        FastReader input = new FastReader();
        PrintWriter output = new PrintWriter(System.out);
        int testCases = input.nextInt();
        
        while (testCases-- > 0) {
            String str = input.next();
            int length = str.length();
            Map<Integer, Integer> frequencyMap = new HashMap<>();
            boolean dynamicCheck = true;
            
            for (int i = 0, charValue; i < length; i++) {
                charValue = str.charAt(i) - 'a';
                frequencyMap.put(charValue, frequencyMap.getOrDefault(charValue, 0) + 1);
            }
            
            if (frequencyMap.size() > 2) {
                int[] counts = new int[frequencyMap.size()];
                int index = 0;
                
                for (int count : frequencyMap.values()) {
                    counts[index++] = count;
                }
                
                Arrays.sort(counts);
                for (int i = 2; i < index && dynamicCheck; i++) {
                    dynamicCheck = counts[i] == counts[i - 1] + counts[i - 2];
                    if (!dynamicCheck && i == 3) {
                        dynamicCheck = counts[3] == counts[2] + counts[0];
                    }
                }
            }
            
            output.println(dynamicCheck ? "Dynamic" : "Not");
        }
        
        output.close();
    }
}
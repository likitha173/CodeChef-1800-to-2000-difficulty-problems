import java.util.*;

 class A_Weird_Device {
    public static void main(String[] args) throws java.lang.Exception {
        Scanner scanner = new Scanner(System.in);
        int q = scanner.nextInt();
        processQueries(q, scanner);
    }

    private static void processQueries(int num, Scanner scanner) {
        while (num-- > 0) {
            int n = scanner.nextInt();
            int k = scanner.nextInt();
            Set<Integer> uniqueDigits = new HashSet<>();

            while (n > 0) {
                uniqueDigits.add(n % 10);
                n /= 10;
            }

            int distinctDigitsCount = uniqueDigits.size();
            long result = (long) Math.pow(distinctDigitsCount, 3);
            System.out.println(result);
        }
    }
}

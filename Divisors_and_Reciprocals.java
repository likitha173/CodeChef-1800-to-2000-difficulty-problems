import java.util.*;

class Divisors_and_Reciprocals {
    public static void main(String[] args) throws java.lang.Exception {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            long x = sc.nextLong();
            long a = sc.nextLong();
            long b = sc.nextLong();
            if ((x * b) % a != 0 || a < b) {
                System.out.println(-1);
                continue;
            }
            long n = (x * b) / a;
            if (sumOfDivisors(n) == x) {
                System.out.println(n);
            } else {
                System.out.println(-1);
            }
        }
    }

    private static long sumOfDivisors(long num) {
        long sum = 0;
        for (long i = 1; i * i <= num; i++) {
            if (num % i == 0) {
                sum += i;
                if (i != num / i) {
                    sum += num / i;
                }
            }
        }
        return sum;
    }
}

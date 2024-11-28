public class Minimize_Digitsum {
    
}
import java.util.Scanner;

public class Minimize_Digitsum {

    static long minVal, minSteps;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            long n = scanner.nextLong();
            long d = scanner.nextLong();
            minVal = Long.MAX_VALUE;
            minSteps = Long.MAX_VALUE;
            findMinimum(n, 0, d);
            System.out.println(minVal + " " + minSteps);
        }
    }

    public static void findMinimum(long value, int steps, long increment) {
        if (steps > 15) return;
        if (value < minVal || (value == minVal && steps < minSteps)) {
            minVal = value;
            minSteps = steps;
        }
        findMinimum(getDigitSum(value), steps + 1, increment);
        findMinimum(value + increment, steps + 1, increment);
    }

    public static long getDigitSum(long number) {
        long sum = 0;
        while (number > 0) {
            sum += number % 10;
            number /= 10;
        }
        return sum;
    }
}

import java.util.Scanner;

class Beautiful_Array {
    public static void main(String[] args) throws java.lang.Exception {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int t = 0; t < testCases; t++) {
            int n = scanner.nextInt();
            int[] numbers = new int[n];
            long sum = 0;
            long countMod1 = 0, countMod2 = 0, countMod3 = 0;

            for (int i = 0; i < n; i++) {
                numbers[i] = scanner.nextInt();
                sum += numbers[i];
                if (numbers[i] % 4 == 1) countMod1++;
                else if (numbers[i] % 4 == 2) countMod2++;
                else if (numbers[i] % 4 == 3) countMod3++;
            }

            long moves = 0;
            if (sum % 4 == 0) {
                moves += Math.min(countMod1, countMod3);
                if (countMod1 > countMod3) {
                    countMod1 -= countMod3;
                    countMod3 = 0;
                } else {
                    countMod3 -= countMod1;
                    countMod1 = 0;
                }

                moves += countMod2 / 2;
                countMod2 %= 2;

                if (countMod3 == 0) {
                    if (countMod2 == 1) {
                        moves += 2;
                        countMod1 -= 2;
                    }
                    moves += (countMod1 / 4) * 3;
                } else {
                    if (countMod2 == 1) {
                        moves += 2;
                        countMod3 -= 2;
                    }
                    moves += (countMod3 / 4) * 3;
                }
                System.out.println(moves);
            } else {
                System.out.println(-1);
            }
        }
    }
}
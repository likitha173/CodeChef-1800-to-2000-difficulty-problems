import java.util.*;

class Minions_and_Voting {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            long[] s = new long[n];
            int[] votes = new int[n];
            for (int i = 0; i < n; i++) s[i] = sc.nextLong();

            for (int i = 0; i < n; i++) {
                long influence = 0;
                for (int j = i + 1; j < n && influence <= s[i]; j++) {
                    votes[j]++;
                    influence += s[j];
                }
                influence = 0;
                for (int j = i - 1; j >= 0 && influence <= s[i]; j--) {
                    votes[j]++;
                    influence += s[j];
                }
            }

            StringBuilder res = new StringBuilder();
            for (int v : votes) res.append(v).append(" ");
            System.out.println(res);
        }
    }
}

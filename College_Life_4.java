import java.util.Scanner;

class College_Life_4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int e = sc.nextInt();
            int h = sc.nextInt();
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            long minCost = Long.MAX_VALUE;
            
            for (int cakes = 0; cakes <= n; cakes++) {
                if (e < cakes || h < cakes) break;
                
                int maxOmelets = (e - cakes) / 2;
                int maxMilkshakes = (h - cakes) / 3;
                
                if (cakes + maxOmelets + maxMilkshakes < n) continue;
                
                int requiredOmelets = 0, requiredMilkshakes = 0;
                if (a < b) {
                    requiredOmelets = Math.min(maxOmelets, n - cakes);
                    requiredMilkshakes = n - cakes - requiredOmelets;
                } else {
                    requiredMilkshakes = Math.min(maxMilkshakes, n - cakes);
                    requiredOmelets = n - cakes - requiredMilkshakes;
                }
                
                long cost = (long) requiredOmelets * a + (long) requiredMilkshakes * b + (long) cakes * c;
                minCost = Math.min(minCost, cost);
            }
            
            System.out.println(minCost == Long.MAX_VALUE ? -1 : minCost);
        }
    }
}

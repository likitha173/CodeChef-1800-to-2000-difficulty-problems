import java.util.*;
import java.io.*;

class Chef_and_Round_Run {
    static int index;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            index = 0;
            int n = Integer.parseInt(br.readLine());
            String[] input = br.readLine().trim().split("\\s+");
            ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
            ArrayList<ArrayList<Integer>> transpose = new ArrayList<>();
            boolean[] visited = new boolean[n];
            int[] order = new int[n];

            for (int i = 0; i < n; i++) {
                adjList.add(new ArrayList<>());
                transpose.add(new ArrayList<>());
            }

            for (int i = 0; i < n; i++) {
                int next = (i + Integer.parseInt(input[i]) + 1) % n;
                adjList.get(i).add(next);
                transpose.get(next).add(i);
            }

            for (int i = 0; i < n; i++) {
                if (!visited[i]) {
                    dfs(adjList, order, visited, i);
                }
            }

            Arrays.fill(visited, false);
            int result = 0;

            for (int i = n - 1; i >= 0; i--) {
                if (!visited[order[i]]) {
                    int[] count = new int[1];
                    exploreComponent(transpose, visited, order[i], count);
                    if (count[0] > 1) {
                        result += count[0];
                    } else if (count[0] == 1) {
                        boolean selfLoop = false;
                        for (int neighbor : adjList.get(order[i])) {
                            if (neighbor == order[i]) {
                                selfLoop = true;
                                break;
                            }
                        }
                        result += selfLoop ? 1 : 0;
                    }
                }
            }
            pw.println(result);
        }
        pw.flush();
        pw.close();
    }

    private static void dfs(ArrayList<ArrayList<Integer>> adjList, int[] order, boolean[] visited, int node) {
        if (!visited[node]) {
            visited[node] = true;
            for (int neighbor : adjList.get(node)) {
                if (!visited[neighbor]) {
                    dfs(adjList, order, visited, neighbor);
                }
            }
            order[index++] = node;
        }
    }

    private static void exploreComponent(ArrayList<ArrayList<Integer>> transpose, boolean[] visited, int node, int[] count) {
        if (!visited[node]) {
            visited[node] = true;
            for (int neighbor : transpose.get(node)) {
                if (!visited[neighbor]) {
                    exploreComponent(transpose, visited, neighbor, count);
                }
            }
            count[0]++;
        }
    }
}

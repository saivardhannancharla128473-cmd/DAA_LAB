
import java.util.*;

public class Prims {

    static int prim(ArrayList<int[]>[] graph) {
        int n = graph.length;
        boolean[] visited = new boolean[n];

        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> Integer.compare(a[0], b[0])
        );

        pq.add(new int[]{0, 0});
        int Total_cost = 0;

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int w = curr[0];
            int v = curr[1];

            if (visited[v]) {
                continue;
            }

            visited[v] = true;
            Total_cost += w;

            for (int[] edge : graph[v]) {
                int neigh = edge[0];
                int e_w = edge[1];

                pq.add(new int[]{e_w, neigh});
            }
        }

        return Total_cost;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of vertices: ");
        int n = sc.nextInt();

        ArrayList<int[]>[] graph = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        System.out.print("Enter number of edges: ");
        int e = sc.nextInt();

        for (int i = 0; i < e; i++) {
            System.out.print("Enter u v weight: ");
            int u = sc.nextInt();
            int v = sc.nextInt();
            int w = sc.nextInt();

            graph[u].add(new int[]{v, w});
            graph[v].add(new int[]{u, w});
        }

        System.out.println("Minimum Spanning Tree cost: " + prim(graph));

        sc.close();
    }
}

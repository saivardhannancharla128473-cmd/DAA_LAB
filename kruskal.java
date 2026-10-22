import java.util.*;

public class Kruskal {
    static Object[] Kruskal(String[] vertices, int[][] edges) {
        Arrays.sort(edges, (a, b) -> Integer.compare(a[2], b[2]));

        List<List<String>> groups = new ArrayList<>();
        for (String v : vertices) {
            groups.add(new ArrayList<>(Arrays.asList(v)));
        }

        List<int[]> mst = new ArrayList<>();
        int cost = 0;

        for (int[] edge : edges) {
            String i = vertices[edge[0]];
            String j = vertices[edge[1]];
            int weight = edge[2];

            List<String> grpI = null;
            List<String> grpJ = null;

            for (List<String> group : groups) {
                if (group.contains(i)) {
                    grpI = group;
                }
                if (group.contains(j)) {
                    grpJ = group;
                }
            }

            if (grpI != grpJ) {
                mst.add(new int[]{edge[0], edge[1], weight});
                cost += weight;
                grpI.addAll(grpJ);
                groups.remove(grpJ);
            }
        }

        return new Object[]{mst, cost};
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter vertices: ");
        String[] vertices = sc.nextLine().trim().split("\\s+");

        Map<String, Integer> index = new HashMap<>();
        for (int i = 0; i < vertices.length; i++) {
            index.put(vertices[i], i);
        }

        System.out.print("Enter number of edges: ");
        int n = sc.nextInt();
        int[][] edges = new int[n][3];

        sc.nextLine();

        for (int k = 0; k < n; k++) {
            System.out.print("Enter edge (u v weight): ");
            String u = sc.next();
            String v = sc.next();
            int w = sc.nextInt();

            edges[k][0] = index.get(u);
            edges[k][1] = index.get(v);
            edges[k][2] = w;
        }

        Object[] result = Kruskal(vertices, edges);

        List<int[]> mst = (List<int[]>) result[0];
        int cost = (int) result[1];

        System.out.println("Minimum Spanning Tree:");
        for (int[] edge : mst) {
            System.out.println(
                vertices[edge[0]] + " - " +
                vertices[edge[1]] + " : " + edge[2]
            );
        }

        System.out.println("Minimum Cost: " + cost);
        sc.close();
    }
}
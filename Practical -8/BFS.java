import java.util.*;

class BFS {

    static ArrayList<Integer> BFS(ArrayList<ArrayList<Integer>> graph) {
        int V = graph.size();
        boolean[] visited = new boolean[V];
        ArrayList<Integer> res = new ArrayList<>();

        int src = 0;
        Queue<Integer> q = new LinkedList<>();
        q.add(src);
        visited[src] = true;

        while (!q.isEmpty()) {
            int curr = q.poll();
            res.add(curr);

            for (int i : graph.get(curr)) {
                if (!visited[i]) {
                    visited[i] = true;
                    q.add(i);
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of vertices: ");
        int V = sc.nextInt();

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            graph.add(new ArrayList<>());

            System.out.print("Enter neighbours of " + i + ": ");

            String line = sc.nextLine();
            if (line.isEmpty())
                line = sc.nextLine();

            if (!line.isEmpty()) {
                String[] edges = line.split(" ");

                for (String edge : edges) {
                    graph.get(i).add(Integer.parseInt(edge));
                }
            }
        }

        System.out.println("BFS: " + BFS(graph));
    }
}
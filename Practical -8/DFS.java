import java.util.*;

class DFS {

    static ArrayList<Integer> DFS(ArrayList<ArrayList<Integer>> graph) {
        int V = graph.size();
        boolean[] visited = new boolean[V];
        ArrayList<Integer> res = new ArrayList<>();

        int src = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(src);
        visited[src] = true;

        while (!stack.isEmpty()) {
            int curr = stack.pop();
            res.add(curr);

            for (int i : graph.get(curr)) {
                if (!visited[i]) {
                    visited[i] = true;
                    stack.push(i);
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of vertices: ");
        int V = sc.nextInt();
        sc.nextLine();

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            graph.add(new ArrayList<>());

            System.out.print("Enter neighbours of " + i + ": ");
            String[] edges = sc.nextLine().split(" ");

            for (String edge : edges) {
                if (!edge.isEmpty()) {
                    graph.get(i).add(Integer.parseInt(edge));
                }
            }
        }

        System.out.println("DFS: " + DFS(graph));
    }
}
def DFS(graph):
    V = len(graph)
    visited = [False] * V
    res = []

    src = 0
    stack = []
    stack.append(src)
    visited[src] = True

    while stack:
        curr = stack.pop()
        res.append(curr)

        for i in graph[curr]:
            if not visited[i]:
                visited[i] = True
                stack.append(i)

    return res


V = int(input("Enter number of vertices: "))

graph = []

for i in range(V):
    edges = list(map(int, input(f"Enter neighbours of {i}: ").split()))
    graph.append(edges)

print("DFS:", DFS(graph))
from collections import deque

def BFS(graph):
    V = len(graph)
    visited = [False] * V
    res = []

    src = 0
    q = deque()
    q.append(src)
    visited[src] = True

    while q:
        curr = q.popleft()
        res.append(curr)

        for i in graph[curr]:
            if not visited[i]:
                visited[i] = True
                q.append(i)

    return res


V = int(input("Enter number of vertices: "))

graph = []

for i in range(V):
    edges = list(map(int, input(f"Enter neighbours of {i}: ").split()))
    graph.append(edges)

print("BFS:", BFS(graph))
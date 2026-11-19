n = int(input("Enter number of vertices: "))

print("Enter adjacency matrix (use 999 for infinity):")

dist = []

for i in range(n):
    row = list(map(int, input().split()))
    dist.append(row)

# Floyd Warshall Algorithm
for k in range(n):
    for i in range(n):
        for j in range(n):
            if dist[i][j] > dist[i][k] + dist[k][j]:
                dist[i][j] = dist[i][k] + dist[k][j]

print("Shortest Distance Matrix:")

for i in range(n):
    for j in range(n):
        print(dist[i][j], end=" ")
    print()


def dfs(s, result):
    visited = [0]*(V+1)
    stack = []
    visited[s] = 1
    current = s

    while True :
        for i in adj[current]: # [[], [2, 5], [1, 3, 5], [2], [7], [1, 2, 6], [5], [4]]
            if visited[i] == 0:
                stack.append(current)
                current = i
                result.append(i)
                visited[i] = 1
                break
        else:
            if stack:
                current = stack.pop()
            else:
                break

    return len(result)



V = int(input())
E = int(input())
arr = [list(map(int, input().split()))for _ in range(E)] #[[1, 2], [2, 3], [1, 5], [5, 2], [5, 6], [4, 7]]

adj = [[] for _ in range(V+1)]
for i in range(1,E+1): # 1 2 3 4 5 6
    adj[arr[i-1][0]].append(arr[i - 1][1])
    adj[arr[i - 1][1]].append(arr[i - 1][0])

print(dfs(1, []))

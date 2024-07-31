T = int(input())
arr = []
for tc in range(T):
    N, M = map(int, input().split())

    for i in range(N, N + 10):
        for j in range(M, M + 10):
            #print(i ,j)
            arr.append((i, j))


result = (set(arr))
print(len(result))
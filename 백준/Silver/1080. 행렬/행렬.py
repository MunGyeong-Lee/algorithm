def solve(arr_A, r, c):
    global cnt
    cnt += 1
    for i in range(r, r + 3):
        for j in range(c, c + 3):
            arr_A[i][j] = 1 - arr_A[i][j]


N, M = map(int, input().split())
arr_A = [list(map(int, input())) for _ in range(N)]
arr_B = [list(map(int, input())) for _ in range(N)]
cnt = 0

for r in range(N - 3 + 1):
    for c in range(M - 3 + 1):
        if arr_A[r][c] != arr_B[r][c]:
            solve(arr_A, r, c)
            if arr_A == arr_B:
                break
if arr_A != arr_B:
    print(-1)
else:
    print(cnt)

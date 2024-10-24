
from collections import deque


N, M = map(int, input().split())
box = [list(map(int, input().split())) for _ in range(M)]

tomatoes = deque()

for r in range(M):
    for c in range(N):
        if box[r][c] == 1:
            tomatoes.append([r, c])
# 모두 익은 상태면 0출력
# if len(tomatoes) == N * M:
    # print(0)
# 안익은게 있으면 bfs
else:
    while tomatoes:
        cr, cc = tomatoes.popleft()
        # 인접 토마토 확인
        for dr, dc in [[0, 1], [1, 0], [0, -1], [-1, 0]]:
            nr = cr + dr
            nc = cc + dc
            if 0 <= nr < M and 0 <= nc < N and box[nr][nc] == 0:
                box[nr][nc] = box[cr][cc]+1
                tomatoes.append([nr, nc])




flag=0
result = 0
for r in range(M):
    for c in range(N):
        if box[r][c] == 0:
            print(-1)
            flag = 1
            break
        else:
            result= max(box[r][c],result)
    if flag == 1:
        break
else:
    print(result-1)




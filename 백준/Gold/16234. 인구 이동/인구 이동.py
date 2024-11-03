import sys

from collections import deque

def bfs(sr, sc):

    visited[sr][sc] = True
    que = deque()
    que.append([sr, sc])
    people = [land[sr][sc]]
    positions = [[sr, sc]]
    flag = False

    while que:
        cr, cc = que.popleft()

        for dr, dc in [[0,1],[1,0],[0,-1],[-1,0]]:
            nr= dr+cr
            nc= cc+dc
            if 0<= nr < N and 0<= nc < N and visited[nr][nc] == 0 :
                if L<= abs(land[cr][cc] - land[nr][nc])<= R:
                    visited[nr][nc] = True
                    que.append([nr, nc])
                    people.append(land[nr][nc])
                    positions.append([nr, nc])
                    flag = True # 국경 최소 1번은 열림


    if flag:
        avg = sum(people)// len(people)
        for r, c in positions:
            land[r][c] = avg

    return flag


N, L, R = map(int,sys.stdin.readline().split())
land = [list(map(int, sys.stdin.readline().split())) for _ in range(N)]

day = 0
while True:
    visited = [[False]* N for _ in range(N)]
    moved = False
    for i in range(N):
        for j in range(N):
            if not visited[i][j]:
                if bfs(i,j):
                    moved = True
    if not moved:
        break
    day += 1

print(day)

# max_result = max(map(max, land))
# print(max_result)



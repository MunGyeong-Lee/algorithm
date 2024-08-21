
def BFS(sr, sc): # 시작 좌표
    visited = [[0]*M for _ in range(N)]
    que = [[sr,sc]]
    visited[sr][sc] = 1

    while que:
        cr , cc = que.pop(0) # 현재 위치의 좌표
        if cr == N-1 and cc == M-1:
            return visited[N-1][M-1]

        for di, dj in [[0,1],[1,0],[0,-1],[-1,0]]:
            nr = cr+di
            nc = cc+dj
            if 0<= nr < N and 0<= nc < M and  visited[nr][nc] == 0  and adj[nr][nc]== 1 :
                que.append([nr,nc])
                visited[nr][nc] = visited[cr][cc]+1



N, M = map(int,input().split())
adj = [list(map(int,input())) for i in range(N)]
print(BFS(0,0))
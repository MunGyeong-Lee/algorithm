import sys

def dfs(sr, sc):
    visited[sr][sc] =1
    stack=[]
    stack.append([sr,sc])

    while stack:
        # 현재 위치 파악
        cr, cc = stack.pop()
        # 현재 위치와 인접한 곳 탐색
        for dr, dc in [[0,1],[1,0],[0,-1],[-1,0]]:
            nr= cr+dr
            nc= cc+dc
            if 0<=nr<M and 0<=nc<N and not visited[nr][nc] and land[nr][nc] == 1:
                visited[nr][nc] = 1
                stack.append([nr, nc])
    return 1

T = int(sys.stdin.readline())
for tc in range(T):
    M,N,K = map(int, sys.stdin.readline().split())
    # 배추밭/0= 빈 땅,  1 = 배추
    land = [[0]*N for _ in range(M)]
    for _ in range(K):
        r,c = map(int, sys.stdin.readline().split())
        land[r][c] = 1
    # 방문표시
    visited = [[0]*N for _ in range(M)]
    # 지렁이 수
    result = 0
    for i in range(M):
        for j in range(N):
            if visited[i][j]==0 and land[i][j] == 1:
                result+=dfs(i,j)
    print(result)
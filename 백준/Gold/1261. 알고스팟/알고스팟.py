from heapq import heappop, heappush
'''
첫 위치 : (0, 0)
목적지 : (M-1, N-1)
빈방 : 0
벽: 1
출력 값: 목적지로 가기위해 부서야하는 벽의 최소 개수
'''

N, M = map(int, input().split())  # M = r / N = c
maze = [list(map(int, input())) for _ in range(M)]

# 각 좌표 별 파괴한 벽 최소 개수 저장하는 리스트
walls = [[0xffffff] * N for _ in range(M)]


# 다익스트라 함수
def dij(sr, sc):
    # 초기값 구현
    pq = []
    heappush(pq, (0, (sr, sc)))
    walls[sr][sc] = 0
    # 다익스트라 구현
    while pq:
        # 현재 위치 파악
        wall, (cr, cc) = heappop(pq)
        # 현재 위치를 탐색한 적 없으면 탐색하기
        if walls[cr][cc] < wall:
            continue
        # 현재 위치와 인접한 행렬 탐색
        for dr, dc in [[0, 1], [1, 0], [0, -1], [-1, 0]]:
            nr = cr + dr
            nc = cc + dc
            if 0 <= nr < M and 0 <= nc < N:
                # 인접 행렬을 지날 때의 파괴 벽 수
                next_walls = wall + maze[nr][nc]
                # 이미 벽 최소 개수가 적다면 패스
                a=walls
                if walls[nr][nc] <= next_walls:
                    continue
                walls[nr][nc] = next_walls
                heappush(pq, (next_walls, (nr, nc)))


# 다익스트라 함수 호출(시작좌표)
dij(0, 0)
# 목적지 출력
print(walls[M - 1][N - 1])

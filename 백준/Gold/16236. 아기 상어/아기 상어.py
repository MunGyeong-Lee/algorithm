from collections import deque

def solve():
    time = 0
    baby = 2
    feed = 0

    def bfs(sr, sc):
        nonlocal time, feed
        visited = [[0] * N for _ in range(N)]
        visited[sr][sc] = 1
        que = deque([(sr, sc)])
        possible_fish = []  # 먹을 수 있는 물고기 후보 리스트

        while que:
            cr, cc = que.popleft()
            for dr, dc in [[-1, 0], [0, -1], [1, 0], [0, 1]]:
                nr, nc = cr + dr, cc + dc
                if 0 <= nr < N and 0 <= nc < N and visited[nr][nc] == 0:
                    if fishes[nr][nc] <= baby:  # 상어 크기 이하로 이동 가능
                        visited[nr][nc] = visited[cr][cc] + 1
                        que.append((nr, nc))
                        if 0 < fishes[nr][nc] < baby:  # 먹을 수 있는 물고기
                            possible_fish.append((visited[nr][nc] - 1, nr, nc))

        if possible_fish:
            possible_fish.sort()  # 거리, 행, 열 순으로 정렬하여 가장 우선 물고기 선택
            distance, nr, nc = possible_fish[0]
            time += distance  # 이동 시간 추가
            feed += 1
            return nr, nc

        return -1, -1  # 더 이상 먹을 물고기 없음

    while True:
        for i in range(N):
            for j in range(N):
                if fishes[i][j] == 9:  # 상어 위치
                    nr, nc = bfs(i, j)
                    if (nr, nc) == (-1, -1):  # 먹을 물고기 없음
                        return time
                    fishes[i][j] = 0  # 이전 상어 위치 초기화
                    fishes[nr][nc] = 9  # 상어 새로운 위치로 이동
                    if baby == feed:  # 상어 크기 증가 조건
                        baby += 1
                        feed = 0

    return 0

# 입력 처리
N = int(input())
fishes = [list(map(int, input().split())) for _ in range(N)]
print(solve())

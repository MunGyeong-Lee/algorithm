def no_red_green(i, j):
    # 1. 초기셋팅
    stack = [[i, j]]
    visited1[i][j] = 1

    # 2. 구현
    while stack:
        # 현재 위치
        ci, cj = stack.pop(-1)

        # 현재 위치와 인접한 노드 확인하기
        for r, c in [[0, 1], [1, 0], [0, -1], [-1, 0]]:
            ni = ci + r
            nj = cj + c
            # arr 범위 안 노드이고 검사확인 대상 노드와 같은 색이면
            if 0 <= ni < N and 0 <= nj < N and arr[ni][nj] == arr[ci][cj] and visited1[ni][nj] == 0:
                visited1[ni][nj] = 1
                stack.append([ni, nj])


def yes_red_green(i, j):
    # 1. 초기셋팅
    stack = [[i, j]]
    visited2[i][j] = 1

    # 2. 구현
    while stack:
        # 현재 위치
        ci, cj = stack.pop(-1)

        # 현재 위치와 인접한 노드 확인하기
        for r, c in [[0, 1], [1, 0], [0, -1], [-1, 0]]:
            ni = ci + r
            nj = cj + c
            # arr 범위 안 노드여야 한다
            if 0 <= ni < N and 0 <= nj < N and visited2[ni][nj] == 0:
                # 현재 노드가 빨간색 또는 초록색이라면
                if arr[ci][cj] == 'R' or arr[ci][cj] == 'G':
                    if arr[ni][nj] == 'R' or arr[ni][nj] == 'G':
                        stack.append([ni, nj])
                        visited2[ni][nj] = 1
                # 그게 아니면 그냥 현재 노드랑 인접노드가 같은 색이면
                else:
                    if arr[ni][nj] == arr[ci][cj]:
                        stack.append([ni, nj])
                        visited2[ni][nj] = 1


N = int(input())
arr = [list(map(str, input())) for _ in range(N)]

cnt1 = 0
visited1 = [[0] * N for _ in range(N)]
for i in range(N):
    for j in range(N):
        if visited1[i][j] == 0:
            no_red_green(i, j)
            cnt1 += 1  # 새로 발견한 그룹의 수를 증가시킴
print(cnt1)

cnt2 = 0
visited2 = [[0] * N for _ in range(N)]
for i in range(N):
    for j in range(N):
        if visited2[i][j] == 0:
            yes_red_green(i, j)
            cnt2 += 1  # 새로 발견한 그룹의 수를 증가시킴
print(cnt2)

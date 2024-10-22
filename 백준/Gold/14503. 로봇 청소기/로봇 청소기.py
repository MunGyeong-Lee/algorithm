
N, M = map(int, input().split())
sr, sc, dir = map(int, input().split())
room = [list(map(int, input().split())) for _ in range(N)]

# 청소할 때마다 += 1
clear = 0
# 현재칸 : 이동 후 업데이트 해주기
cr = sr
cc = sc
# 4면 확인
dr = [-1, 0, 1, 0]
dc = [0, 1, 0, -1]
direction = {
    # 현재 방향 : [90도 회전, 후진]
    0: [3, 2],
    1: [0, 3],
    2: [1, 0],
    3: [2, 1]

}

while True:
    # 1. 현재 칸: 더럽 >> 현재 칸 청소하기
    if room[cr][cc] == 0:
        room[cr][cc] = 2
        clear += 1
    # 현재 칸 기준 주변 4칸 확인
    flag = True
    for i in range(4):
        nr = cr + dr[i]
        nc = cc + dc[i]

        if 0 <= nr < N and 0 <= nc < M:
            if room[nr][nc] == 0:
                flag = False
                break

    # 2. 현재 칸 기준 주변 4칸 다 깨끗하면
    if flag == True:
        # 후면에 벽이 아닌 경우 >>  후진 == 현재칸 업데이트 >> 1번으로 돌아가기
        if room[cr+dr[direction[dir][1]]][cc+dc[direction[dir][1]]] == 1:
            break

        # 후면이 벽인 경우 >> 작동 멈추기 break
        else:
            cr += dr[direction[dir][1]]
            cc += dc[direction[dir][1]]


    # 3. 현재 칸 기준 주변 4칸 중 더러운 곳 있으면
    else:
        # dir 반 90 도 회전/ 방향 업데이트
        dir = direction[dir][0]
        # dir 에 해당하는 room 확인 >>
        if room[cr+dr[dir]][cc+dc[dir]] == 0:
            cr += dr[dir]
            cc += dc[dir]

        # 안 더러우면 >> 다시 90도 회전

print(clear)
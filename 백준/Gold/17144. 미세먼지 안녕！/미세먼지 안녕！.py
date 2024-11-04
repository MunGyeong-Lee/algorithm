import sys

def fine_dust():
    room_2 = [[0]*C for _ in range(R)]
    for i in range(R):
        for j in range(C):
            # 방에 미세먼지가 있으면
            if room[i][j] >= 4:
                # 확산된 먼지 수/ 먼지 있는 칸 수
                dust = room[i][j] // 5
                near_count = 0
                # 인접한 4방향 확인한다
                for dr, dc in [[0,1],[1,0],[0,-1],[-1,0]]:
                    nr = dr+ i
                    nc= dc + j
                    # 인접 방향이 배열안에 있음/ -1(로봇)보다 커야함
                    # 인접 먼지 확산
                    if 0<= nr < R and 0<= nc < C and room[nr][nc] > -1:
                        room_2[nr][nc] += dust
                        near_count += 1
                # 현재 위치 미세먼지 수 조정
                room_2[i][j] += room[i][j]-(dust*near_count)
            else:
                room_2[i][j] += room[i][j]

    return room_2

def run_machine():
    #위쪽 바람
    cr = airmachine_r - 2
    cc = airmachine_c

    while cr > 0:
        room[cr][cc] = room[cr-1][cc]
        cr -= 1

    if cr == 0:
        while cc < C-1:
            room[cr][cc] = room[cr][cc+1]
            cc += 1

    if cc == C-1:
        while cr < airmachine_r-1:
            room[cr][cc] = room[cr+1][cc]
            cr += 1

    if cr == airmachine_r-1:
        while cc > 1:
            room[cr][cc] = room[cr][cc-1]
            cc-=1

    if cc == 1:
        room[cr][cc] =0

    # 아래쪽 바람
    cr = airmachine_r + 1
    cc = airmachine_c

    while cr < R-1:
        room[cr][cc] = room[cr+1][cc]
        cr += 1

    if cr == R-1:
        while cc < C-1:
            room[cr][cc]=room[cr][cc+1]
            cc+=1

    if cc == C-1:
        while cr > airmachine_r:
            room[cr][cc] = room[cr-1][cc]
            cr -= 1

    if cr == airmachine_r:
        while cc > 1:
            room[cr][cc] = room[cr][cc-1]
            cc -= 1

    if cc == 1:
        room[cr][cc]=0





R,C,T = map(int,sys.stdin.readline().split())
room = [list(map(int,sys.stdin.readline().split())) for _ in range(R)]
# 로봇청소기 위치
airmachine_r= 0
airmachine_c= 0
# 공기청정기 위치 찾기
for r in range(R):
    for c in range(C):
        if room[r][c] == -1:
            airmachine_r= r

time = 0
while T > time:
    # 미세먼지 확산
    room = fine_dust()

    # 공기청정기 가동
    run_machine()

    time += 1
total =0
# print(room)
for i in range(R):
    total+=sum(room[i])
print(total+2)
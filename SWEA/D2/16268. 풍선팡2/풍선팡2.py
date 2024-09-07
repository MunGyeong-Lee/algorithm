T = int(input())
for tc in range(1,T+1):
    N,M = map(int,input().split())
    arr = [list(map(int,input().split())) for _ in range(N)]
    result = 0

    # 좌표 선택
    for i in range(N):
        for j in range(M):
            sub_sum = arr[i][j]
            for r, c in [[0,1],[1,0],[0,-1],[-1,0]]:
                dr = i + r
                dc = j + c
                if 0<= dr< N and 0<= dc< M:
                    sub_sum += arr[dr][dc]
            result= max(sub_sum, result)
    print(f'#{tc} {result}')
def dfs(i,j):
    v_cnt = 0
    # 1. 초기셋팅
    stack = [[i,j]]
    visited[i][j] =1
    # 2. 구현
    while stack:
        ci,cj= stack[-1]  # 현재 위치
        # 현재 위치에서 상하좌우로 인접한 정접 확인
        for r,c in [0,1],[1,0],[0,-1],[-1,0]:
            dr = ci+r
            dc = cj + c
            # 현재 위치와 인접한 정점 배열안에 있고 1이고 방문한적 없어야함
            if 0<= dr < N and 0<= dc < N and arr[dr][dc] == 1 and visited[dr][dc] == 0:
                stack.append([dr,dc])
                visited[dr][dc] = 1
                v_cnt += 1
                break # for문 중단 다음 current 찾기
        else:
            stack.pop()
    return v_cnt+1

N = int(input())
arr = [list(map(int,input())) for _ in range(N)]
visited =[[0]*N for _ in range(N)] # 0: 방문안한 1: 방문함
result = []
cnt =0
for i in range(N):
    for j in range(N):
        if arr[i][j] == 1 and visited[i][j] == 0:
            result.append(dfs(i,j))
            cnt+=1
print(cnt)
for final in sorted(result):
    print(final)


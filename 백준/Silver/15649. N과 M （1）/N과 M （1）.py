
def solve(index,arr):

    # 1. 기저조건 index == M : M의 자리까지 숫자가 모여야함
    if index == M:
        result.append(arr)
        return
    # 2. 구현
    # 1부터 N까지 반복문 돌면서 방문 안한 숫자를 추가하고 재귀 돌기
    for i in range(N):
        if not visited[i+1]:
            visited[i+1] = 1
            solve(index+1,arr+[i+1])
            # 끝까지 다 돌고 나오면 직전에 방문했던 표시는 삭제
            visited[i+1]=0

N, M = map(int,input().split())
visited = [0] * (N+1)

result = []
solve(0,[])
for final in result:
    print(*final)
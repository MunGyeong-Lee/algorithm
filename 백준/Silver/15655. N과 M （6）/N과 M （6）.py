def solve(index,arr):
    # 기저조건
    if index == M:
        result.append(arr)
        return

    # 구현
    for i in range(N):
        # 배열을 첫번째 순이면 넣기
        if len(arr)==0:
            #visited 표시하고 재귀 돌리기
            visited[i]=1
            solve(index+1,[numbers[i]])
        # 배열의 첫번째 순이 아니면, 자기 앞으 숫자보다 커야함
        if len(arr) > 0 and arr[-1]< numbers[i]:
            # visited 표시하고 재귀돌리기
            visited[i] = 1
            solve(index + 1, arr + [numbers[i]])

        # visited 원복
        visited[i]=0


N, M = map(int,input().split())
numbers= list(map(int,input().split()))
numbers.sort()
visited=[0]*N
result = []
solve(0,[])
for final in result:
    print(*final)
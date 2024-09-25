def solve(index,arr):

    #1. 기저조건: index ==M
    if index == M:
        result.append(arr)

        return
    # 2. 구현
    for i in range(1,N+1):
        # arr 배열에 첫번째로 들어가고,
        if len(arr)==0 and visited[i]==0:
            # 방문하지 않은 숫자라면 바로 추가
            visited[i]=1
            solve(index+1,arr+[i])
        # arr 배열에 첫번째가 아니고, 현재 arr의 마지막 숫자보다 작고, 방문한적 없으면
        if len(arr)>0 and arr[index-1] < i and visited[i]==0:
            # 추가 하고 재귀 돌기

            visited[i]=1
            solve(index+1,arr+[i])
        # 재귀 나와서 visited 취소하기
        visited[i]=0




N, M = map(int,input().split())
visited =[0]*(N+1)
result = []

solve(0,[])
for i in result:
    print(*i)

def solve(index, arr):
    # 기저 조건 index==M
    if index==M:
        result.append(arr)
        return
    # 구현
    for i in range(1,N+1):
        # 맨 첫번째 자리에 넣는 경우에는 그냥 넣고 재귀
        if len(arr) == 0:
            solve(index+1, arr+[i])
        # 맨 처음이 아니라면 arr 마지막 숫자랑 (=arr[index-1])랑 현재 숫자랑 비교해서 i가 더 크면 넣고 재귀
        else:
            if arr[index-1] <= i:
                solve(index + 1, arr + [i])


N,M = map(int,input().split())
result = []
solve(0,[])
for final in result:
    print(*final)
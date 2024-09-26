
def solve(index,arr):
    # 기저조건  index == M
    if index == M:
        result.append(arr)
        return
    #구현
    # 숫자선택
    for i in range(1,N+1):
        # arr에 추가해서 재귀 보내기
        solve(index+1, arr+[i])



N, M = map(int,input().split())
result=[]
solve(0,[])
for final in result:
    print(*final)
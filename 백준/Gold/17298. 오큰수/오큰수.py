
N = int(input())
nums = list(map(int,input().split()))

stack =[]
result = []

for i in range(N-1,-1,-1):
    num = nums[i]
    # 현재 스택에 아무것도 없으면 result에 -1을 넣는다
    if len(stack) == 0:
        result.append(-1)
        stack.append(num)

    else:
        # 스택의 꼭대기와 현재 수를 비교 >> 언제까지?: 스택 꼭대기가 더 클때까지== 스택 꼭대기가 작으면 계속돌려
        # 만약 스택 꼭대기가 더 크면 >> result에 꼭대기 수 넣기 >> stack에 현재 수 넣기

        while stack[-1] <= num:
            stack.pop()
            if not stack:
                break

        if len(stack) == 0:
            result.append(-1)
            stack.append(num)
        else:
            result.append(stack[-1])
            stack.append(num)
result.reverse()
print(*result)

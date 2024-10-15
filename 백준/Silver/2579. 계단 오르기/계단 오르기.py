
def solve(index):
    if index == 0:
        return step[0]
    elif index == 1:
        return step[0] + step[1]
    elif index == 2:
        return max(step[2] + step[1], step[2] + step[0])

    if dp[index] != -1:
        return dp[index]

    dp[index] = max(step[index]+step[index-1]+solve(index-3), step[index]+solve(index-2))
    return dp[index]

N = int(input())
dp = [-1]*(N)
step = [int(input()) for _ in range(N)]
print(solve(N-1))

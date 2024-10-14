
T = int(input())
for _ in range(T):
    def solve(index):

        if index == 0:
            return 1

        if index < 0 :
            return 0

        if dp[index] != -1:
            return dp[index]

        dp[index] = solve(index-1) +solve(index-2)+solve(index-3) # solve(3) solve(2) solve(1)
        return dp[index]

    N = int(input())
    dp = [-1]*(N+1)
    print(solve(N))

N = int(input())
dp=[0]*N
for i in range(N):
    if i == 0:
        dp[i]=1
        continue
    if i == 1:
        dp[i]=2
        continue
    dp[i] = dp[i - 1] + dp[i - 2]

print(dp[N-1]%10007)

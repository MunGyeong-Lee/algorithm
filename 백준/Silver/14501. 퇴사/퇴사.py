N = int(input())
time=[]
pay=[]
dp=[0]*(N+1)
for _ in range(N):
    t, p = map(int,input().split())
    time.append(t)
    pay.append(p)

for i in range(N):

    dp[i + 1] = max(dp[i + 1], dp[i])

    a= i + time[i]
    if a < N+1 :
        dp[a] = max(dp[a], dp[i]+pay[i])

print(max(dp))
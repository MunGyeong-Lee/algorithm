N = int(input())
arr = [list(map(int, input().split())) for _ in range(N)]
dp = [[0] * 3 for _ in range(N)]

# 첫 번째 집의 비용은 그대로 설정
dp[0][0] = arr[0][0]
dp[0][1] = arr[0][1]
dp[0][2] = arr[0][2]

# 두 번째 집부터는 인접한 집과 다른 색을 선택하는 방식으로 비용을 계산
for i in range(1, N):
    dp[i][0] = min(dp[i-1][1], dp[i-1][2]) + arr[i][0]  # 빨강으로 칠할 경우
    dp[i][1] = min(dp[i-1][0], dp[i-1][2]) + arr[i][1]  # 초록으로 칠할 경우
    dp[i][2] = min(dp[i-1][0], dp[i-1][1]) + arr[i][2]  # 파랑으로 칠할 경우

# 마지막 집까지 칠한 후 최소 비용 출력
result = min(dp[N-1][0], dp[N-1][1], dp[N-1][2])
print(result)
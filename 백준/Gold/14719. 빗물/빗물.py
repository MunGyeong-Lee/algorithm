H, W = map(int, input().split())
buildings = list(map(int, input().split()))

result = 0

for i in range(1, W - 1):  # 양 끝은 물이 고일 수 없으므로 1부터 W-2까지 반복
    left_max = max(buildings[:i])  # 현재 열의 왼쪽에서 가장 높은 건물
    right_max = max(buildings[i + 1:])  # 현재 열의 오른쪽에서 가장 높은 건물

    # 현재 열에 고일 수 있는 물의 높이
    water_height = min(left_max, right_max)

    if water_height > buildings[i]:  # 물이 고일 수 있는 경우
        result += water_height - buildings[i]

print(result)
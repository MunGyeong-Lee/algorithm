import sys
from itertools import combinations

def simulate_turn(copy_enemy, targets):
    """
    적 제거 및 이동 처리
    """
    cnt = 0
    # 적 제거
    for r, c in targets:
        if copy_enemy[r][c] == 1:  # 이미 제거된 적이 아닐 때
            copy_enemy[r][c] = 0
            cnt += 1

    # 적 이동: 맨 아래 행 제거
    copy_enemy.pop()
    copy_enemy.insert(0, [0] * M)  # 새로운 행 추가

    return cnt

def select_targets(archer, enemy_positions, D, copy_enemy):
    """
    각 궁수의 타겟을 선택
    """
    targets = set()
    for archer_col in archer:
        closest_enemy = None
        min_distance = D + 1

        for enemy_row, enemy_col in enemy_positions:
            distance = abs(N - enemy_row) + abs(archer_col - enemy_col)

            # 타겟 선정 기준
            if distance <= D:
                if distance < min_distance or (distance == min_distance and enemy_col < closest_enemy[1]):
                    closest_enemy = (enemy_row, enemy_col)
                    min_distance = distance

        if closest_enemy:
            targets.add(closest_enemy)

    # 적 제거 및 이동
    return simulate_turn(copy_enemy, targets)

def calculate_max_kills():
    """
    궁수 배치 조합별 최대 제거 수 계산
    """
    global result
    for archers in comb:
        # 적 배열 복사
        copy_enemy = [row[:] for row in enemy]
        total_kills = 0

        while any(1 in row for row in copy_enemy):  # 적이 남아 있는 동안 반복
            # 현재 적 위치 가져오기
            enemy_positions = [
                (i, j) for i in range(len(copy_enemy)) for j in range(M) if copy_enemy[i][j] == 1
            ]
            # 타겟 선택 및 적 제거
            total_kills += select_targets(archers, enemy_positions, D, copy_enemy)

        result = max(result, total_kills)

# 입력
N, M, D = map(int, input().split())
enemy = [list(map(int, input().split())) for _ in range(N)]

# 궁수 조합 생성
comb = list(combinations(range(M), 3))

# 최대 제거 수 계산
result = 0
calculate_max_kills()

# 결과 출력
print(result)

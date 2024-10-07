def hanoi(n, start, end, aux):
    if n == 1:
        print(f"{start + 1} {end + 1}")
        stack[end].append(stack[start].pop())
        return

    # n-1개의 판을 시작 기둥에서 보조 기둥으로 이동
    hanoi(n - 1, start, aux, end)

    # n번째 판을 시작 기둥에서 목표 기둥으로 이동
    print(f"{start + 1} {end + 1}")
    stack[end].append(stack[start].pop())

    # 나머지 n-1개의 판을 보조 기둥에서 목표 기둥으로 이동
    hanoi(n - 1, aux, end, start)


N = int(input())
stack = [[] for _ in range(3)]

# 초기 상태로 첫 번째 기둥에 모든 판을 쌓음
for i in range(N, 0, -1):
    stack[0].append(i)

# 전체 이동 횟수 계산
total_moves = 2**N - 1
print(f"{total_moves}")

# 하노이의 탑 문제 해결 및 이동 과정 출력
hanoi(N, 0, 2, 1)

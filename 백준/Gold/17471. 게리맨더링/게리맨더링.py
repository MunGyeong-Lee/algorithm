import sys
from itertools import combinations

def dfs(section):
    start = section[0]
    visited = [False] * (N + 1)
    visited[start] = True
    stack = [start]

    # DFS로 연결 여부 확인
    while stack:
        v = stack.pop()
        for w in arr[v]:
            if w in section and not visited[w]:
                visited[w] = True
                stack.append(w)

    # section의 모든 노드가 방문되었는지 확인
    return all(visited[node] for node in section)

def find_min_population_difference():
    min_result = float('inf')
    all_people = set(range(1, N + 1))

    # 1부터 N//2 까지만 조합 생성 (절반 이상 조합은 중복)
    for r in range(1, N // 2 + 1):
        for comb in combinations(range(1, N + 1), r):
            section_1 = list(comb)
            section_2 = list(all_people - set(section_1))

            # 두 섹션이 모두 연결되어 있는지 확인
            if dfs(section_1) and dfs(section_2):
                sum_1 = sum(people[i - 1] for i in section_1)
                sum_2 = sum(people[i - 1] for i in section_2)
                min_result = min(min_result, abs(sum_1 - sum_2))

    return min_result if min_result != float('inf') else -1

# 입력 처리
N = int(sys.stdin.readline())
people = list(map(int, sys.stdin.readline().split()))
arr = [[] for _ in range(N + 1)]
for i in range(1, N + 1):
    lst = list(map(int, sys.stdin.readline().split()))
    arr[i].extend(lst[1:])

# 최소 인구 차이 구하기
print(find_min_population_difference())

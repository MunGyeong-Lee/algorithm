from heapq import heappop, heappush

def prim():
    # 초기화
    pq = []  # 가중치, 노드
    U = set() # 방문여부 확인
    sub_sum = 0 # 최소합 결과

    heappush(pq,(0,1))

    # 최소합 구하기
    while pq:
        w, c_node = heappop(pq)

        if c_node in U:
            continue

        # 방문안한 노드면 방문표시
        U.add(c_node)

        # 최소합에 더해주기
        sub_sum += w

        # 갈 수 있는 노드들 확인
        for i in range(1, N+1):
            # c_node와 인접하고, 방문한적이 있는지
            if graph[c_node][i] !=0 and i not in U:
                heappush(pq,(graph[c_node][i], i))
    return sub_sum

N = int(input())
M = int(input())

graph = [[0]*(N+1) for _ in range(N+1)]
for _ in range(M):
    a, b, c = map(int,input().split())
    graph[a][b] = c
    graph[b][a] = c
print(prim())
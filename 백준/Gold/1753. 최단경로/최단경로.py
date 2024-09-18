from heapq import heappop, heappush

INF =int(1e9)
def dij(start):
    pq = []
    distance = [INF]*(V+1)
    distance[start] = 0
    heappush(pq,(0,start)) # 가중치, start 위치

    while pq:
        dist, c_node = heappop(pq)
        # 이미 검사한 곳인지 확인
        if dist > distance[c_node]:
            continue

        # c_node와 인접한 노드 확인
        for data in graph[c_node]:
            new_dist = data[0]
            new_node = data[1]
            if distance[new_node] > dist +new_dist:
                distance[new_node] = dist + new_dist
                heappush(pq,(dist + new_dist, new_node))

    return distance

V, E = map(int,input().split())
start = int(input())

graph = [[]for _ in range(V+1)]
for _ in range(E):
    u, v, w = map(int,input().split())
    graph[u].append([w, v])

final = dij(start)
for i in final[1:]:
    if i == INF:
        print("INF")
    else:
        print(i)

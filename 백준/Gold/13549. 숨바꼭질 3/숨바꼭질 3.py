
from collections import deque
def dij(start):
    # 셋팅
    deque_pq= deque()
    deque_pq.append((0,start))
    distance[start]= 0

    # 구현
    while deque_pq:
        time, current= deque_pq.popleft()

        if current == K:
            return time

        # 방문 여부 확인
        if distance[current] < time:
            continue
        # 인접 노드 확인
        for new_node, new_time in [(current*2, time), (current+1, time+1), (current-1, time+1)]:

            if 0<= new_node < len(distance):
                if distance[new_node] > new_time :
                    distance[new_node] = new_time
                    if new_time == time:
                        deque_pq.appendleft((new_time, new_node))
                    else:
                        deque_pq.append((new_time, new_node))


N, K = map(int,input().split())
#  distance 만들기
distance=[0xffffff] * 100001
print(dij(N))

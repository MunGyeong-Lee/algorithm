import sys
from collections import deque
N, M = map(int,sys.stdin.readline().split())

que = deque()
result = []
for i in range(1,N+1):
    que.append(i)
while que:
    for i in range(M):
        if i < M-1:
            que.append(que.popleft())
        else:
            result.append(str(que.popleft()))

print("<"+', '.join(result)+">")
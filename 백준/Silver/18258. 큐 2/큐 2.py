
import sys
from collections import deque
N = int(sys.stdin.readline())
que = deque()
for _ in range(N):
    order = sys.stdin.readline().strip()
    if "push" in order :
        a, b = order.split()
        que.append(b)
    if order == "pop":
        if len(que) > 0:
            print(que.popleft())
        else:
            print(-1)
    if order == "size":
        print(len(que))

    if order == "empty":
        if len(que) > 0:
            print(0)
        else:
            print(1)
    if order == "front":
        if len(que) > 0:
            print(que[0])
        else:
            print(-1)

    if order == "back":
        if len(que) > 0:
            print(que[-1])
        else:
            print(-1)



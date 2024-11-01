import sys
from collections import deque

N = int(sys.stdin.readline().strip())
que = deque()

for _ in range(N):
    order = sys.stdin.readline().strip()
    
    if "push" in order:
        _, b = order.split()
        que.append(b)
        
    elif order == "pop":
        if len(que) > 0:
            print(que.popleft())
        else:
            print(-1)
            
    elif order == "size":
        print(len(que))
        
    elif order == "empty":
        if len(que) > 0:
            print(0)
        else:
            print(1)
            
    elif order == "front":
        if len(que) > 0:
            print(que[0])
        else:
            print(-1)
            
    elif order == "back":
        if len(que) > 0:
            print(que[-1])
        else:
            print(-1)
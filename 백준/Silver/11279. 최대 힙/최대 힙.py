import sys

from heapq import heappop,heappush

N = int(sys.stdin.readline())
arr = []
for _ in range(N):
    X = int(sys.stdin.readline())
    if X > 0:
        heappush(arr, -X)

    else:
        if len(arr) < 1:
            print(0)
        else:
            print(-heappop(arr))
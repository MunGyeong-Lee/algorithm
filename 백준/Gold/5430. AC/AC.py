import sys
from collections import deque

input = sys.stdin.readline
T = int(input())
for _ in range(T):
    fx = input().strip()
    N = int(input())
    before_arr = input().strip()
    arr = deque(before_arr[1:-1].split(','))  # 배열 생성
    flag = 1

    if N == 0:
        arr = deque()

    R_cnt = 0
    for i in fx:
        if i == 'R':
            R_cnt+=1
        else:
            if len(arr) > 0:
                if R_cnt % 2 == 0:
                    arr.popleft()
                else:
                    arr.pop()
            else:
                flag = 0
                print('error')
                break
    if flag == 0:
        continue
    else:
        if R_cnt % 2 ==0:
            print('[' + ",".join(arr) + ']')
        else:
            arr.reverse()
            print('[' + ",".join(arr) + ']')




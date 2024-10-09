from collections import deque

N = int(input())
cards = deque([])
for i in range(1,N+1):
    cards.append(i)
cnt = 0  # 작업수행 횟수

while len(cards) > 1:
    if cnt % 2 == 0:
        cards.popleft()
    else:
        card = cards.popleft()
        cards.append(card)
    # 작업 수행 횟수 1 증가
    cnt += 1


for result in cards:
    print(result)
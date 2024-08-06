
N, price = map(int, input().split())
cnt = 0

#동전리스트 만들기
coin_list = []
for i in range (N):
    coin = int(input())
    coin_list.append(coin)

# 특정 금액 보다 작은 동전리스트 만들기 함수
def min_coin(coin_list, price):
    min_coin_list = []
    for i in range(len(coin_list)):
        if price >= coin_list[i]:
            min_coin_list.append(coin_list[i])

    return min_coin_list

# 동전으로 금액 맞추기

while True:
    # global price

    min_coin_list = min_coin(coin_list, price)
    cnt += price//max(min_coin_list)


    if price % max(min_coin_list) != 0:
        price = price % max(min_coin_list)

    else:
        break

print(cnt)
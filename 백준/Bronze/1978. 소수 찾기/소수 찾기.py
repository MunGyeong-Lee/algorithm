num = int(input())
number_list = list(map(int, input().split()))

check_list = []
for index in range(num):
    number = number_list[index]

    if number > 2 :
        a = int(number ** (1 / 2))
        for i in range(2, a+1) :
            if number % i == 0 : # 약수야
                check_list.append(number)
                break
            else :
                continue

    elif number == 2:
        continue
    else:
        check_list.append(number)

result = (list(set(number_list).difference(set(check_list))))
print(len(result))

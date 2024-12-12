exp = str(input())

# split함수 사용
result = 0
a = exp.split('-')
# print(a)
if len(a) >= 2:
    for i in range(len(a)):
        if i == 0:
            if len(a[i].split('+')) >= 2:
                sum_1 = 0
                for j in a[i].split('+'):
                    sum_1 += int(j)
                result += sum_1
            else:
                result += int(a[i])
        else:
            if len(a[i].split('+')) >= 2:
                sum_1 = 0
                for j in a[i].split('+'):
                    sum_1 += int(j)
                result -= sum_1
            else:
                result -= int(a[i])

else:
    b = exp.split('+')
    # print(b)
    for i in b:
        result += int(i)

print(result)
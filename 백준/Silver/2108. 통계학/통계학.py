
N = int(input())
num = [int(input()) for _ in range(N)]
num.sort()  # [-3, -2, -2, -1, -1]

#산술 평균
print(round(sum(num)/N))

# 중앙값
print(num[N//2])


# 최빈값
dic={}
for i in num:
    if i in dic :
        dic[i] +=1
    else:
        dic[i] = 1

max_fre = max(dic.values())
max_fre_lst =[]
for i in dic:
    if max_fre == dic[i]:
        max_fre_lst.append(i)

if len(max_fre_lst) > 1:
    print(max_fre_lst[1])
else:
    print(max_fre_lst[0])

# 범위
print(max(num) - min(num))
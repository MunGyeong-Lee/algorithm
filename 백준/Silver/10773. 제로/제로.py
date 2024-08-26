N= int(input())
num_lst = []
for _ in range(N):
    num = int(input())
    if num != 0:
        num_lst.append(num)
    else:
        num_lst.pop()

print(sum(num_lst))
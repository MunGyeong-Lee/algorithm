
num_list = []

num_1 =num_list.append(int(input()))
num_2 =num_list.append(int(input()))
num_3 =num_list.append(int(input()))
num_4 =num_list.append(int(input()))
num_5 =num_list.append(int(input()))
num_6 =num_list.append(int(input()))
num_7 =num_list.append(int(input()))
num_8 =num_list.append(int(input()))
num_9 =num_list.append(int(input()))

a = max(num_list)
print(a)

for i in range(len(num_list)):
    if num_list[i] == a :
        j = i +1
        print(j)



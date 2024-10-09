
N = int(input())
N_list = [i for i in range(1, N+1)]
arr=[int(input()) for _ in range(N)]
stack = [] # 1 2 3
index = 0 # 1
result = [] # + + + + -
flag = True
for N_number in N_list:
    if len(stack) == 0:
        stack.append(N_number)
        result.append('+')
    else:
        while len(stack) > 0 and stack[-1] == arr[index]:
            index += 1
            stack.pop()
            result.append('-')
        stack.append(N_number)
        result.append('+')


while stack:
    if stack[-1] == arr[index]:
        index += 1
        stack.pop()
        result.append('-')
    else:
        print('NO')
        flag = False
        break

if flag == True:
    for i in result:
        print(i)
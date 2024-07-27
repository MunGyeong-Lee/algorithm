
while True :
    num_list = list(map(int,input().split()))


    if num_list == [0, 0, 0]:
        break
    else:
        num_list.sort()
        if num_list[0]**2+num_list[1]**2 == num_list[2]**2:
            print('right')
        else :
            print('wrong')


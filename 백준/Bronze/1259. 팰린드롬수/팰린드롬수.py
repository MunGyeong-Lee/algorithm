
while True :
    number = input()
    if number == '0':
        break
    elif  number == number[::-1]:
        print('yes')
    else :
        print('no')



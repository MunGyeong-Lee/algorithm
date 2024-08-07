T = int(input())
for tc in range(1, T+1):

    text = input()

    stack = []
    result = 'YES'
    for i in range(len(text)):
        if text[i] == '(':
            stack.append(text[i])

        else:
            if len(stack) > 0:
                poped = stack.pop()
                result = 'YES'
            else:
                result = 'NO'
                break


    if len(stack) > 0:
        result = 'NO'

    print(result)
numbers = list(map(int,input().split()))

up = numbers[0]
down = numbers[1]
length = numbers[2]

turn = ((length-down)+(up-down)-1)//(up-down)
print(turn)
N = int(input())
light = list(map(int,input().split()))
number = int(input())


for _ in range(number):
    student, switch = map(int,input().split())
    if student == 1:
        for i in range(switch-1, N, switch):
            light[i] = 1 -light[i]

    else:
        s = switch - 1
        light[s] = 1-light[s]
        i = 1
        while s-i >= 0 and s+i < N and light[s-i] == light[s+i]:
            light[s-i] = 1 - light[s-i]
            light[s+i] = 1 - light[s+i]
            i += 1

for i in range(0, N ,20):
    print(*light[i:i+20])
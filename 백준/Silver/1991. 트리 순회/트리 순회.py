import sys

input = sys.stdin.readline

def solve1(node):
    if node == '.':
        return
    print(node, end ='')
    solve1(dict_tree[node][0])
    solve1(dict_tree[node][1])

def solve2(node):
    if node == '.':
        return

    solve2(dict_tree[node][0])
    print(node, end='')
    solve2(dict_tree[node][1])

def solve3(node):
    if node == '.':
        return

    solve3(dict_tree[node][0])
    solve3(dict_tree[node][1])
    print(node, end='')

N = int(input())
dict_tree = {}
for index in range(N):
    a,b,c = map(str,input().split())
    dict_tree[a] =[b,c]
# print(dict_tree)
solve1('A')
print()
solve2('A')
print()
solve3('A')
# print(dict_tree['A'][0])
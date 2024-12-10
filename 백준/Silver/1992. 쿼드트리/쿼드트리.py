

def conquer(n, arr_test):
    # 1. 네모 한 칸이 0또는 1로만 되어있는 경우
    flag = 0
    for row in arr_test:
        flag += sum(row)

    if flag == 0:
        return '0'
    if flag == n**2:
        return '1'

    # 2. 아님 >>> ( 출력  >>> 4 칸으로 나누기
    next = n//2
    result = '('
    # 좌상
    result += conquer(next, [r[:next]for r in arr_test[:next]])
    # 우상
    result += conquer(next, [r[next:] for r in arr_test[:next]])
    # 좌하
    result += conquer(next, [r[:next] for r in arr_test[next:]])
    # 우하
    result += conquer(next, [r[next:] for r in arr_test[next:]])

    #3. 분할된 칸 다 둘러봄 >>> ) 출력
    result += ')'
    return result

N = int(input())
arr = [list(map(int, input())) for _ in range(N)]


print(conquer(N, arr))

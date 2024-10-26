
N = int(input())
cards = list(map(int,input().split()))
M = int(input())
numbers = list(map(int,input().split()))
result = []
# cards 배열 정렬하기
cards.sort()

def binary_search(target):
    flag = 0  # flag = 1: 값 찾음 / flag = 0 : 값 못찾음
    # 구간의 시작 인데스, 끝 인덱스
    start = 0
    end = N-1
    # 1. 중앙 요소 선택하기
    center = (end+start)//2
    while True:

    # 2. 중앙 요소 vs target 비교
        # 값 못찾은 경우: start > end
        if start > end:
        # while문 종료
            break

        # 중앙 요소 > target
        # >>> 왼쪽 구간 탐색
        if cards[center] > target:
            # end 인덱스 변경 = 중앙요소 인덱스 -1
            # center 값 변경
            end = center-1
            center = (end + start) // 2

        #center = (end+start)//2


        # 중앙 요소 < target
        # >>> 오른쪽 구간 탐색
        if cards[center] < target:
            # start = 중앙요소 인덱스 + 1
            # center 값 변경
            start = center+1
            center = (end + start) // 2


        # 중앙 요소 = target
        if cards[center] == target:
            # flag 1로 변경
            # while문 종료
            flag = 1
            break
    return flag

for target in numbers:
    result.append(binary_search(target))

print(*result)
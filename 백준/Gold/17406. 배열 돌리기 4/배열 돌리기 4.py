import sys
from itertools import permutations


def apply_rotation(board, r, c, s):
    N, M = len(board), len(board[0])
    
    for k in range(1, s+1):
        top, left = r-k, c-k
        bottom, right = r+k, c+k
        
        # 왼쪽 윗 부분 저장
        temp = board[top][left]
        
        # 왼쪽 열 위로 이동
        for i in range(top, bottom):
            board[i][left] = board[i+1][left]
        
        # 아래쪽 행 왼쪽으로 이동    
        for i in range(left, right):
            board[bottom][i] = board[bottom][i+1]
        
        # 오른쪽 열 아래로 이동
        for i in range(bottom, top, -1):
            board[i][right] = board[i-1][right]
        
        # 위쪽 행 오른쪽으로 이동
        for i in range(right, left, -1):
            board[top][i] = board[top][i-1]
        
        board[top][left+1] = temp

def solve():
    N, M, K = map(int, sys.stdin.readline().split())
    board = [list(map(int, sys.stdin.readline().split())) for _ in range(N)]
    rotations = [list(map(int, sys.stdin.readline().split())) for _ in range(K)]
    
    min_sum = float('inf')
    
    # 회전 순서 경우의 수 생성
    for order in permutations(rotations, K):
        temp_board = [row[:] for row in board]
        
        # 회전 연산 수행
        for r, c, s in order:
            apply_rotation(temp_board, r-1, c-1, s)
        
        # 각 행의 합 중 최소값 찾기
        min_row_sum = min(sum(row) for row in temp_board)
        min_sum = min(min_sum, min_row_sum)
    
    return min_sum

print(solve())
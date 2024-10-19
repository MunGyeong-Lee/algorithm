T = int(input())
for tc in range(1,T+1):
    N = int(input())
    arr = list(map(int,input().split()))
# 팀별 인원 수 구하기
    count_m = [0]*(max(arr)+1)   #[0, 6, 2, 6, 1]
    for i in range(N):
        count_m[arr[i]] += 1
    # print(count_m)

# 6명 안되는 no_team리스트 만들기
    no_team = []
    for i in range(1,len(count_m)):
        if count_m[i] < 6:
            no_team.append(count_m[i])
    # print(no_team)
# 우승 후보팀 딕셔너리
    pre_win ={}
# 점수
    grade = 0

# 탐색하기
    for i in arr: #  1. 6명되는 팀인가
            if count_m[i] == 6:          # 우승 후보팀 딕셔너리에 팀이 추가되어있나?
                grade += 1               # 우승 후보 팀일 경우에만 점수 1점 올리기
                if i in pre_win:         # 이미 딕셔너리에 추가되 팀
                    if pre_win[i][0] < 4:       # 아직 4명 합산 안구했나?  != 이거 아니고 < 이거임
                        pre_win[i][0]  += 1        # 1명 추가하고
                        pre_win[i][1] += grade     # 점수도 추가

                    elif pre_win[i][0] == 4 :                       # 4명 합산 다했다
                         pre_win[i][0]  += 1     # cnt +1 5명까지 추가
                         pre_win[i][2] += grade  # 마지막 자리에는 5번 주자의 점수 입력

                else:  # 추가 안됐으면
                    pre_win[i] = [1, grade, 0]     # K: 팀번호 = V: 팀당 합산한 선수 수, 상위 4명 점수 합, 5번 주자 점수
# 순위를 정렬
#상위 4명점수의 합을 기준 오름차순 정렬하고 같으면 5번 주자 점수 별로 나열하라
    result = sorted(pre_win.items(),key=lambda x:(x[1][1], x[1][2]))
    # print(result)
    winner = result[0][0]
    print(winner)
n, m = map(int,input().split()) #[10, 500]#
card_numbers = list(map(int,input().split())) #[93, 181, 245, 214, 315, 36, 185, 138 ,216, 295] #


card_list= []
for fist in range(len(card_numbers)-2):
    for second in range(fist+1,len(card_numbers)-1): #마지막 수는 들어가지 않는다
        for third in range(second+1,len(card_numbers)):
            card_list.append([card_numbers[fist], card_numbers[second],card_numbers[third]])


similar_result = 0
for combination  in card_list:
    result = sum(combination)

    #목표값보다 작거나 같은 최대 합계를 찾는다
    if result <= m and result > similar_result:
        similar_result = result


print(similar_result)

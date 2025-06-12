import java.util.*;

class Solution {
    public int[] solution(int[] prices) {

        int[] answer = new int[prices.length];

        Stack<Integer>stackIndex = new Stack<>();

        for(int i = 0 ; i < prices.length ; i++){
            // 스택이 비어있는지 먼저 체크 -> 가격비교
            while(!stackIndex.isEmpty()&& prices[i] < prices[stackIndex.peek()]){
                    int popedIndex = stackIndex.pop();
                    answer[popedIndex] = i - popedIndex;
            }
            stackIndex.push(i); // 항상 현재 인덱스 추가

        }

        //스택에 있는 것들 처리
        while (!stackIndex.isEmpty()){
            int remainIndex = stackIndex.pop();
            answer[remainIndex] = prices.length-1-remainIndex;
        }

        return answer;
    }
}
import java.util.*;
class Solution {
    public int solution(int[] scoville, int K) {

        // 우선순위 큐
        // 반복문: 우선순위 큐 배열이 빌때까지
        // 첫번째거를 빼서  k 보다 작은지 확인
        // k보다 크면 while문 멈추기
        // k보다 작으면 두번째거도 빼서 둘이 계산하기
        // 계산한 값을 다시 큐에 넣기
        // count ++
        // 최종적으로 count를 리턴
        
        PriorityQueue<Integer> que = new PriorityQueue<>();
        int zero = 0;
        for(int sco : scoville){
            if(sco == 0){
                zero++;
            }
            que.offer(sco);
        }
        if(zero == scoville.length){
            return -1;
        }
        
        int count = 0 ;
        while(!que.isEmpty()){
            // 첫번째거를 빼서  k 보다 작은지 확인
            int first = que.poll();
            
            if(first >= K){
                // k 이상: while문 멈추기
                break;
            }
           // k보다 작으면 두번째거도 빼서 둘이 계산하기
            if(que.isEmpty()){
                return -1;
            }
            int second = que.poll();
            
            int newSco = first + (second*2);
            // 계산한 값을 다시 큐에 넣기
            que.offer(newSco);
            
            count ++;            
        }
        return count;
        
    }
}
import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        
        List<Integer> index = new ArrayList<>();
        
        // 1. 큐 배열 정리 [[인덱스, 우선순위]]
        Queue<int[]> prioQue = new LinkedList<>();
        for(int i = 0 ; i < priorities.length; i ++){
            prioQue.offer(new int[] {i, priorities[i]});
        }
        
        int executionOrder = 0;
        // 2. 메인 함수
        while(!prioQue.isEmpty()){
            
            int[] current = prioQue.poll();
            
            //2.1 현재 프로세스보다 높은 우선순위가 있는지 확인
            boolean hasHigherPriority = false;
            for(int[] process : prioQue){
                if(process[1] > current[1]){
                    hasHigherPriority = true;
                    break;
                }
            }
            
            if(hasHigherPriority){
                prioQue.offer(current);
            } else{
                executionOrder++;
                if(current[0] == location){
                    return executionOrder;
                }
            }
            
        }
        
        return executionOrder;
    }
    
}
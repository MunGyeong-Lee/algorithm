
import java.util.*;

class Solution {
    
    Map<String, Integer> memo = new HashMap<>();
    
    public int solution(int[] numbers, int target) {

        int answer = dfs(numbers, 0, 0, target);
        return answer; 
          
    }
    
    public int dfs(int[] numbers, int currentSum,  int index, int target){
        
        // 기저조건: index가 배열에 도달하고 타겟 번호이면 
        if(index == numbers.length){
            return currentSum == target ? 1 : 0;
        }
        
        // 메모이제이션 체크
        String key = index + "," + currentSum;
        if(memo.containsKey(key)){
            return memo.get(key);
        }
        
        // 절대값 차이 체크: 현재 합과 타겟의 차이 > 남은 숫자들의 합
        int remainingSum = 0;
        for(int i = index ; i < numbers.length ; i++){
            remainingSum += numbers[i];
        }
        if(Math.abs(currentSum - target) > remainingSum){
            memo.put(key, 0);
            return 0;
        }
        
        int result = dfs(numbers, currentSum + numbers[index], index + 1, target) + dfs(numbers, currentSum - numbers[index], index + 1, target);
        
        
        memo.put(key, result);
        return result;
        
    
            
        
        
    }
    
    
    
}
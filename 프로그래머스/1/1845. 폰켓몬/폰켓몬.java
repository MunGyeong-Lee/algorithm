import java.util.*;

class Solution {
    public int solution(int[] nums) {
        
        Map<Integer, Integer> ponketmon = new HashMap<>();
        for(int kind : nums){
            ponketmon.put(kind, ponketmon.getOrDefault(kind, 0) +1 );
        }
        
        
        int answer = 0;
        answer = Math.min( ponketmon.size() , nums.length / 2);
        return answer;
    }
}
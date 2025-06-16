import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        
        
        int max = 0;
        for(int time: times){
            max = Math.max(max, time);
        }
        long minTime = 1;
        long maxTime = (long)n * max;
        while(minTime < maxTime){
  
            long midTime = (minTime+maxTime)/2;
            
            // midTime에서 심사 완료 사람 수: people
            long people = 0;
            for(int time: times){
                people += midTime / time;
            }
            
            // people이 n보다 크거나 같으면 -> 더 작은 시간에도 가능한지 확인: maxTime = mid
            // people이 n보다 작으면 -> midTime이 더 커져야함 : minTime = mid +1;
            if(people >= n){
                maxTime = midTime;    
            } else{
                minTime = midTime +1;
            }
            
            
        }
        
        
        return maxTime;
    }
}
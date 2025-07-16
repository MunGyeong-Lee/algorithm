import java.util.*;
class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        // 이진탐색으로 레벨을 구하기
        // 레벨 범위: 최소 난이도 ~ 최대 난이도
        // 레벨 선택 : (최소 난이도 + 최대 난이도) /2
        // 실제로 걸린 시간 <= limit
            // 실제로 걸린 시간 기록
            // 더 낮을 레벨 찾아보기
            // 최대 난이도 = 현재 레벨
        // 실제로 걸린 시간 > limit
            // 더 높은 레벨 찾아보기
            // 최소 난이도 = 현재 래벨 
        
        int minDiff = Integer.MAX_VALUE;
        int maxDiff = 0;
        for(int i = 0 ; i < diffs.length ; i++){
            minDiff = Math.min(minDiff, diffs[i]);
            maxDiff = Math.max(maxDiff, diffs[i]);
        }
        // System.out.println(minDiff+ " " + maxDiff);
        long result = 0; // 실제 걸린 시간 기록
        int answer = maxDiff;
        while(minDiff <= maxDiff){
            int level = (minDiff + maxDiff) / 2;
            int time_prev = 0;
            long totalTime = 0;
            // 게임 진행
            for(int i = 0 ; i < diffs.length ; i++){
                int diff = diffs[i];
                int time_cur = times[i];
                // diff ≤ level : totalTime += time_cur만큼의 시간을 사용하여 해결
                if(diff <= level){
                    totalTime += time_cur;
                } else{
                //diff > level :  totalTime += (time_cur + time_prev) * (diff - level번) + times[i];
                    totalTime += (time_cur + time_prev) * (diff - level) + time_cur;
                }
                time_prev = times[i];
                
                 // System.out.println(level+ " " + time_prev+  " " + totalTime);
                
            }
            
            // 이진탐색으로 레벨확인
            if(totalTime <= limit){
                result = totalTime;
                answer = level;
                maxDiff = level-1;
            } else{
                minDiff = level+1;
            }
            
            
        }
        
        
        return answer;
        
        
        
        
    }
}
import java.util.*;

class Solution {
    public int solution(int[][] info, int n, int m) {
        int len = info.length;
        
        // dp[j] = B도둑의 흔적이 j개일 때 A도둑의 최소 흔적
        int[] dp = new int[m];
        int[] newDp = new int[m];
        
        // 초기화
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0; // B도둑이 아무것도 훔치지 않았을 때
        
        for (int i = 0; i < len; i++) {
            Arrays.fill(newDp, Integer.MAX_VALUE);
            
            for (int bTrace = 0; bTrace < m; bTrace++) {
                if (dp[bTrace] == Integer.MAX_VALUE) continue;
                
                // A도둑이 현재 물건을 훔치는 경우
                int newATrace = dp[bTrace] + info[i][0];
                if (newATrace < n) {
                    newDp[bTrace] = Math.min(newDp[bTrace], newATrace);
                }
                
                // B도둑이 현재 물건을 훔치는 경우
                int newBTrace = bTrace + info[i][1];
                if (newBTrace < m) {
                    newDp[newBTrace] = Math.min(newDp[newBTrace], dp[bTrace]);
                }
            }
            
            // dp 배열 업데이트
            dp = newDp.clone();
        }
        
        // 결과 찾기
        int answer = Integer.MAX_VALUE;
        for (int bTrace = 0; bTrace < m; bTrace++) {
            if (dp[bTrace] != Integer.MAX_VALUE) {
                answer = Math.min(answer, dp[bTrace]);
            }
        }
        
        return answer == Integer.MAX_VALUE ? -1 : answer;
    }
}
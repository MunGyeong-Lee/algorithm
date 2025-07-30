import java.util.*;

class Solution {
    public int solution(int[] players, int m, int k) {
        
        int answer = 0; // 증설 횟수
        int addServers = 0 ; // 증설된 서버의 수
        Map<Integer, Integer> timerServers = new HashMap<>();// 시간 대 별 서버 개수
    
        for(int current = 0 ; current < 24 ; current++){
            
            
            // 현재 시간의 서버 대수 삭제
            addServers -= timerServers.getOrDefault(current,0);
            
            // 필요한 증설 대수 구하기
            // 만약 player <= m 이면 필요한 증설 대수는 servers < player/k
            // 아니면 0
            int needServers = (players[current] >= m) ? players[current]/m : 0;
            // needServers 한거 만큼 서버 증설  
            // 키 : current + 5 value : needServers
            if(addServers < needServers){
                timerServers.put(current+k, needServers-addServers);
                answer += needServers-addServers ;
                addServers = needServers;
            }

            // System.out.println("needServers: " + needServers + " players[current]: " + players[current] );
            // System.out.println("    current: " + current + " answer: " + answer + " addServers: " + addServers);
            

        }
        

        return answer;

        
    }
}
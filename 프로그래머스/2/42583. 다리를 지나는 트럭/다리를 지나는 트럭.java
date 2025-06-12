import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        
        Queue<Integer>bridge = new LinkedList<>(); // 다리 위 트럭들
        for(int i = 0 ; i < bridge_length ; i++){
            bridge.offer(0);
        }
        
        int turn = 0;
        int time = 0;
        int bridgeWeight = 0; // 현재 다리 위 무게
        
        while( turn < truck_weights.length || bridgeWeight > 0){
            time++;
            // 1. 일단 빼고 보기
            int exitWeight = bridge.poll(); 
            bridgeWeight -= exitWeight;
            
            // 2. 차올릴 조건
            if(turn < truck_weights.length && bridgeWeight + truck_weights[turn] <= weight ){
                bridge.offer(truck_weights[turn]);
                bridgeWeight += truck_weights[turn];
                turn ++;
            }else{
                bridge.offer(0);
            }
            
            
        }

        return time;
    }
}
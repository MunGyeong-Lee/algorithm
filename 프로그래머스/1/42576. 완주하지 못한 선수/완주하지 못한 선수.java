import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        
        
        Map<String, Integer> participantMap = new HashMap<>();
        for(String name: participant){
            participantMap.put(name, participantMap.getOrDefault(name,0)+1);
        }
        Map<String, Integer> completionMap = new HashMap<>();
        for(String name: completion){
            completionMap.put(name, completionMap.getOrDefault(name,0)+1);
        }
        
        String answer = "";
        for(Map.Entry<String, Integer>participantEntry: participantMap.entrySet()){
            String name = participantEntry.getKey();
            int participantCount = participantEntry.getValue();
            int completionCount = completionMap.getOrDefault(name,0);
            
            if(participantCount != completionCount){
                // 완주 못한 사람
                answer = name;
            }
        }
                
        
        return answer;
    }
}
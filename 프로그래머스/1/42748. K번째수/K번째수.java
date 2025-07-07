import java.util.*;
class Solution {
    public int[] solution(int[] array, int[][] commands) {
        
        List<Integer> commandResult = new ArrayList<>();
        
        for(int index = 0 ; index < commands.length ; index++){
            int start = commands[index][0]-1;
            int end = commands[index][1]-1;
            int k = commands[index][2]-1;
            
            List<Integer> preList = new ArrayList<>();
            for(int i = start ; i <= end ; i++){
                preList.add(array[i]);
            }
            
            Collections.sort(preList);
            commandResult.add(preList.get(k));
        }
        
        
        int[] answer = commandResult.stream().mapToInt(i->i).toArray();
        return answer;
    }
}
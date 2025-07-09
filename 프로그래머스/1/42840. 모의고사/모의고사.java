import java.util.*;
class Solution {
    public int[] solution(int[] answers) {

        
        int[] person1 = pattern(new int[]{1,2,3,4,5}, answers.length);
        int[] person2 = pattern(new int[]{2, 1, 2, 3, 2, 4, 2, 5}, answers.length);
        int[] person3 = pattern(new int[]{3, 3, 1, 1, 2, 2, 4, 4, 5, 5}, answers.length);
        
        int[][] persons = new int[3][];
        persons[0] = person1;
        persons[1] = person2;
        persons[2] = person3;
        
        int[] scores = new int[3];
        for (int i = 0 ; i < 3; i++){
            int count = 0;
            for( int j = 0; j < answers.length ; j++){
                if(answers[j] == persons[i][j]){
                    count++;
                }
            }
            scores[i] = count;
            
        }
        
        int MaxCount = Math.max(scores[0], Math.max(scores[1], scores[2]));
        
        List<Integer>result = new ArrayList<>();
        for(int i = 0 ; i < 3; i++){
            if(scores[i] == MaxCount){
                result.add(i+1);
            }
        }
        
        
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
    
    public int[] pattern(int[] numbers, int answersLength){
        
        int[] result = new int[answersLength];
        for(int i = 0; i < answersLength ; i++){
            result[i] = numbers[i % numbers.length];
        }
        return result;
    }
    
}
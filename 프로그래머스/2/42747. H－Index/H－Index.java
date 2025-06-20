import java.util.*;

class Solution {
    public int solution(int[] citations) {
        
        // 내림차순 정렬
        Integer[] citationsObj = new Integer[citations.length];
        for(int i = 0 ; i < citations.length ; i++ ){
            citationsObj[i] = citations[i];
        }
        Arrays.sort(citationsObj, Collections.reverseOrder());

        int h = 0;
        for(int i = 0 ; i < citationsObj.length ; i++){
            if(i+1 <= citationsObj[i]){
                h = i+1;
            }
        }
        return h;
        
        
        
    }
}
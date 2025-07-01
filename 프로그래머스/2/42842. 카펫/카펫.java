import java.util.*;

class Solution {
    
    public int[] solution(int brown, int yellow) { 
        
        int total = brown + yellow;
        int[] result = new int[2];
        

        for(int h = 3 ; h <= Math.sqrt(total); h++){

            if(total % h == 0){
                int w = total / h;
                if(w >= h && (w-2)*(h-2)==yellow){
                    result[0] = w;
                    result[1] = h;
                    break;
                }
            }
        }
        return result;

        
    }
    
    
}
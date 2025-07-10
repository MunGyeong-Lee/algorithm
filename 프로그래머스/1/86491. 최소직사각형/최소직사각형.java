import java.util.*;
class Solution {
    public int solution(int[][] sizes) {
        
        int leftMax = 0;
        int rightMax = 0;
        for(int i =0 ; i < sizes.length ;i++){
        
            leftMax = Math.max(leftMax, Math.max(sizes[i][0],sizes[i][1]));
            rightMax = Math.max(rightMax, Math.min(sizes[i][0],sizes[i][1]));
        }
        System.out.println(leftMax + " " + rightMax);
        return leftMax* rightMax;
    }
}

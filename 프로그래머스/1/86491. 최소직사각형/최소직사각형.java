import java.util.*;
class Solution {
    public int solution(int[][] sizes) {
        
        int leftMax = 0;
        int rightMax = 0;
        for(int i =0 ; i < sizes.length ;i++){
            
            // 큰 수는 index 0 으로 옯기기
            if(sizes[i][0] < sizes[i][1]){
                int temp = sizes[i][0];
                sizes[i][0] = sizes[i][1];
                sizes[i][1] = temp;
            }
            
            leftMax = Math.max(leftMax, sizes[i][0]);
            rightMax = Math.max(rightMax, sizes[i][1]);
        }
        System.out.println(leftMax + " " + rightMax);
        return leftMax* rightMax;
    }
}

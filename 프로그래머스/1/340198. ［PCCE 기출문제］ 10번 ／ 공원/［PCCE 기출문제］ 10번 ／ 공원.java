import java.util.*;
class Solution {
    Integer[] mats_desc;
    int count_mats;
    int park_r;
    int park_c;
    public int solution(int[] mats, String[][] park) {
        
        // 1. mats 내림차순 : 큰 매트부터 
        count_mats = mats.length;
        mats_desc = new Integer[count_mats];
        park_r = park.length;
        park_c = park[0].length;
        
        for(int i = 0 ; i < count_mats ;i++ ){
            Integer Integer_mats = mats[i];
            mats_desc[i] = Integer_mats;
        }
        Arrays.sort(mats_desc, Comparator.reverseOrder());
        
        
        // 2. 공원 탐색
        // 2.1. -1인 공간: 돗자리 크기 만큼영역이 -1인지 확인
        // L*L 범위 만큼의 for문을 돌아본다.

        for(int i = 0 ; i < count_mats ; i++){
            Integer current_mat = mats_desc[i];
            
            for(int x = 0 ; x <= park_r-current_mat ; x++){
                for(int y = 0 ; y <= park_c-current_mat ; y++){
                    if(park[x][y].equals("-1")){
                        
                        boolean foundObstacle = false;
                        checkLoop:
                        for(Integer j = x ; j< x +current_mat ; j++){
                            for(Integer k = y ; k < y+current_mat ; k++){
                                if(!park[j][k].equals("-1")){
                                    // System.out.println(park[j][k]);
                                    foundObstacle = true;
                                    break checkLoop;
                                } 
                            }

                        }
                        if(!foundObstacle){
                            return current_mat;
                        }
                        
                        
                    }
                }
            }
            
        }
        
        return -1;
    }
}
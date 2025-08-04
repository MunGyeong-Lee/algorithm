class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        
        int people = schedules.length;
        int answer = 0;
        
        for(int i = 0 ; i < people ;i++){
            
            int hour = schedules[i] / 100;
            int min = (schedules[i] % 100) + 10;
            int maxTime = timer(hour, min);
            
            
            int j = 0;
            int yoil = startday;
            if(startday == 6 ){
                j = 2;
                yoil = 1;
            } else if(startday == 7){
                j = 1;
                yoil = 1;
            }
            

            boolean flag = false;
            
             for(int count = 0; count < 5; count++) {
                
                if(yoil == 6 ){
                    j += 2;
                    yoil = 1;
                } else if(yoil == 7){
                    j += 1;
                    yoil = 1;
                }
                
                
                if(timelogs[i][j] > maxTime){
                    flag = true;
                    break;
                }
                 
                 j++;
                 yoil = (yoil % 7) + 1;
            
            }
            
            if(flag == false){
                answer ++;
            }
        
            
        }
        

        
        return answer;
    }
    
    public int timer (int hour, int min){
        
        
        if(min >= 60){
                hour++;
                min -= 60;  
            }
            
            return hour*100 + min;
        

    }
}


















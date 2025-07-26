class Solution {
    
    public static int timeToSecond(String time){
        String[] parts = time.split(":");
        return Integer.parseInt(parts[0]) * 60 + Integer.parseInt(parts[1]);
    }
    
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {

        
        int videoSec = timeToSecond(video_len);
        int currentSec = timeToSecond(pos);
        int opStartSec = timeToSecond(op_start);
        int opEndSec = timeToSecond(op_end);
        
        
        
        
        
        for( String command : commands){
            
            // 오프닝 건너뛰기: op_start ≤ 현재 재생 위치 ≤ op_end 이면 op_end로 이동하기
            if(opStartSec <= currentSec && currentSec <= opEndSec ){
                currentSec = opEndSec;
            }
            // prev: 10 초 되돌아 가기 / 현재 위치가 10 초 미만 이면 영상 처음으로 이동
            if(command.equals("prev")){
                if(currentSec < 10){
                    currentSec = 0;
                }else{
                    currentSec -= 10;
                }
            }
            
            // next : 10 초 건너 뛰기/ 남은 시간 10 초 미만 이면 마지막 위치로 이동
            if(command.equals("next")){
                if(videoSec - currentSec < 10){
                    currentSec = videoSec;
                }else{
                    currentSec += 10;
                }
            }
            
            // 오프닝 건너뛰기: op_start ≤ 현재 재생 위치 ≤ op_end 이면 op_end로 이동하기
            if(opStartSec <= currentSec && currentSec <= opEndSec ){
                currentSec = opEndSec;
            }
        }
        
        int resultMin = currentSec / 60;
        int resultSec = currentSec % 60;
        
        String answer = String.format("%02d:%02d", resultMin, resultSec);
        return answer;
        
        
        
        
    }
}
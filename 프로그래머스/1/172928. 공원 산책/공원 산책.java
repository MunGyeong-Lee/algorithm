import java.util.*;

class Solution {
    public int[] solution(String[] park, String[] routes) {
        int xLen = park.length; // 세로 길이
        int yLen = park[0].length(); // 가로 길이
        
        // 시작점 찾기
        int sx = 0, sy = 0;
        for(int i = 0; i < xLen; i++){
            for(int j = 0; j < yLen; j++){
                if(park[i].charAt(j) == 'S'){
                    sx = i;
                    sy = j;
                }
            }
        }
        
        // 각 명령 처리
        for(int i = 0; i < routes.length; i++){
            String[] route = routes[i].split(" ");
            char direction = route[0].charAt(0);
            int distance = Integer.parseInt(route[1]);
            
            // 방향에 따른 이동값 설정
            int dx = 0, dy = 0;
            if(direction == 'E') { dx = 0; dy = 1; }      // 동쪽
            else if(direction == 'W') { dx = 0; dy = -1; } // 서쪽  
            else if(direction == 'S') { dx = 1; dy = 0; }  // 남쪽
            else if(direction == 'N') { dx = -1; dy = 0; } // 북쪽
            
            // 이동 가능한지 검사 (경로상의 모든 칸 확인)
            boolean canMove = true;
            for(int step = 1; step <= distance; step++){
                int newX = sx + dx * step;
                int newY = sy + dy * step;
                
                // 범위 벗어남 또는 장애물 만남
                if(newX < 0 || newX >= xLen || newY < 0 || newY >= yLen || 
                   park[newX].charAt(newY) == 'X'){
                    canMove = false;
                    break;
                }
            }
            
            // 이동 가능하면 최종 위치로 이동
            if(canMove){
                sx += dx * distance;
                sy += dy * distance;
            }
            
            System.out.println(sx + " " + sy);
        }
        
        return new int[]{sx, sy};
    }
}
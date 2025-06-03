import java.util.*;

class Solution {
    
    private boolean[][] visited; // 방문이력
    private int[] dx = {0, 1, 0, -1};
    private int[] dy = {1, 0, -1, 0};
    
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        
        // 1. rectangle 을 가지고 영역 만들기
        boolean[][] terrain = createTerrain(rectangle);
        
        // 2. bfs로 가장 짧은 거리 탐색하기
        int answer = bfs(terrain, characterX, characterY, itemX, itemY);
        

        return answer;
    }
    
    private boolean[][] createTerrain(int[][] rectangle) {
        boolean[][] terrain = new boolean[102][102];
        
        // 1단계: 모든 직사각형 채우기
        for (int[] rect : rectangle) {
            int x1 = rect[0] * 2;
            int y1 = rect[1] * 2;
            int x2 = rect[2] * 2;
            int y2 = rect[3] * 2;
            
            for (int x = x1; x <= x2; x++) {
                for (int y = y1; y <= y2; y++) {
                    terrain[x][y] = true;
                }
            }
        }
        
        // 2단계: 각 직사각형의 내부를 다시 지우기 (테두리만 남기기)
        for (int[] rect : rectangle) {
            int x1 = rect[0] * 2;
            int y1 = rect[1] * 2;
            int x2 = rect[2] * 2;
            int y2 = rect[3] * 2;
            
            // 테두리 제외하고 내부만 지우기
            for (int x = x1 + 1; x < x2; x++) {
                for (int y = y1 + 1; y < y2; y++) {
                    terrain[x][y] = false;
                }
            }
        }
        
        return terrain;
    }
    
    
    private boolean isBorder(boolean[][] terrain, int x, int y) {
        // 현재 위치가 지형이 아니면 테두리 아님
        if (!terrain[x][y]) return false;

        // 배열 경계에 있으면 자동으로 테두리
        if (x-1 < 0 || x+1 >= 102 || y-1 < 0 || y+1 >= 102) return true;

        // 상하좌우 중 하나라도 지형 밖이면 테두리
        return !terrain[x-1][y] || !terrain[x+1][y] || 
               !terrain[x][y-1] || !terrain[x][y+1];
    }
    
    
    
    
    private int bfs(boolean[][] terrain, int characterX, int characterY, int itemX, int itemY){
                
        
        // queue, visited 만들기
        Queue<int[]> que = new LinkedList<>();
        que.offer(new int[]{0, characterX*2, characterY*2});
        visited = new boolean[102][102];
        visited[characterX*2][characterY*2] = true;
        
        // 구현
        while(!que.isEmpty()){
            
            int[] current = que.poll();
            
            System.out.println(Arrays.toString(current));
            
            if(current[1]==itemX*2 && current[2]==itemY*2){
                //답은 나누기 2 해서 도출할 것! (영역구하기에서 2배 늘렸기 때문)
                
                return current[0]/2;
            }
            
            for(int i = 0 ; i < 4; i++){
                
                int nx = current[1] + dx[i];
                int ny = current[2] + dy[i]; 
                
                // nx ny 유효한지 + nx ny영역이 true 인지 + nx ny를 이미 방문했는지
                if(nx >= 0 && nx < 102 && ny >= 0 && ny < 102 && !visited[nx][ny]){
                     if (isBorder(terrain, nx, ny)){
                        que.offer(new int[] {current[0]+1, nx, ny});
                        visited[nx][ny] = true;
                     }

                    

                }
            }
        }
        return 0;
    }
    
    
    
    
    
}
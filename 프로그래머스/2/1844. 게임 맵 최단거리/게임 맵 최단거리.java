import java.util.*;

class Solution {
    
    int[] dx = {0,1,0,-1};
    int[] dy = {1,0,-1,0};
    
    public int solution(int[][] maps) {
        
        int n = maps.length;
        int m = maps[0].length;
        
    
        int answer = bfs(maps, n, m);
        return answer;
    }
    
    public int bfs(int[][] maps, int n , int m){
        
        Queue<int[]> que = new LinkedList<>();
        que.offer(new int[] {0,0,1});
        boolean[][] visited = new boolean[n][m];
        
        while(!que.isEmpty()){
            
            int[] now = que.poll();
            int x = now[0];
            int y = now[1];
            int dis = now[2];
            
            
            if(x == n-1 && y == m-1){
                return dis;
            }
            
            for(int i = 0 ; i < 4 ; i++){
                
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                if(nx >= 0 && nx < n && ny >= 0 && ny < m && maps[nx][ny] == 1 &&!visited[nx][ny]){
                    que.offer(new int[] {nx, ny, dis+1});
                    visited[nx][ny] = true;
                }
            }
        }
        return -1;
        
    }
}
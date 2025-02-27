import java.util.*;
import java.io.*;

public class Main{
    static int N, M ;
    static int[][] graph ;
    static int[][][] visited ;
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        graph = new int[N][M];
        
        for(int i = 0 ; i < N; i++){
            String line = br.readLine();
            for(int j = 0 ; j < M ; j++){
                graph[i][j] = line.charAt(j)-'0';
            }
        }
        
        visited = new int[N][M][2];
        
    
        int result= bfs(0,0,0);
        
        System.out.println(result);

    }
    
    public static int bfs(int start, int end ,int wall){
        
        Queue<int[]> que = new LinkedList<>();
        que.offer(new int[]{0,0,0});
        visited[0][0][0] = 1;
        
        while(!que.isEmpty()){
            
            int[] current = que.poll();
            int x = current[0];
            int y = current[1];
            int broken = current[2];
            
            
            if(x == N-1 && y  == M-1){
                return visited[x][y][broken];
            }
            
            for(int i = 0; i < 4 ; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                // 배열을 벗어나면 다음 노선 확인인
                if(nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
                
                // 배열을 안 벗어 나면 진행
                // 1. 안 막혔고고 방문한 적이 없으면
                if(graph[nx][ny] == 0 && visited[nx][ny][broken] == 0){
                    que.offer(new int[]{nx, ny, broken});
                    visited[nx][ny][broken] = visited[x][y][broken] + 1;
                }
                
                // 2. 막혔고, 벽을 한 번도 뚫은 적이 없으면
                if(graph[nx][ny] == 1 && broken == 0){
                    que.offer(new int[]{nx, ny, 1});
                    visited[nx][ny][1] = visited[x][y][0]+1;
                }

            }

        }
        return -1;
    }
    
}
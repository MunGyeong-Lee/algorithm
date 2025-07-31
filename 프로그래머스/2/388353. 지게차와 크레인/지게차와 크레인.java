import java.util.*;

class Solution {
    int r, c;
    char[][] graph ;
    int[] dx = {0,1,0,-1};
    int[] dy = {1,0,-1,0};
    public int solution(String[] storage, String[] requests) {
        
        // 그래프 만들기 n+2, m+2만큼 / 테두리는 n으로 
        r = storage.length;
        c = storage[0].length();
        graph = new char[r+2][c+2];
        for(int i = 0 ; i < r+2 ; i++){
            for(int j = 0 ; j < c+2 ; j++){
                graph[i][j] ='n';
            }
        }
        for(int i = 0 ; i < r; i++){
            for(int j = 0 ; j < c ; j++){
                graph[i+1][j+1] = storage[i].charAt(j);
            }
        }
        
        for(String request : requests){
            char requ = request.charAt(0);
            // requests의 문자 길이 = 1 -> 지게차 함수
            if(request.length() == 1){
                fork(requ);
            } else{
                // requests 의 문자 길이 = 2 -> 크레인 함수
                crane(requ);
            }
        
 
        }
        
        int answer = 0;
        for(int i = 1 ; i <= r ; i++){
            System.out.print("Row " + i + ": ");
            for(int j =1 ; j <= c ; j++){
                if(graph[i][j] != 'n'){
                    System.out.print(graph[i][j] + " ");
                    answer++;
                }
            }
            System.out.println();
        }
        

        return answer;
        
    }
    
    public void fork(char target){
        
        Queue<int[]> que = new LinkedList<>();
        boolean[][] visited = new boolean[r+2][c+2];
        List<int[]> toRemove = new ArrayList<>();
        
        // n 인 구역 다 큐에 넣기
        // for(int i = 0 ; i < r+2 ; i++){
        //     for(int j = 0 ; j < c+2 ; j++){
        //         if(graph[i][j] == 'n'){
        //             que.offer(new int[]{i,j});
        //             visited[i][j] = true;
        //         }
        //     }
        // }  
        que.offer(new int[]{0,0});
        visited[0][0] = true;
        // bfs
        while(!que.isEmpty()){
            int[] current = que.poll();
            int cr = current[0];
            int cc = current[1];
            
            // 타겟 발견하면 toRemove에 추가하고 다음 노드 확인
            if(graph[cr][cc] == target){
                toRemove.add(new int[]{cr,cc});
                continue;
            }
            
            // n이 아니라면 다음 노드 확인
            if(graph[cr][cc] != 'n'){
                continue;
            }
            
            
            for(int i = 0 ; i < 4; i++){
                int nr = cr + dx[i];
                int nc = cc + dy[i];
                
                if(nr >= 0 && nr < r+2 && nc >= 0 && nc < c+2 && !visited[nr][nc]){
                    visited[nr][nc] = true;
                    que.offer(new int[]{nr, nc});
                }
                    
            }
        }
        
        // toRemove의 자리를 n으로 초기화
        for(int[] pos : toRemove){
            graph[pos[0]][pos[1]] = 'n';
            System.out.print("지게차: " + pos[0]+" "+ pos[1] + " ");
        }
       
    }
    
    public void crane(char target){
     
        for(int i = 1 ; i <= r; i++){
            for(int j = 1 ; j <= c ; j++){
                if(graph[i][j] == target){
                    graph[i][j] = 'n';
                    System.out.print("크레인: " + i+" "+ j + " ");
                }
            }
        }
        
    }
    
}
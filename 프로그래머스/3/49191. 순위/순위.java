import java.util.*;
class Solution {
    public int solution(int n, int[][] results) {
        
        // 1. 인접 행렬 그래프
        int graph[][] = new int[n][n];
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                graph[i][j] = 0;
            }
        }
        
        for(int[] result : results){
            int a = result[0]-1;
            int b = result[1]-1;
            graph[a][b] = 1;
        }
        
        // 플로이드-와샬
        for(int k = 0 ; k < n; k++){ // 경유지
            for(int i = 0; i < n ; i ++ ){ // 출발지
                for(int j = 0 ; j < n ; j++){ // 도착지
                    if(graph[i][k] == 1 && graph[k][j] == 1){
                        graph[i][j] = 1;
                    }
                }
            }
        }
        
        int answer = 0;
        for(int i = 0 ; i < n ; i++){
            int count = 0 ;
            for(int j = 0 ; j < n ; j++){
                if(graph[i][j] == 1) count ++;
                if(graph[j][i] == 1) count ++;
                
            }
            if(count == n-1){
                answer ++;
            }
        }
        
         return answer;
        
        
    }
}
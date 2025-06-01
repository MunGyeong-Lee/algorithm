class Solution {
    
    boolean[] visited ;
    
    public int solution(int n, int[][] computers) {
        
        // 컴퓨터 별로 연결 탐색 
        visited = new boolean[n];
        int count = 0;
        
        for(int i = 0 ; i < n; i++){
            // 아직 방문안한 컴퓨터라면
            if(!visited[i]){
              dfs(i, n, computers);
              count++;
            }
    
            
        }
        
        return count;
    }
    
    private void  dfs (int start, int n , int[][]computers){
        
        visited[start] = true;
        for(int i = 0 ; i < n ; i++){
            if(!visited[i] && computers[start][i] == 1){
                dfs(i, n , computers);
            }
        }
        
    }
    
    
}
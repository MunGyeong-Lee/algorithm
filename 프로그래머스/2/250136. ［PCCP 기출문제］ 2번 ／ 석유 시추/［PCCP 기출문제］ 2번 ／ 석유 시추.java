import java.util.*;
class Solution {
    
    int[] dx ={0,1,0,-1};
    int[] dy ={1,0,-1,0};
    
    int r, c;
    boolean[][] visited ;
    int[][] groupGrid;
    int groupId = 1;
    Map<Integer, Integer> oilGroups = new HashMap<>();
    
    public int solution(int[][] land) {
        
        r = land.length;
        c = land[0].length;
        visited = new boolean[r][c];
        groupGrid = new int[r][c];
        
        
        //  dfs로 석유가 있는 부분 찾아서 그래프에 석유 덩어리 크기 만큼 표시하기
        // 예를 들어 덩어리가 12이거 첫번째로 찾았으면 그래프에 1로 표시하고 오일 그래프 정보를 저장하는 해시 맵에 {1: 12} 라는 식으로 저장하기
        for(int i = 0 ; i < r ; i++){
            for(int j = 0 ; j < c ; j++){
                if(!visited[i][j]&& land[i][j] == 1){
                    int size = dfs(i,j,land);
                    oilGroups.put(groupId,size);
                    groupId++;   
                }
            }
        }
        
         // 그러고나서 그래프에서 열 -> 행 : 행 기준 한 칸 식 내려가보기, 방문 배열을 두고 내가 이번 열에서 방문한 적이 없으면 덩어리값을 더하고, 방문한 적이 있으면 덩어리값 안더함
        // 그 다음 열 차례가 되면 방문 배열을 다시 초기화 
        int answer = 0;
        for(int j = 0 ; j < c; j++){
            Set<Integer> visitedGroup = new HashSet<>();
            int totalOil = 0;
            for(int i = 0 ; i < r; i++){
                int currentGroupId = groupGrid[i][j];
                if(currentGroupId > 0 && !visitedGroup.contains(currentGroupId)){
                    visitedGroup.add(currentGroupId);
                    totalOil += oilGroups.get(currentGroupId);
                }
            }
            answer = Math.max(answer, totalOil);

        }
        return answer;
        
        
    }
    
    
    public int dfs(int i, int j, int[][] land){
        Stack<int[]> stack = new Stack<>();
        stack.push(new int[]{i,j});
        visited[i][j] = true;
        groupGrid[i][j] = groupId;
        int count = 0;
        
        while(!stack.isEmpty()){
            int[] current = stack.pop();
            int cr = current[0];
            int cc = current[1];
            count ++;
            
            for(int index = 0 ; index < 4; index++){
                int nr = cr + dx[index];
                int nc = cc + dy[index];
                
                if(nr >= 0 && nr <  r && nc >= 0 && nc <  c && 
                   !visited[nr][nc] && land[nr][nc] == 1){
                    stack.push(new int[]{nr,nc});
                    visited[nr][nc] = true;
                    groupGrid[nr][nc] = groupId;
                }
            }
        }
        return count;
    }
}
import java.util.*;
class Solution {

    public int solution(int n, int[][] wires) {
        
        int answer = Integer.MAX_VALUE;
        
        // 반복문: 해당 간선을 제외하고 완전탐색 함수 실행
        for(int i = 0 ; i < wires.length; i++){
            
            int result = search(n, wires, i);
            System.out.println(i +"시도" + ":" + result);
            answer = Math.min(answer, result) ;   
        }
        
        return answer;
    }
    // 완전탐색 함수
    public int search(int n ,int[][] wires, int index){ // i = 제외시킬 간선 
        
        // 제외시킬 간선 반영하여 인접리스트 만들기
        List<Integer>[] graph = new List[n+1];
        for(int i = 0 ; i <= n ; i ++){
            graph[i] = (new ArrayList<>());
        }
        
        for(int j = 0 ; j < wires.length; j++){
            if (j != index){
                int a = wires[j][0];
                int b = wires[j][1];
                graph[a].add(b);
                graph[b].add(a);
            }
        }
        
        // DFS
        int result = 0;
        boolean[] visited = new boolean[n+1]; //  방문배열
        
        for(int k = 1 ; k <= n ; k++){
            if(!visited[k]){
                
                Stack<Integer> stack = new Stack<>();
                stack.push(k);
                int count = 0 ;
                
                while(!stack.isEmpty()){
                    int now = stack.pop();
                    if(visited[now]) continue;
                    
                    visited[now] = true;
                    count++;
                    
                    for(int next : graph[now]){
                        if(!visited[next]){
                            stack.push(next);
                        }
                    }
                }
                
                if(result == 0){
                    result += count;
                }else{
                    result -= count;
                }        
            }
        }
        return Math.abs(result);
        
        
    }
}
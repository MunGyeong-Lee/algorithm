import java.util.*;
class Solution {
    boolean[] visited ; 
    public int solution(int n, int[][] edge) {
        
        // 1. 간선 그래프 만들기
        List<Integer>[] graph = new List[n+1];
        for(int i = 0 ; i < n+1 ; i++){
            graph[i] = (new ArrayList<>()); 
        }
        
        for(int i = 0 ; i < edge.length ; i ++){
            int a = edge[i][0];
            int b = edge[i][1];
            graph[a].add(b);
            graph[b].add(a);
        }
        
        //2. bfs
        int answer = bfs(graph, n);
        
        return answer;
        
    }
    
    // bfs 함수
    // 큐: {노드번호, 간선 개수}
    // distance 배열: 각 노드별 간선 개수
    public int bfs(List<Integer>[] graph, int n){
        
        Queue<int[]> que = new LinkedList<>();
        que.offer(new int[] {1,0});
        int[] distance = new int[n+1];
        for(int i=0 ; i < n+1 ; i++){
            distance[i] = -1;
        }
        visited = new boolean[n+1];
        visited[1] = true;
        distance[1] = 0;
        
        while(!que.isEmpty()){
            
            int[] dis = que.poll();
            int now = dis[0];
            int count = dis[1];

            for(int i : graph[now]){
                if(!visited[i]){
                    distance[i] = count+1;
                    que.offer(new int[] {i, count+1} );
                    visited[i] = true;
                }
                
            }
            
        }
        
        int maxDis = 0;
        int count = 0;
        for(int dis : distance){
            System.out.println("turn: "+dis);
            
            if(dis == -1) continue;
            
            if(dis > maxDis){
                maxDis = dis;
                count = 0;
                System.out.println( dis + " "+ count);
            } 
            
            if(dis == maxDis){
                count ++;
                System.out.println( dis + " "+ count);
            }
            
        }
        
    
        
        return count;
        
    }
    
}
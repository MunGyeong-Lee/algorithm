import java.util.*;
import java.io.*;

class Node implements Comparable<Node>{
    int vertex, cost;
    
    public Node(int vertex, int cost){
        this.vertex = vertex;
        this.cost = cost;
    }
    
    @Override
    public int compareTo(Node  o){
        return Integer.compare(this.cost, o.cost);
    }
} 


public class Main{
    
    static int N, E, v1, v2;
    static List<List<Node>>graph;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken()); // 정점 개수
        E = Integer.parseInt(st.nextToken()); // 간선 개수
        graph = new ArrayList<>();            // 그래프
        
        // 그래프 초기화
        for(int i = 0 ;  i < N; i++){
            graph.add(new ArrayList<>());
        }
        
        // 그래프 정보 저장
        for(int i = 0 ; i < E; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken())-1;
            int b = Integer.parseInt(st.nextToken())-1;
            int c = Integer.parseInt(st.nextToken());
            
            graph.get(a).add(new Node(b, c));
            graph.get(b).add(new Node(a,c));
        }
        
        
        st = new StringTokenizer(br.readLine());
        int v1 = Integer.parseInt(st.nextToken())-1; // 반드시 거쳐야하는 정점
        int v2 = Integer.parseInt(st.nextToken())-1; // 반드시 거쳐야하는 정점
        
        
        int[] distFromStart = dijkstra(0);    // 출발점에서 모든 정점까지의 거리 저장
        int[] distFromV1 = dijkstra(v1);      // v1에서 모든 정점까지의 거리 저장
        int[] distFromV2 = dijkstra(v2);      //v2에서 모든 정점까지의 거리 저장
        
        
        // start -> v1
        // v1 -> v2
        // v2 -> end
        
        int result1 = distFromStart[v1] + distFromV1[v2] + distFromV2[N-1];
        
        
        // start -> v2
        // v2 -> v1
        // v1 -> end
        
        int result2 = distFromStart[v2] + distFromV2[v1] + distFromV1[N-1];
        
        
        if( distFromStart[v1] == Integer.MAX_VALUE||
            distFromV1[v2] == Integer.MAX_VALUE||
            distFromV2[N-1] == Integer.MAX_VALUE) {
                result1= Integer.MAX_VALUE;
        }
        
        if( distFromStart[v2] == Integer.MAX_VALUE||
            distFromV2[v1] == Integer.MAX_VALUE||
            distFromV1[N-1] == Integer.MAX_VALUE ) {
                result2 = Integer.MAX_VALUE;
            }
        
        
        int resultMin = Math.min(result1, result2); // 비교
        
        if (resultMin == Integer.MAX_VALUE){
            System.out.println(-1);
        }else{
            System.out.println(resultMin);
        };
        


    }
    
    public static int[] dijkstra(int start){
        // 우선순위 큐 초기화
        PriorityQueue<Node>pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));
        
        // 거리 리스트 초기화
        int[] dist = new int[N];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;
        
        while(!pq.isEmpty()){
            
            Node now = pq.poll();
            int v = now.vertex;
            int cost = now.cost;
            
            if(cost > dist[v]) continue;
            
            for(Node next: graph.get(v)){
                
                int nextV = next.vertex;
                int nextC = next.cost;
                int newDist = nextC+cost;
                
                if(dist[nextV] > newDist){
                    dist[nextV] = newDist;
                    pq.offer(new Node(nextV, newDist));
                }
            }
        }
        
        return dist;
        
    }
    
}
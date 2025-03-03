
import java.util.*;
import java.io.*;


class Node implements Comparable<Node>{
    
    int vertex, cost;
    
    public Node(int vertex, int cost){
        this.vertex = vertex;
        this.cost = cost;
    }
    
    @Override
    public int compareTo(Node o){
        return Integer.compare(this.cost, o.cost); // 비용 기준으로 최소 힙 정렬
    }
}


public class Main{
    
    static int N, M, R ;
    static List<Integer>items;
    static List<List<Node>>graph;
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken()); // 지역의 개수
        M = Integer.parseInt(st.nextToken()); // 수색범위
        R = Integer.parseInt(st.nextToken()); // 길의 개수
        
        st = new StringTokenizer(br.readLine());
        items = new ArrayList<>();  // 지역별 아이템 수 
        for(int i = 0 ; i < N ; i++ ){
           
            items.add(Integer.parseInt(st.nextToken()));
        }
        
        graph = new ArrayList<>();
        for(int i = 0 ; i < N; i++){
            graph.add(new ArrayList<>());
        }
        
        
        for(int i = 0 ; i < R ; i++){
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken())-1;
            int B = Integer.parseInt(st.nextToken())-1;
            int L = Integer.parseInt(st.nextToken());
            
            graph.get(A).add(new Node(B , L));
            graph.get(B).add(new Node(A, L));
            
        }
        
        
        int maxItems = 0;
        for(int i = 0 ; i < N; i++){
            maxItems = Math.max(maxItems, dijkstra(i));
        }
        
        System.out.println(maxItems);
        

        
    }
    
    public static int dijkstra(int start){
        // 우선 순위 큐 초기화
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
                int newDist = cost + nextC;
                
                if(newDist < dist[nextV]) {
                    dist[nextV] = newDist;
                    pq.offer(new Node(nextV, newDist));
                }
                
            }
            
        }
        
        // 수색 범위 내에서 얻을 수 있는 아이템 수 계산
        int itemCount = 0 ;
        for(int i = 0 ; i < N ; i++){
            if(dist[i] <= M){
                itemCount += items.get(i);
            }
        }
        
        return itemCount;
        
    }
}
    
    
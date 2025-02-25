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
        return Integer.compare(this.cost, o.cost); // 비용 기준 최소 힙 정렬
    }
    
    @Override
    public String toString(){
        return "("+ vertex + ","+cost+")";
    }
}

public class Main{
    
    static final int INF = (int)1e9;
    static int N , M ;
    static List<List<Node>> graph;
    static int[] distance;
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine()); //도시 개수
        M = Integer.parseInt(br.readLine()); // 버스 개수수
        
        // 그래프 배열 초기화
        graph = new ArrayList<>(); // 간선 간의 비용 그래프
        for(int i = 0 ; i < N ; i++){
            graph.add(new ArrayList<>());
        }
        
        // 거리 배열 초기화
       distance = new int[N];// 누적 최소 비용을 관리하는 배열
       Arrays.fill(distance, INF);
        
        
        // 간선 정보 입력
        for(int i = 0 ; i < M ; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()); // 출발 도시
            int b = Integer.parseInt(st.nextToken()); // 도착 도시
            int c = Integer.parseInt(st.nextToken()); // 비용
            graph.get(a-1).add(new Node(b-1, c)); 
            
        }
        
        // System.out.println(graph.toString());
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        
        dikstra(x-1);
        
        // System.out.println(Arrays.toString(distance));
        System.out.println(distance[y-1]);
        
        

    }
    
    public static void dikstra(int start){
        // 우선 순위 큐 초기화화
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));
        distance[start] = 0; // 시작 노드의 최단 거리는 0;
        
        while(!pq.isEmpty()){
            
            // 현재 노드드
            Node current = pq.poll();
            int now = current.vertex;
            int dist = current.cost;
            
            // 이미 처리된 노드는 무시
            if(distance[now] < dist) continue;
            
            // 현재 노드와 연결된 다른 인접한 노드 확인
            for(Node next : graph.get(now)){
                int nextNode = next.vertex;
                int cost = next.cost;
                int newCost = dist + cost ; // 누적 비용 계산
                
                // System.out.println("새로운 비용" + newCost);
                
                // 만약 더 짧은 경로를 찾았다면 경로 갱신
                if(newCost < distance[nextNode]){
                    distance[nextNode] = newCost;
                    pq.offer(new Node(nextNode, newCost));
                    
                }
                
            }
        }

    }
}

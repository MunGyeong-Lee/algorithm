
import java.util.*;
import java.io.*;

public class Main{
    static int N, M ;
    static List<List<Integer>> graph;
    static List<List<Integer>> reverseGraph;
    static boolean[] visited;
    
    public static void main(String[]args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());   // 학생들의 수
        M = Integer.parseInt(st.nextToken());   // 키 비교 횟수
        graph = new ArrayList<>(N);              // 간선 정보 저장
        reverseGraph = new ArrayList<>();       // 역 간선 정보 저장

        
        for(int i = 0 ; i < N ; i++){
            graph.add(new ArrayList<>());
            reverseGraph.add(new ArrayList<>());
        }
        
        
        for(int i = 0 ; i < M ; i ++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            
            graph.get(a-1).add(b-1);
            reverseGraph.get(b-1).add(a-1);
            
        }
        
        
        
        // System.out.println(graph.toString());
        // System.out.println(reverseGraph.toString());
        
        List<Integer> result = new ArrayList<>(N); // 학생별로 나보다 큰 학생 + 작은 학생 합을 저장
        for(int i = 0 ; i < N ; i++){
            result.add(0);
        }
        
        for(int i = 0 ; i < N ; i++){
            
            boolean[] visited = new boolean[N];
            
            int biggerValue = biggerDFS(i, visited);
            int smallerValue = smallerDFS(i, visited);
            
            result.set(i, biggerValue+smallerValue);
            
        }
        
        int resultCnt = 0;
        for(int i : result){
            if(i == N-1){
                resultCnt ++;
            }
        }
        System.out.println(resultCnt);
        // System.out.println(result.toString());
        
        
    }
    
    public static int biggerDFS(int start, boolean[] visited ){
        
        visited[start] = true;
        int biggerCount = 0;
        
        for(int student : graph.get(start)){
            if(!visited[student]){

                biggerCount += 1+ biggerDFS(student, visited);
            }
        }
        
        return biggerCount;
    } 
    
    public static int smallerDFS(int start, boolean[] visited){
        
        visited[start] = true;
        int smallerCount = 0;
        
        for(int pre: reverseGraph.get(start)){
            if(!visited[pre]){

                smallerCount += 1 + smallerDFS(pre, visited);
            }
        }
        return smallerCount;
    }
}
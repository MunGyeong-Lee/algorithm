import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static ArrayList<ArrayList<Integer>> graph;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // 1. 그래프 초기화
        graph = new ArrayList<>();
        for (int i = 0; i <= N; i++){
            graph.add(new ArrayList<>());
        }
        visited = new boolean[N+1]; // 방문 체크

        //2. 간선 정보 입력
        for(int i = 0; i < M ; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            graph.get(u).add(v); // graph.get(u): u번째 인덱스의  리스트 가져오기
            graph.get(v).add(u); // 무방향 그래프이므로 반대로도 입력
        }

        //4. 연결 요소 개수 계산
        int connectedComponents = 0;
        for(int i = 1; i <= N ; i++ ){
            if(!visited[i]){ // 방문 안 한 노드이면 dfs 함수 돌리기
                dfs(i);
                connectedComponents++;
            }
        }

        bw.write(String.valueOf(connectedComponents));
        bw.flush();
        br.close();
        bw.close();

    }

    // 3. DFS 함수
    private static void dfs(int node){
        visited[node] = true; // 방문표시
        for(int neighbor: graph.get(node)){
            if(!visited[neighbor]){ // 방문 안 한 노드이면 dfs 함수 돌리기
                dfs(neighbor);
            }
        }
    }
}

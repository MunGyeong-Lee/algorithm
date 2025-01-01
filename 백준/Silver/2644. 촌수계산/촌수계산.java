import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static int[][] graph;
    static boolean[] visited;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        int x = Integer.parseInt(input[0]);
        int y = Integer.parseInt(input[1]);
        int m = Integer.parseInt(br.readLine());

        // 1.  인접행렬 & 방문 리스트 초기화
        graph = new int[n+1][n+1];
        for (int i = 0; i < m; i++){
            String[] input2 = br.readLine().split(" ");
            int r = Integer.parseInt(input2[0]);
            int c = Integer.parseInt(input2[1]);

            graph[r][c] = 1;
            graph[c][r] = 1;
        }
        visited = new boolean[n+1];

        //2. bfs 호출
        int result = bfs(x,y,n);

        //3. 출력
        bw.write(String.valueOf(result));

        bw.flush();
        br.close();
        bw.close();
    }

    //bfs 함수
    private static int bfs(int start, int target, int n) {// 왜 int bfs
        Queue<int[]> queue = new LinkedList<>(); // Queue?
        queue.add(new int[]{start, 0}); // {현재 노드, 촌수} // 이 형태는 뭐야
        visited[start] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();// poll??
            int node = current[0];
            int depth = current[1];

            // 목표 노드 도달
            if (node == target) {
                return depth;
            }

            // 연결된 노드 탐색
            for (int i = 0; i <= n; i++) {
                if (graph[node][i] == 1 && !visited[i]) {
                    visited[i] = true;
                    queue.add(new int[]{i, depth + 1});
                }
            }
        }

        return -1;
    }
}

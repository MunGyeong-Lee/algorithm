import java.io.*;
import java.util.LinkedList;
import java.util.Queue;


public class Main {

    static int N;
    static int[][] graph;
    static boolean[][] visited;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        graph = new int[N][N];
        int maxHeight = 0;
        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                graph[i][j] = Integer.parseInt(input[j]);
                maxHeight = Math.max(maxHeight, graph[i][j]);
            }
        }

        int maxsafeArea = 0;
        for(int height = 0; height <= maxHeight; height++){
            visited = new boolean[N][N];
            int safeArea = 0;

            for(int i = 0 ; i < N; i++){
                for(int j = 0; j<N; j++){
                    if(graph[i][j] > height && !visited[i][j] ){
                        BFS(i,j,height);
                        safeArea++;
                    }
                }
            }
            maxsafeArea = Math.max(maxsafeArea, safeArea);

        }
        bw.write(String.valueOf(maxsafeArea));


        bw.flush();
        br.close();
        bw.close();

    }

    private static void BFS(int r, int c, int height) {
        // 초기화 (que, visited)
        Queue<int[]> que = new LinkedList<>();
        que.add(new int[]{r, c}); // 첫번째 노드 추가
        visited[r][c] = true; // 방문표시

        // 반복돌기
        while (!que.isEmpty()) {
            // quq 뽑아내기
            int[] current = que.poll();
            int cr = current[0];
            int cc = current[1];

            for (int i = 0; i < 4; i++) {
                int nx = cr + dx[i];
                int ny = cc + dy[i];

                if (nx >= 0 && nx < N && ny >= 0 && ny < N && graph[nx][ny] > height && !visited[nx][ny]) {
                    que.add(new int[]{nx, ny});
                    visited[nx][ny] = true;
                }
            }
        }
    }
}

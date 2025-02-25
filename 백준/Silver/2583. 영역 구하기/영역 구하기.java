import java.util.*;
import java.io.*;

public class Main {

    static int M;
    static int N;
    static int K;
    static int[][] graph;
    static boolean[][] visited;
    static int[] dx = {0, 1, 0, -1}; // 우, 하, 좌, 상
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken()); // 열
        N = Integer.parseInt(st.nextToken()); // 행
        K = Integer.parseInt(st.nextToken()); // 직사각형 개수
        graph = new int[N][M];
        visited = new boolean[N][M];

        // 직사각형 영역 채우기
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());

            int lx = Integer.parseInt(st.nextToken());
            int ly = Integer.parseInt(st.nextToken());
            int rx = Integer.parseInt(st.nextToken());
            int ry = Integer.parseInt(st.nextToken());

            for(int j = lx ; j < rx ; j++){
                for(int k = ly; k < ry; k++){
                    graph[j][k] = 1;
                }
            }
        }
//        System.out.println(Arrays.deepToString(graph));
        int result = 0;
        List<Integer> areaList = new ArrayList<>();
        for(int i = 0 ; i < N ; i++){
            for(int j = 0 ; j < M ; j++){
                if(graph[i][j] == 0  && !visited[i][j]){
                    areaList.add(dfs(i,j));
                    result ++;

                }
            }
        }

        Collections.sort(areaList);
        System.out.println(result);
        for(int area: areaList){
            System.out.print(area+" ");
        }


    }
    public static int dfs(int x, int y) {
        visited[x][y] = true;
        int area = 1; // 현재 영역의 크기

        for(int i = 0; i < 4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx >= 0 && nx < N && ny >= 0 && ny <  M && graph[nx][ny]== 0 && !visited[nx][ny]){
                area += dfs(nx, ny);

            }
        }
        return area;
    }
}

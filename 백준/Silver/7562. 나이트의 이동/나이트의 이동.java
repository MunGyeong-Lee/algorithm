import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

// bfs는 가장 먼저 도착한 놈에서 스톱
public class Main {

    static int N;
    static int[][] graph;
    static boolean[][] visited;
    static String[] input1;
    static String[] input2;
    static int[] dx = {-2,-1, 1, 2, 2, 1, -1, -2 };
    static int[] dy = {-1, -2, -2, -1, 1, 2, 2, 1};


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        for(int i = 0 ; i < T ; i++) {
            N = Integer.parseInt(br.readLine());
            visited = new boolean[N][N];
            String[] input1 = br.readLine().split(" ");
            String[] input2 = br.readLine().split(" ");

            int result = bfs(input1, input2 );


            if (i != 0){
                bw.write("\n");
            }


            bw.write(String.valueOf(result));

        }
        bw.flush();
        br.close();
        bw.close();

    }
    private static int bfs(String[] start , String[] finish ){
             int sr = Integer.parseInt(start[0]);
             int sc = Integer.parseInt(start[1]);
             int fr = Integer.parseInt(finish[0]);
             int fc = Integer.parseInt(finish[1]);
             // 초기화
             Queue<int[]> que = new LinkedList<>();
             que.add(new int[]{sr,sc,0});
             visited[sr][sc] = true;

             while(!que.isEmpty()){
                int[] current = que.poll();
                int cr = current[0];
                int cc = current[1];
                int cnt = current[2];

                if (cr == fr &&  cc == fc){
                    return cnt;
                }
                 // 연결 노드 탐색
                 for(int i = 0; i < 8; i++){
                     int nx = cr + dx[i];
                     int ny = cc + dy[i];

                     if(nx>=0 && nx< N && ny>=0 && ny< N && !visited[nx][ny]){
                         que.add(new int[]{nx, ny, cnt+1});
                         visited[nx][ny] = true;
                     }
                 }
             }
              return -1;
    }
}

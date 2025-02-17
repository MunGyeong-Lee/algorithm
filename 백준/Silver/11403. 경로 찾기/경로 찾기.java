import java.io.*;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());


        int[][] graph = new int[N][N];
        for(int i=0; i < N ; i++){
            String[] input = br.readLine().split(" ");
            for(int j = 0; j < N; j++) {
                graph[i][j] = Integer.parseInt(input[j]);
            }

        }

        // 플로이드-와샬
        for(int k = 0; k < N; k++){ // 경유지
            for(int i = 0; i < N ;i++){ // 출발점
                for(int j = 0; j < N ; j++){ // 도착점
                    if (graph[i][k] == 1 && graph[k][j] == 1){
                        graph[i][j] = 1;
                    }
                }
            }
        }

        for(int i = 0; i < N ;i++){
            for(int j = 0; j< N; j++){
                System.out.print(graph[i][j] + " ");
            }
            System.out.println();
        }
        
    }
}

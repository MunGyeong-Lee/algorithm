import java.io.*;
import java.util.*;


public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        int N = Integer.parseInt(br.readLine()); // 도시 개수
        int M = Integer.parseInt(br.readLine()); // 버스 개수

        int[][] route = new int[N][N]; // 비용 저장
        for(int i =0 ; i < M ; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken()); // 출발 도시
            int b = Integer.parseInt(st.nextToken()); // 도착 도시
            int c = Integer.parseInt(st.nextToken()); // 비용

            // 여러 버스 노선 중 가장 작은 비용만 저장
            if (route[a - 1][b - 1] == 0 || route[a - 1][b - 1] > c) {
                route[a - 1][b - 1] = c;
            }

        }

        int[][] result = new int[N][N];  // 출발-도착 간의 최소 비용 기록
        for(int i = 0 ; i < N ; i++){
            for(int j = 0 ; j < N ; j++){
                // i, j가 이어지지 않는 곳은 최대 값으로 설정
                result[i][j] = (route[i][j] == 0 && i != j) ? Integer.MAX_VALUE : route[i][j];
            }
        }

//        System.out.println(Arrays.deepToString(result));

        for(int k = 0; k < N; k++){
            for(int i = 0 ; i < N ; i++){
                for(int j = 0 ; j < N ; j++ ){

                    if(result[i][k] != Integer.MAX_VALUE && result[k][j] != Integer.MAX_VALUE){
                        result[i][j] = Math.min(result[i][j], result[i][k] + result[k][j]);
                    }
                }
            }
        }

        for(int i = 0 ; i < N; i++){
            for(int j = 0 ; j < N ; j++){
                if(result[i][j] == Integer.MAX_VALUE){
                    System.out.print("0");
                }else{
                    System.out.print(result[i][j]);
                }
                if(j < N-1){
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}
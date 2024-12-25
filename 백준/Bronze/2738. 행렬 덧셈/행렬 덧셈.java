import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args)  {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        int[][] A = new int[N][M];
        int[][] B = new int[N][M];
        int[][] result = new int[N][M];

        for (int i = 0 ; i < N ; i++){
            for (int j = 0 ; j < M ; j++){
                A[i][j] = sc.nextInt();
            }
        }

        for (int i = 0 ; i < N ; i++){
            for (int j = 0 ; j < M ; j++){
                B[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                result[i][j] = A[i][j] + B[i][j];
                System.out.print(result[i][j] + " "); // 같은 줄에 출력
            }
            System.out.println(); // 한 행의 출력이 끝나면 줄바꿈
        }
        
        sc.close();


    }
}

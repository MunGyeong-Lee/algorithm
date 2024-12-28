import java.io.IOException;
import java.util.Scanner;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        char[][] board = new char[N][M];
        for(int i =0; i < N; i++){
            board[i] = br.readLine().toCharArray();
        }


        int minResult = Integer.MAX_VALUE;
       // 8*8 배열만들기
        for(int i = 0; i <= N - 8 ; i++){
            for(int j = 0; j <= M - 8; j++){

                int changeWhite = 0;
                int changeBlack = 0;

                for(int x = 0; x < 8; x++){
                    for(int y = 0; y < 8; y++){
                        char expectedColor = ((x+y)%2 == 0)? 'W': 'B';

                        // 흰색부터 칠하는 경우: expectedColor = W 이고 실제는 B 인경우
                        if(board[i+x][j+y] != expectedColor){
                            changeWhite++;
                        }

                        // 검정부터 칠하는 경우:  expectedColor = B 이고 실제는 W 인경우
                        // 이전에 char expectedColor가 W 였으면 B로 검사하기
                        expectedColor = (expectedColor == 'W') ? 'B' : 'W';
                        if(board[i+x][j+y] != expectedColor){
                            changeBlack++;
                        }
                    }
                }
                // 두 경우 적게 칠해야하는 칸 수 선택
                int currentMin = Math.min(changeBlack, changeWhite);
                minResult = Math.min(minResult, currentMin);


            }
        }

        bw.write(String.valueOf(minResult));

        bw.flush();
        br.close();
        bw.close();

    }
}

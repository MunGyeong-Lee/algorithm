import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // 1~N까지 바구니 배열
        int[] basket = new int[N];

        for(int i = 0; i < M;i++){
            st = new StringTokenizer(br.readLine());
            int iIndex = Integer.parseInt(st.nextToken())-1;
            int jIndex = Integer.parseInt(st.nextToken())-1;
            int ball = Integer.parseInt(st.nextToken());

            for(int j = iIndex; j<=jIndex;j++){
                basket[j] = ball;
            }
        }

        // 바구니 속 공 출력
        for(int i = 0; i < N; i++){
            if(i!=0){
                bw.write(" ");
            }
            bw.write(String.valueOf(basket[i]));
        }

        bw.flush();
        br.close();
        bw.close();


    }
}


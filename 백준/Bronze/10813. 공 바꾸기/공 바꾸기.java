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

        int[] basket = new int[N];
        for(int ball = 0; ball<N;ball++){
            basket[ball] = ball+1;
        }
        for(int a = 0; a < M; a++ ){
            st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken())-1;
            int j = Integer.parseInt(st.nextToken())-1;

            int bi = basket[i];
            int bj = basket[j];
            basket[i] = bj;
            basket[j] = bi;
        }

        for(int index = 0; index < N; index++){
            if(index!=0){
                bw.write(" ");
            }
            bw.write(String.valueOf(basket[index]));
        }

        bw.flush();
        br.close();
        bw.close();
    }
}


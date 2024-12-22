import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] NandM = br.readLine().split(" ");
        int N = Integer.parseInt(NandM[0]);
        int M = Integer.parseInt(NandM[1]);

        // 1~N까지 바구니 배열
        int[] basket = new int[N];
        //
        for (int a = 0; a < M; a++){
            String[] inputArray = br.readLine().split(" ");

            int j = Integer.parseInt(inputArray[1])-1;
            int k = Integer.parseInt(inputArray[2]);

            for (int i = Integer.parseInt(inputArray[0]) - 1; i<=j; i++){
                basket[i] = k;
            }
        }

        for(int i = 0; i<basket.length; i++){
            if(i > 0)bw.write(" ");
            bw.write(Integer.toString(basket[i]));
        }

        bw.flush();
        br.close();
        bw.close();


    }
}


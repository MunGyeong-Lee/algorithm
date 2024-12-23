
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        String[] inputArr = br.readLine().split("");

        int sum = 0;
        for(String num : inputArr){
            sum+= Integer.parseInt(num);
        }

        bw.write(String.valueOf(sum));

        bw.flush();
        br.close();
        bw.close();
    }
}


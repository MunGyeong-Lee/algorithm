
import java.io.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split("");
        int i = Integer.parseInt(br.readLine())-1;
        bw.write(input[i]);

        bw.flush();
        br.close();
        bw.close();

    }
}


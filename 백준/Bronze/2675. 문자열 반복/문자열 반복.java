
import java.io.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        for(int test = 1; test <=T;test++){
            String[] input = br.readLine().split(" ");

            int R = Integer.parseInt(input[0]);
            String S = input[1];

            String result = "";
            for(int i = 0 ; i < S.length(); i++){
                for (int j = 0 ; j < R ; j++){
                 result += S.charAt(i);
                }
            }
            bw.write(result+"\n");
        }

        bw.flush();
        br.close();
        bw.close();
    }
}



import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 문자열 앞 뒤 공백 제거
        String input = br.readLine().trim();

        // 공백만 입력된 경우 철
        if(input.isEmpty()){
            bw.write("0");
        } else{
            String[] words = input.split(" ");
            bw.write(String.valueOf(words.length));
        }
        bw.flush();
        br.close();
        bw.close();
    }
}


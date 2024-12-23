
import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String S = br.readLine();

        Map<Character, Integer> alpha = new HashMap<>();

        for (int i = 0 ; i < S.length(); i++){
            char c = S.charAt(i);
            // 이미 등장한 앏파벳은 무시하기
            if(!alpha.containsKey(c)){
                alpha.put(c,i);
            }
        }

        // 알파벳 a-z에 대해 순서대로 첫 번째 등장 위치 출력
        for(char c = 'a'; c<='z'; c++){
            if(c!='a'){
                bw.write(" ");
            }
            if(alpha.containsKey(c)){
                bw.write(String.valueOf(alpha.get(c)));
            } else{
                bw.write("-1");
            }
        }
        bw.flush();
        br.close();
        bw.close();
    }
}


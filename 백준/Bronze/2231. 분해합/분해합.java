import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String N = br.readLine();
        int Num_N = Integer.parseInt(N);

        ArrayList<Integer> resultList = new ArrayList<>();
        for(int start = Math.max(1, Num_N-(N.length()*9)); start <Num_N; start++){
            int sum = start;
            String subStart = String.valueOf(start);
            for(int i = 0; i < subStart.length(); i++){
                sum+=Integer.parseInt(String.valueOf(subStart.charAt(i)));

            }
            if (sum == Num_N){
                resultList.add(start);
            }
        }
        if(resultList.size() > 0){
            int result = Collections.min(resultList);
            bw.write(String.valueOf(result));
        } else{
            bw.write("0");
        }

        bw.flush();
        br.close();
        bw.close();
    }
}

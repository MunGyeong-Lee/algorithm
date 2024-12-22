import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        String[] inputArray = br.readLine().split(" ");

        int max = Integer.parseInt(inputArray[0]);
        int min = Integer.parseInt(inputArray[0]);

        for(String num : inputArray){
            // 최대값 찾기
            if (Integer.parseInt(num) > max ){
                max = Integer.parseInt(num);
            }

            // 최소값 찾기
            if (Integer.parseInt(num) < min ){
                min = Integer.parseInt(num);
            }
        }

        bw.write(min+" "+max);

        bw.flush();
        br.close();
        bw.close();
    }
}

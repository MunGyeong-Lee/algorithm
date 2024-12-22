import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
     BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
     BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


     String[] NandX = br.readLine().split(" ");
     String[] inputArray = br.readLine().split(" ");
     int N = Integer.parseInt(NandX[0]);
     int X = Integer.parseInt(NandX[1]);


     boolean first = true; // 첫번째 출력 여부를 확인하는 변수
     for(String num : inputArray){
         if(Integer.parseInt(num) < X) {

             if(!first){
                 bw.write(" ");  // 첫 번째 숫자가 아닌 경우 공백 추가
             }
             bw.write(num);
             first = false;

         }
     }
     bw.flush();
     br.close();
     bw.close();
    }
}

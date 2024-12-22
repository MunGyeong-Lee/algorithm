import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
     BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
     BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


     String[] NandX = br.readLine().split(" ");
     String[] inputArray = br.readLine().split(" ");
     int N = Integer.parseInt(NandX[0]);
     int X = Integer.parseInt(NandX[1]);


     StringBuilder result = new StringBuilder();
     for(String num : inputArray){
         if(Integer.parseInt(num) < X) {
             if(result.length()>0){
                 result.append(" ");
             }
             result.append(num);
         }
     }
     bw.write(result.toString());
     
     bw.flush();
     br.close();
     bw.close();
    }
}

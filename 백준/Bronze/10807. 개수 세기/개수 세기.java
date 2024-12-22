import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

      int N = Integer.parseInt(br.readLine());
      String[] inputArray = br.readLine().split(" ");
      int V = Integer.parseInt(br.readLine());

      int count = 0;

      for (String s : inputArray){
          if(Integer.parseInt(s) == V){
              count++;
          }
      }

      bw.write(String.valueOf(count));

      bw.flush();
      br.close();
      bw.close();

    }
}

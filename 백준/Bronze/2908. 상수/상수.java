
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        String A = input[0];
        String B = input[1];

        String reverseA = new StringBuilder(A).reverse().toString();
        String reverseB = new StringBuilder(B).reverse().toString();

        int intA = Integer.parseInt(reverseA);
        int intB = Integer.parseInt(reverseB);

        bw.write(String.valueOf(Math.max(intA, intB)));
        
        bw.flush();
        br.close();
        bw.close();
        
    }
}
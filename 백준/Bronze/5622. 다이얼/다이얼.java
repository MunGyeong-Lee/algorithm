
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] word = br.readLine().split("");
        String[] alpha = {"","","ABC","DEF","GHI","JKL","MNO","PQRS","TUV","WXYZ"};

        int sum = 0;
        for(String w : word){
            for(int i = 0; i<alpha.length;i++){
                if(alpha[i].contains(w)){
                    sum+=i+1;
                }
            }
        }

        bw.write(String.valueOf(sum));
        bw.flush();
        br.close();
        bw.close();

    }
}


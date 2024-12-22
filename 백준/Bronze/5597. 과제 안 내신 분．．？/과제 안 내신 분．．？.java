import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] students = new int[30];

        for(int i = 0; i<28;i++){
            int num = Integer.parseInt(br.readLine())-1;
            students[num] = 1;
        }
        int count = 0;
        for(int j = 0; j < 30; j++){
            if(students[j] == 0){

                if (count==0){
                    bw.write((j+1)+ "\n");

                } else{
                    bw.write((j+1)+ "");
                }
                count++;

            }

        }

        bw.flush();
        br.close();
        bw.close();

    }
}


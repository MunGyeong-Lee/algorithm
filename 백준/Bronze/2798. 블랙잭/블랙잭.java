import java.io.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        String[] cards = br.readLine().split(" ");
        int  N = Integer.parseInt(input[0]);
        int  M = Integer.parseInt(input[1]);


        ArrayList<Integer> sumList = new ArrayList<>();
        for(int first = 0; first <N-2; first++){
            for(int second = first+1; second < N-1; second++){
                for(int third = second+1; third < N; third++){
                    sumList.add(Integer.parseInt(cards[first])+Integer.parseInt(cards[second])+Integer.parseInt(cards[third]));
                }
            }
        }
        int result = 0;
        for(int sum : sumList){
            if(sum <= M && result<= sum){
                result = sum;
            }
        }

        bw.write(String.valueOf(result));

        bw.flush();
        br.close();
        bw.close();
    }
}




import java.io.*;
import java.util.ArrayList;

public class Main {

    static int N;
    static int M;
    static ArrayList<Integer> arr = new ArrayList<>() ;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);


        backTrack(0);
        System.out.println(sb.toString());

    }

    private static void backTrack(int depth){
        // 기저조건
        if(depth == M){
            // 출력 리스트에 추가
            for(int num : arr){
                sb.append(num).append(' ');
            }
            sb.append('\n');
            return;
        }

        // arr 수열에 숫자 추가하기
        for(int i = 1 ; i <=N ; i++){

                arr.add(i);
                backTrack(depth+1);
                arr.remove(arr.size()-1);

//            visited[i]=
        }

    }
}

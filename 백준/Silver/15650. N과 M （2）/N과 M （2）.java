import java.io.*;
import java.util.ArrayList;

public class Main {

    static int N, M;
    static ArrayList<Integer>numbers = new ArrayList<>();
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");

        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        visited = new boolean[N+1];
        backtrack(0);

        System.out.println(sb);

    }
    private static void backtrack (int depth){
        // 기저조건
        if(depth == M){
             //출력리스트에 추가
            for(int num : numbers){
                sb.append(num).append(' ');
            }
            sb.append('\n');
            return;
        }

        // 구현
        for(int i = 1 ; i <= N; i++){
            // 현재 배열에 아무 것도 없거나 마지막 숫자보다 현재 숫자가 더 크고
            if(numbers.size() == 0 || numbers.get(numbers.size()-1) < i ){
                //방문한 적 없으면 넣기
                if(!visited[i]){
                    numbers.add(i);
                    visited[i] = true;
                    backtrack(depth+1);
                    numbers.remove(numbers.size()-1);
                    visited[i] = false;
                }
            }
        }
    }
}

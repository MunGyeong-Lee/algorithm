import java.io.*;
import java.util.ArrayList;

public class Main {
    static int N, M;
    static boolean[] visited;
    static ArrayList<Integer> numbers = new ArrayList<>();
    static StringBuilder  sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력 받기
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);

        visited = new boolean[N + 1]; // 1부터 N까지 사용

        backtrack(0);

        System.out.println(sb);
    }

    private static void backtrack(int depth) throws IOException {
        // M개의 숫자를 모두 선택한 경우
        if (depth == M) {
        for(int num : numbers){
            sb.append(num).append(' ');
        }
       sb.append('\n');
        return;
    }

        // 1부터 N까지 숫자를 선택
        for (int i = 1; i <= N; i++) {
            if (!visited[i]) { // 방문하지 않은 숫자만 선택
                visited[i] = true;
                numbers.add(i); // ArrayList에 숫자를 추가
                backtrack(depth + 1); // 다음 숫자를 선택
                numbers.remove(numbers.size() - 1); // 백트래킹 - 마지막 숫자를 제거
                visited[i] = false; // 방문 상태를 초기화
            }
        }
    }
}

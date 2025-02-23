import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder(); // 출력 성능 개선

        int N = Integer.parseInt(br.readLine()); // int로 변경 (Long 필요 없음)
        String[] inputA = br.readLine().split(" ");
        Set<Integer> set = new HashSet<>(); // HashSet 사용

        for (String num : inputA) {
            set.add(Integer.parseInt(num));
        }

        int M = Integer.parseInt(br.readLine());
        String[] inputB = br.readLine().split(" ");

        for (String findNum : inputB) {
            if (set.contains(Integer.parseInt(findNum))) {
                sb.append("1\n");
            } else {
                sb.append("0\n");
            }
        }

        System.out.print(sb.toString()); // 한 번에 출력하여 성능 최적화
    }
}

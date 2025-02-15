import java.io.*;
import java.util.*;

public class Main {
    static int M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        ArrayList<Integer> trees = new ArrayList<>();
        st = new StringTokenizer(br.readLine());

        int maxTree = 0;
        for (int i = 0; i < N; i++) {
            int height = Integer.parseInt(st.nextToken());
            trees.add(height);
            maxTree = Math.max(maxTree, height);
        }

        // 이진 탐색 실행
        System.out.println(findMethod(0, maxTree, trees));
    }

    private static int findMethod(int start, int end, ArrayList<Integer> trees) {
        int nextStart = start;
        int nextEnd = end;

        while (nextStart <= nextEnd) {
            int middle = (nextStart + nextEnd) / 2;
            long result = 0; // 나무의 합을 저장할 변수 (long 사용 필수!)

            // 나무를 잘라서 총 몇 미터를 얻을 수 있는지 계산
            for (int tree : trees) {
                if (tree > middle) {
                    result += (tree - middle);
                }
            }

            if (result >= M) {  // 필요한 만큼 나무를 얻었으면 더 높은 절단기 가능
                nextStart = middle + 1;
            } else {  // 필요한 나무보다 적으면 절단기 높이를 낮춰야 함
                nextEnd = middle - 1;
            }
        }

        return nextEnd;  // 최적의 절단기 높이 반환
    }
}

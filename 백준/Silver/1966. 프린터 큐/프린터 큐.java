import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String inputA = br.readLine();
        int N = Integer.parseInt(inputA);

        for(int i = 0; i < N; i++){
            String[] inputB = br.readLine().split(" ");
            int numDocs = Integer.parseInt(inputB[0]); // 문서의 개수
            int targetIndex = Integer.parseInt(inputB[1]); // 찾고자하는 숫자의 위치

            String[] inputC = br.readLine().split(" ");

            Queue<int[]> queue = new LinkedList<>(); // (문서의 위치, 중요도) 저장
            PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());// 중요도 정렬
            for(int j = 0; j < numDocs; j++){
                int priority = Integer.parseInt(inputC[j]);
                queue.offer(new int[]{j, priority}); // (문서의 위치, 중요도);
                priorityQueue.offer(priority);
            }

            int printOrder = 0; // 출력 순서 카운트

            while(!queue.isEmpty()){
                int[] current = queue.poll(); // 현재 문서(문서의 위치, 중요도)

                // 현재의 문서보다 높은 중요도의 문서가 있다면 뒤로 보냄
                if(current[1] < priorityQueue.peek()){
                    queue.offer(current);
                } else{
                    printOrder ++;
                    priorityQueue.poll(); // 가장 높은 중요도 제거
                    // 찾고자하는 숫자의 위치의 숫자가 출력되었다면, 출력 순서 반환
                    if(current[0] == targetIndex){
                        System.out.println(printOrder);
                        break;
                    }
                }
            }
        }
    }
}


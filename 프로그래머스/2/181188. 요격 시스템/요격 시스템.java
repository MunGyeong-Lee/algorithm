import java.util.Arrays;

class Solution {
   public int solution(int[][] targets) {
       // 끝점 기준으로 오름차순 정렬
       Arrays.sort(targets, (a, b) -> a[1] - b[1]);
       
       int answer = 0;
       int lastShot = Integer.MIN_VALUE; // 마지막으로 요격 미사일을 발사한 x 좌표
       
       for (int[] target : targets) {
           int start = target[0];
           int end = target[1];
           
           // 현재 구간이 이전 요격 미사일로 커버되지 않는 경우
           if (lastShot <= start) {
               answer++;
               // 현재 구간의 끝점 바로 앞에서 요격 (개구간이므로 end는 포함 안됨)
               lastShot = end;
           }
       }
       
       return answer;
   }
}
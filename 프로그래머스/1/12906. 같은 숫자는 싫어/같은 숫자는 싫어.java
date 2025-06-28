import java.util.*;

public class Solution {
    public int[] solution(int[] arr) {
        // ArrayList를 사용하여 동적으로 결과를 저장
        ArrayList<Integer> result = new ArrayList<>();
        
        // 첫 번째 원소는 항상 추가
        result.add(arr[0]);
        
        // 두 번째 원소부터 비교 시작
        for (int i = 1; i < arr.length; i++) {
            // 현재 원소가 이전 원소와 다르면 추가
            if (arr[i] != arr[i - 1]) {
                result.add(arr[i]);
            }
        }
        
        // ArrayList를 배열로 변환
        int[] answer = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }
        
        return answer;
    
    }
}
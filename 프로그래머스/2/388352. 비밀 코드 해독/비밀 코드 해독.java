import java.util.*;

class Solution {
    public int solution(int n, int[][] q, int[] ans) {
        int answer = 0;
        
        // 1부터 n까지의 숫자 중에서 5개를 선택하는 모든 조합을 생성
        List<int[]> combinations = new ArrayList<>();
        generateCombinations(n, 5, 1, new ArrayList<>(), combinations);
        
        // 각 조합이 모든 쿼리 조건을 만족하는지 확인
        for (int[] combination : combinations) {
            boolean isValid = true;
            
            // 모든 쿼리에 대해 검증
            for (int i = 0; i < q.length; i++) {
                int matchCount = countMatches(combination, q[i]);
                if (matchCount != ans[i]) {
                    isValid = false;
                    break;
                }
            }
            
            if (isValid) {
                answer++;
            }
        }
        
        return answer;
    }
    
    // 조합 생성 (백트래킹)
    private void generateCombinations(int n, int k, int start, List<Integer> current, List<int[]> combinations) {
        // k개를 모두 선택했으면 조합 완성
        if (current.size() == k) {
            int[] combination = new int[k];
            for (int i = 0; i < k; i++) {
                combination[i] = current.get(i);
            }
            combinations.add(combination);
            return;
        }
        
        // start부터 n까지 숫자를 선택
        for (int i = start; i <= n; i++) {
            current.add(i);
            generateCombinations(n, k, i + 1, current, combinations);
            current.remove(current.size() - 1);
        }
    }
    
    // 두 배열에서 일치하는 원소의 개수를 세는 함수
    private int countMatches(int[] secretCode, int[] query) {
        Set<Integer> secretSet = new HashSet<>();
        for (int num : secretCode) {
            secretSet.add(num);
        }
        
        int count = 0;
        for (int num : query) {
            if (secretSet.contains(num)) {
                count++;
            }
        }
        
        return count;
    }
}
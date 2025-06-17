import java.util.*;

class Solution {
    List<Integer> index;
    int count;
    char[] spell = {'A', 'E', 'I', 'O', 'U'};
    int answer;
    
    public int solution(String word) {
        answer = 0;
        count = 0;
        index = new ArrayList<>();
        permutation(0, word);
        return answer;
    }
    
    public void permutation(int len, String target) { 
        // 현재 만든 단어를 체크 (길이가 1 이상일 때)
        if (len > 0) {
            count++;
            String nowWord = "";
            for(int i : index) {
                nowWord += spell[i];
            }
            if(nowWord.equals(target)) {
                answer = count;
                return;
            }
        }
        
        // 길이가 5 이상이면 더 이상 확장하지 않음
        if(len >= 5) {
            return;
        }
        
        // 답을 찾았으면 더 이상 탐색하지 않음
        if(answer > 0) {
            return;
        }
        
        // 각 모음에 대해 재귀 호출
        for(int i = 0; i < 5; i++) {
            index.add(i);
            permutation(len + 1, target);
            index.remove(index.size() - 1); 
            
            // 답을 찾았으면 조기 종료
            if(answer > 0) {
                return;
            }
        }
    }
    
   
    
}

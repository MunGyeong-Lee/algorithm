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
        permutation(0, word); // 현재 단어 길이, 찾고자 하는 단어
        return answer;


    }
    public void permutation(int len, String target){ 
        // 기저조건
        // 타겟 단어와 길이가 같으면
        // 인덱스를 가지고 단어를 만든 다음, 타겟 단어와 현재 단어가 같은지 비교
        if(len >0){
            String nowWord = "";
            for(int i : index){
                nowWord += spell[i];
            }
            if(nowWord.equals(target)){
                answer = count;
                return;
            }
        }
        
        // 메인 
        // 현재 단어 길이가 5이상이 되면 재귀 호출 하면 안됨
        if(len >= 5){
            return ;
        }

        
        for(int i = 0 ; i < 5 ; i ++){
            index.add(i);
            count ++;
            permutation(len+1, target);
            
            // 답을 찾았으면 조기 종료
            if(answer > 0) {
                return;
            }
            
            index.remove(index.size()-1);  // 재귀호출에서돌아오면 맨뒤 빼기
            

        }
    }
}

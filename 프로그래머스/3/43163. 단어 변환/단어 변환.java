import java.util.*;
import java.io.*;

class Solution {
    
    private boolean visited[];
    
    public int solution(String begin, String target, String[] words) {
        
        // bfs로 풀기
        // 알파벳 하나 차이가 나는 단어를 찾기 -> queue 에 넣기
        // 제일 먼저 target에 도착하면 멈추고 그 숫자를 출력
        // queue에는 (카운트, 단어)형태로 저장
        
        List<String> wordList = new ArrayList<>(Arrays.asList(words));
        wordList.add(begin);
        
        int answer = bfs(begin, target, wordList);
        return answer;
    }
    
    private int bfs(String begin, String target, List<String> wordList){
        
        // que, visited 만들기
        Queue<Object[]> que = new LinkedList <>();
        que.offer(new Object[]{0, begin});
        visited = new boolean[wordList.size()];
        visited[wordList.size()-1] = true;
        
        while(!que.isEmpty()){
            
            Object[] now = que.poll();
            String nowString = (String) now[1];
            
            if(nowString.equals(target)) {
                return  (Integer) now[0];
            }
            
            for(int i = 0 ; i < wordList.size(); i++){
                String word = wordList.get(i);
                if(!visited[i] && isOneCharDifferent(nowString,word)){
                    visited[i] = true;
                    que.offer(new Object[]{ (Integer) now[0]+1, word});
                }
            }
        }
        return 0;
    }
    
    
    
     private boolean isOneCharDifferent(String str1, String str2){
     // 길이가 다르면 false
     if(str1.length() != str2.length()){
         return false;
     }
     int diffCount = 0;
     for(int i = 0; i < str1.length(); i++){
         if(str1.charAt(i) != str2.charAt(i)){
             diffCount++;
             if(diffCount >1){
                 return false; // 2개 이상 다르면 false
             }
         }
     }
    return diffCount == 1; 
  }
}
    
    

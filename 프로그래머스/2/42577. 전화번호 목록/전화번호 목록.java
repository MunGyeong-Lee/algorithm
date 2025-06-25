import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        
        // 해시맵에 모든 전화번호 저장
       HashMap<String, Boolean> map = new HashMap<>();
       for (String phone : phone_book) {
           map.put(phone, true);
       }
       
       // 각 전화번호에 대해 접두어 검사
       for (String phone : phone_book) {
           // 현재 번호의 모든 접두어들을 확인
           for (int i = 1; i < phone.length(); i++) {
               String prefix = phone.substring(0, i);
               if (map.containsKey(prefix)) {
                   return false; // 접두어 관계 발견
               }
           }
       }
       
       return true;
   
    }
}
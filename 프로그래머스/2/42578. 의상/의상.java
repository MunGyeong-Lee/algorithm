import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        // 의상 종류별로 개수를 세기 위한 HashMap
        HashMap<String, Integer> clothesMap = new HashMap<>();
        
        // 각 의상 종류별로 개수 카운트
        for (String[] cloth : clothes) {
            String type = cloth[1]; // 의상의 종류
            clothesMap.put(type, clothesMap.getOrDefault(type, 0) + 1);
        }
        
        int answer = 1;
        
        // 각 의상 종류별로 (개수 + 1)을 곱함
        // +1은 해당 종류를 착용하지 않는 경우를 포함
        for (int count : clothesMap.values()) {
            answer *= (count + 1);
        }
        
        // 모든 의상을 착용하지 않는 경우(알몸인 경우) 1가지를 제외
        return answer - 1;
    }
}
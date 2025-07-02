import java.util.*;
class Solution {
    
     Set<Integer> numberSet = new HashSet<>();

    public int solution(String numbers) {

        
        
        // 1. 부분 집합 구하기
        boolean[] visited = new boolean[numbers.length()]; 
        powerset(numbers, "", visited);
        
        for(int num: numberSet){
            System.out.println(num);
        }
        
        // 2. 집합을 가지고 소수인지 검증
        int answer = 0;
        for(int num : numberSet){
            if(isPrime(num)){
                answer++;
            }
        }
        
        
        return answer;
        
    }
    
    
    public void powerset(String numbers, String current, boolean[] visited){
        
        // 현재 문자열이 비어있지 않으면 숫자로 변환해서 추가
        if(!current.isEmpty() && !current.equals("0")){
            int num = Integer.parseInt(current);
            numberSet.add(num);
        }
        
        for(int i = 0 ; i < numbers.length(); i++){
            if(!visited[i]){
                visited[i] = true;
                powerset(numbers, current + numbers.charAt(i), visited);
                visited[i] = false;
            }
        }

    }
    
    public boolean isPrime(int num){
        
        if(num < 2) return false;
        if(num == 2) return true;
        if(num % 2 == 0) return false;
        
        for(int i = 3; i * i <= num ; i+=2){
            if(num % i == 0){
                return false;
            }
        }
        System.out.println(num);
        return true;
    }
    
    
    
}
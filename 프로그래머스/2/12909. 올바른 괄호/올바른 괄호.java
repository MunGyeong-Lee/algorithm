import java.util.*;
class Solution {
    boolean solution(String s) {
        
        Stack<Character> stack = new Stack<>();
        boolean answer = true;

        for(int i = 0 ; i < s.length(); i++){
            
            // 1.스택이 비어있는데 ) 이거면 false
            char now = s.charAt(i);
            if(stack.isEmpty() && now == ')'){
                answer = false;
                // System.out.println(i + ": 1번");
                stack.push(now);
                break;
            }
            
            // 2. 스택에 아무것도 없으면 일단 넣고 다음 차례로 건너가기
            if(stack.isEmpty()){
                stack.push(s.charAt(i));
                continue;
            }
            
            // 3. 스택 맨 위의 괄호와 현재 괄호가 짝이 맞으면 pop
            char top = stack.pop();
            if( top == '('&& now == ')'){
                continue;
            } else{
                stack.push(top);
                stack.push(now);
            }
            
        }
        
        if(!stack.isEmpty()){
            answer = false;
            // System.out.println("마지막 번");
        }
        
        
        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        // System.out.println("Hello Java");
        
        

        return answer;
    }
}
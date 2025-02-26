
import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[]args) throws IOException{
        
        //  L 스택 : 왼쪽부터 커서까지 문자열을 순서대로 저장
        //  R 스택 : 왼쪽 방향으로 커서 이동 때 발생한 문자열을 저장 
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        
        for(int i=0; i < N ; i++){
            String[] input = br.readLine().split("");
            
            Stack<Character> LStack = new Stack<>();
            Stack<Character> RStack = new Stack<>();
            
            // <: L 스택의 마지막 글자를 R스택으로 이동
            // >: R 스택의 마지막 글자를 L로 이동
            // -: 마지막 글자를 POP
            
            for(int j = 0; j < input.length; j++ ){
                
                char c = input[j].charAt(0);
                
                if(c == '<' && !LStack.isEmpty() ){
                    char popStr = LStack.pop();
                    RStack.push(popStr);
                }
                else if(c == '>'&& !RStack.isEmpty() ){
                    char popStr = RStack.pop();
                    LStack.push(popStr);
                }
                else if(c == '-' && !LStack.isEmpty() ){
                    LStack.pop();
                }
                else if ( c != '<' && c!= '>' && c!='-'){
                    LStack.push(c);
                    
                }
                
            }
            
            
            StringBuilder result = new StringBuilder();
            for(char s : LStack){
                result.append(s);
            }
            
            while(!RStack.isEmpty()){
                result.append(RStack.pop());
            }
            
            System.out.println(result.toString());
    
        }
        
        
        
        
    }
}
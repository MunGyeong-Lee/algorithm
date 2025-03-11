import java.util.*;
import java.io.*;

public class Main {
    
    static int L, C;
    static List<Character> alpha;
    static StringBuilder sb = new StringBuilder(); // 완성 암호 배열열
    static List<Character> result = new ArrayList<>(); // 암호배열
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        L = Integer.parseInt(st.nextToken()); // 암호 길이
        C = Integer.parseInt(st.nextToken()); // 주어진 글자 수
        
        st = new StringTokenizer(br.readLine());
        alpha = new ArrayList<>(); 
        for(int i = 0 ; i < C; i++){
            alpha.add(st.nextToken().charAt(0));
        }
        
        Collections.sort(alpha); // 오름차순정렬 -> 암호가 오름차순이어야함
        
        
        backtrack(0) ;
        System.out.println(sb);
        
        
    }
    public static void backtrack(int start){
        
        // 기저조건
        // 배열이 4개 여야함
        if(result.size() == L){
            // 모음 a,e,i,o가 최소 1개/ 자음이 최소 2개 있어야함
            if(isValidPassword()){
                for(char c : result){
                    sb.append(c);
                }
                sb.append('\n');
            }
            return;
        }
            
        
        // 구현
        for(int i = start ; i <C ; i++){
            result.add(alpha.get(i));
            backtrack(i+1);
            result.remove(result.size()-1);
        }
        
    }
    // 모음 a,e,i,o가 최소 1개/ 자음이 최소 2개 검증
    public static boolean isValidPassword(){
        int vowels = 0 , consonants = 0;
        for(char c : result){
            if("aeiou".indexOf(c)>= 0) vowels++;
            else consonants++;
        }
        return vowels >= 1 && consonants >=2;
    }

    
    
}
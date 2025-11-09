import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
       
        int n = Integer.parseInt(st.nextToken()); // 문자열 개수
        int m = Integer.parseInt(st.nextToken()); // 검사해야할 문자열

        Set<String> stringSet = new HashSet<>(); // 문자열 집합
        for(int i = 0; i < n ; i++){
            st = new StringTokenizer(br.readLine());
            String word = st.nextToken();
            stringSet.add(word);
        }
        
        int result = 0;
        for(int i = 0 ; i < m ; i++){
            st = new StringTokenizer(br.readLine());
            String currentWord = st.nextToken();
            
            if(stringSet.contains(currentWord)){
                result ++;
            }
        }
        
        System.out.println(result);
        
    }
}
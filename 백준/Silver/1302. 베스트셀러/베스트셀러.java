import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int max = 0;
        String result = null;
        
        Map<String, Integer> rank = new HashMap<>();
        for(int i = 0 ; i < n ; i++){
            String book = new StringTokenizer(br.readLine()).nextToken();
            rank.put(book, rank.getOrDefault(book, 0) + 1);
            int value = rank.get(book);
            if(value > max){
                max = value;
                result = book;
            } else if (value == max){
                if(result.compareTo(book) > 0){
                    result = book;
                }
            }
            
        }
        
        System.out.println(result);
        
    }
}
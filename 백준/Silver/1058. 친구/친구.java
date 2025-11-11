import java.util.*;
import java.io.*;

public class Main{
    
    static int[][] graph;
    static final int INF = 1_000_000;
    public static void main(String[]args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        
        int n = Integer.parseInt(str);
        graph = new int[n][n];
        for(int i = 0 ; i< n ; i++){
            str = br.readLine();
            for(int j = 0 ; j < n ; j++){
                if(i == j){
                    graph[i][j] = 0;
                } else if (str.charAt(j) == 'Y'){
                    graph[i][j] = 1;
                } else{
                    graph[i][j] = INF;
                }
            }
        }
        
        for(int k = 0 ; k< n ; k++){
            for(int i= 0 ; i < n ; i++){
                for(int j = 0 ; j < n  ; j++){
                    if(graph[i][j] > graph[i][k] +  graph[k][j]){
                        graph[i][j] = graph[i][k] +  graph[k][j] ;
                    }
                }
            }
        }
        
        Map<Integer, Integer> friendsCount = new HashMap<>();
        for(int i = 0 ; i < n ; i++){
            int count = 0;
            for(int j = 0 ; j < n ; j ++){
            
                if(i!=j && graph[i][j] <=2){
                    count ++;
                }
                friendsCount.put(i, count);
                
            }
        }
        
        int result = Collections.max(friendsCount.entrySet(), Map.Entry.comparingByValue()).getValue();
        
        System.out.println(result);
        
        
    }
    
}
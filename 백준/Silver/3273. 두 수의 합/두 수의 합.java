import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        
        int[] array = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i =0 ; i < N; i++){
            array[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(array);
        
        int X = Integer.parseInt(br.readLine());
        
        int start =0, end = N-1 , result =0;
        
        while(start<end){
            
            // start+end 이 x가 되면 result++
            if(array[start]+array[end] == X ){
                result++;
                start++;
                end--;
            } else if(array[start]+array[end] > X ) { // 만약 start+end 이 x보다 더 크면 end --
                end--;
            } else if(array[start]+array[end] < X ) { // 만약 start+end 이 x보다 더 작으면 start++ 
                start++;
            }
            
            
        }
        
        System.out.println(result);
        
        
        
    }
}
import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        
        int[] inputA = new int[A];
        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < A; i++){
            inputA[i] = Integer.parseInt(st.nextToken());
        }
        
        int[] inputB = new int[B];
        st= new StringTokenizer(br.readLine());
        for(int i = 0; i < B; i++){
            inputB[i] = Integer.parseInt(st.nextToken());
        }
        
        // 투포인터 초기화
        int i = 0, j = 0;
        while (i < A && j < B){
            if(inputA[i] <= inputB[j]){
                sb.append(inputA[i++]).append(' ');
            } else{
                sb.append(inputB[j++]).append(' ');
 
            }
            
        }
        
        // 남은 원소 추가하기
        while (i < A) sb.append(inputA[i++]).append(' ');
        while (j < B) sb.append(inputB[j++]).append(' ');
        
        System.out.println(sb);
        
    }
}
import java.util.*;
import java.io.*;
public class Main{
    
    static ArrayList<Integer>[] levels;
    static int[] arr;
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int k = Integer.parseInt(br.readLine());
        int n = (1<<k)-1; // 총 노드 수
        
        arr= new int[n];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < n ; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        levels = new ArrayList[k];
        for(int i =0; i < k ; i++){
            levels[i] = new ArrayList<>();
        }
        
        build(0, n-1, 0);
        
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < k ; i++){
            for(int num : levels[i]){
                sb.append(num).append(" ");
            }
            sb.append("\n");
        }
        System.out.print(sb);
        
    }
    static void build(int start, int end, int depth){
        
        if(start > end) return;
        
        int mid = (start + end) /2 ;
        levels[depth].add(arr[mid]);
        build(start, mid-1, depth+1);
        build(mid+1, end, depth+1);
        
    }
}
import java.util.*;
import java.io.*;

public class Main{
    
    static int N, M;
    static int[] nums;
    
    static List<Integer> numsResult = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(br.readLine());
        nums = new int[N];
        for(int i = 0 ; i < N ; i++){
            nums[i] = (Integer.parseInt(st.nextToken()));
        }
        
        Arrays.sort(nums);
        // System.out.println(Arrays.toString(nums));
        
        backtrack(0);
        
        System.out.println(sb);
        
        
    }
    public static void backtrack(int count){
        
        boolean[] visited = new boolean[N];
        
        // 기저조건: m개가 다 모였으면 프린트
        if(numsResult.size() == M){
            for(int num: numsResult){
                sb.append(num).append(' ');
            }
            sb.append('\n');
            return;
        }
        
        // 구현
        // 이전 visited가 다음 visited에 영향을 주지 않는다
        for(int i = 0; i < N ; i++){
            if(!visited[i]){
                numsResult.add(nums[i]);
                visited[i] = true;
                backtrack(count+1);
                numsResult.remove(numsResult.size()-1);
            }
        }
        
        
    }
}
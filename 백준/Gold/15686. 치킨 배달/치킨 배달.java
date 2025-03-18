
import java.util.*;
import java.io.*;

public class Main{
    
    static int N, M;
    static int[][] graph;
    static List<int[]>house; // 집 위치치
    static List<int[]>chicken; // 치킨 집 위치 저장
    static List<Integer> preCom = new ArrayList<>(); // 조합 저장 전 단계
    static List<List<int[]>>chickenCom = new ArrayList<>(); // 치킨집 조합
    
    
    public static void main (String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken()); // 치킨 집 최대 개수
        graph = new int[N][N];
        house = new ArrayList<>(); // 집 위치 저장
        chicken = new ArrayList<>(); // 치킨집 위치 저장
        
        for(int i = 0 ; i < N ; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < N ; j++){
                graph[i][j] = Integer.parseInt(st.nextToken());
                if(graph[i][j] == 2){
                    chicken.add(new int[]{i,j});
                } else if (graph[i][j] == 1){
                    house.add(new int[]{i,j});
                }
            }
        }
        
        
        
        
        // System.out.println(Arrays.deepToString(graph));
        // for (int[] pos : chicken) {
        //     System.out.println("치킨집 위치: (" + pos[0] + ", " + pos[1] + ")");
        // }
  
        // 2. 치킨집 조합 구하기
         combination(0);
   
         
         // 조합 출력 확인
        // for (List<int[]> comb : chickenCom) {
        //     System.out.println("조합:");
        //     for (int[] pos : comb) {
        //         System.out.println(Arrays.toString(pos));
        //     }
        //     System.out.println("------");
        // }
         
        
        // 3. 치킨집 조합 마다 치킨거리 값 구하기 >> 최소값 갱신
        int result = Integer.MAX_VALUE;
        for(List<int[]> comb: chickenCom){
            result = Math.min(result, chickenStreet(comb));
        }
        
        System.out.println(result);
        
        
    }
    // 치킨 거리 구하기
    public static int chickenStreet(List<int[]> selectedChicken ){
        int totalDist = 0  ;
        for(int[] h:house){
            int minDist = Integer.MAX_VALUE;
            
            for(int[] c: selectedChicken){
                int dist = Math.abs(h[0]-c[0])+Math.abs(h[1]-c[1]);
                minDist = Math.min(minDist, dist);
            }
            totalDist += minDist;
        }
        return totalDist;
    }
    
    // 조합구하기
    public static void combination (int start){
        
        // 기저조건 
        if(!preCom.isEmpty() && preCom.size() <= M){
            List<int[]> selected = new ArrayList<>();
            for(int num : preCom){
                selected.add(chicken.get(num));
            }
            chickenCom.add(selected);
        }
        
        // 구현
        for(int i= start ; i < chicken.size(); i++){
            
            preCom.add(i);
            combination(i+1);
            preCom.remove(preCom.size()-1);
                
        }
        
        
    }
    
    
}
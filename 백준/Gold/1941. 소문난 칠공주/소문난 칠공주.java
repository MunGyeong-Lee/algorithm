
import java.util.*;
import java.io.*;


public class Main{
    
    static String[][] graph;
    static List<int[]> listA;   // 조합 만들기 전 셋팅
    static List<Integer> preCom;  // 조합 경우
    static List<List<int[]>> resultCom; // 조합 배열 완성
    
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};
    
    public static void main(String[] args)throws IOException{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            
            
            int N = 5; // 격자 크기 n*n
            graph = new String[N][N];
            
            for(int i = 0 ; i < N ; i++){
                String line = br.readLine(); // 공백이 없음
                for(int j = 0 ; j < N; j++){
                    graph[i][j] = String.valueOf(line.charAt(j));// 한 글자씩 저장
                }
            }
            
            // System.out.println(Arrays.deepToString(graph));
            
            listA = new ArrayList<>();   // 조합 만들기 전 셋팅
            preCom = new ArrayList<>();  // 조합 경우
            resultCom = new ArrayList<>(); // 조합 배열 완성
            
            for(int i = 0 ; i < N ; i++){
                for(int j = 0 ; j<N; j++){
                    listA.add(new int[] {i,j});
                }
            }

            // 7명 조합 구하기
            combination(0);
            
            // 7명 조합 중 가능한 조합 찾기
            int result = 0 ;
            for(List<int[]> seven : resultCom){
                if(isSevenPrincess(seven)){
                    result += 1;
                }
            }
            
          System.out.println(result);  
            
    }
    
    // 7명 조합 중 가능한 조합 찾기
    public static boolean isSevenPrincess(List<int[]> seven){
        // 초기화
        Queue<int[]> que = new LinkedList<>();
        que.offer(seven.get(0));
        
        boolean[] visited = new boolean[7];
        visited[0] = true;
        
        int connected = 1 ; // 연결 숫자
        int sCount = 0 ; // 'S' 수 세기
        
        
        // BFS
        while(!que.isEmpty()){
            int[] student = que.poll();
            
            //'S' 인지 확인 하고 S count 하기 
            if(graph[student[0]][student[1]].charAt(0) == 'S'){
                sCount ++;
            }
            
            
            for(int i = 0 ; i < 4 ; i++){
                int nextX = student[0] + dx[i];
                int nextY = student[1] + dy[i];
                
                for(int j = 0 ; j < 7 ; j++){
                    // 다음 학생이 seven 조합 안에 있는지 확인 + 방문아직 안해야함
                    if(!visited[j] && seven.get(j)[0] == nextX && seven.get(j)[1] == nextY){
                        visited[j] = true;
                        que.offer(seven.get(j));
                        connected ++;
                    }
                }
            }
        }
        return (connected == 7 && sCount >=4 );
    }
    
    
    //7명 조합 구하기
    public static void combination(int start){
        // 기저조건
        if(preCom.size() == 7){
            List<int[]>selected = new ArrayList<>();
            for(int num:preCom){
                selected.add(listA.get(num));
            }
            resultCom.add(selected);
            return;
        }
        //구현
        for(int i = start ; i < 25 ; i++){
            preCom.add(i);
            combination(i+1);
            preCom.remove(preCom.size()-1);
        }
    }
    
}
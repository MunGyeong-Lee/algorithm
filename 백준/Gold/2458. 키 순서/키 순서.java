import java.util.*;
import java.io.*;

public class Main{
    
    static int N, M ;
    static final int INF = 1000000;
    static int[][] dist;
    public static void main(String[]args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken()); 
        M = Integer.parseInt(st.nextToken());
        dist = new int[N][N];
        
        // dist 초기화
        for(int i =0 ; i < N; i++){
            Arrays.fill(dist[i], INF);
            dist[i][i] = 0;
        }
        
        // 키 비교 정보 저장
        for(int i = 0 ; i < M ; i++){
            st = new StringTokenizer(br.readLine());
            
            int a = Integer.parseInt(st.nextToken())-1;
            int b = Integer.parseInt(st.nextToken())-1;
            
            dist[a][b] = 1;
        }
        
        // 플로이드-와샬 알고리즘
        for(int k =0; k< N ; k++){
            for(int i =0 ; i < N ; i++){
                for(int j = 0; j < N; j++){
                    
                    if(dist[i][k] == 1 && dist[k][j] == 1){
                        dist[i][j] = 1; //  i-> K -> j 경로가 있으면 i->j로 확정정
                    }
                }
            }
        }
        
        // 각 학생별 자신보다 작은 학생수 + 큰 학생수
        int resultCnt = 0;
        for(int i = 0 ; i < N ; i++){
            int count = 0; 
            for(int j = 0 ; j < N ; j++){
                if(dist[i][j] == 1) count++ ; // 자신보다 큰 학생 수 count
                if(dist[j][i] == 1) count++ ; // 자신보다 작은 학생 수 count
            }
            if(count == N-1) resultCnt++ ;
        }
        
        System.out.println(resultCnt);
        
    }
}
import java.util.*;
class Solution {

    
    int[][] dir = 
    {
     {0, 2},{2, 2}, {2, 0}, {2,-2}, 
     {0,-2}, {-2,-2}, {-2,0}, {-2,2}
    };
    
    Set<String> nodes = new HashSet<>();
    Set<String> edges = new HashSet<>();
    
    public int solution(int[] arrows) {

        
        // 1. 좌표로 그래프 구성
        graph(arrows);
        
//          for(String node : nodes){
//             System.out.println(node);
//         }
        
//         for(String edge : edges){
//             System.out.println(edge);
//         }
        
        // 2. 오일러 공식
        int answer = edges.size() - nodes.size() + 1;
        
        return answer;
        
    }
    
    public void graph(int[] arrows){
        
        int x = 0 ;
        int y = 0 ;
        
        nodes.add(x + "," + y);
        
        for(int arrow : arrows){
                           
            int nx = x + dir[arrow][0];
            int ny = y + dir[arrow][1];
            
            // 대각선인 경우 중간점 자동 생성
            if(isDiagonal(arrow)){
                int midX = x + dir[arrow][0]/2;
                int midY = y + dir[arrow][1]/2;
                
                String midPoint = midX + ","+ midY;
                nodes.add(midPoint);
                edges.add(edgeToString(x+","+y, midPoint));
                edges.add(edgeToString(midPoint, nx+","+ny));
            } else{
                edges.add(edgeToString(x + "," + y, nx + "," + ny));
            }
            
            nodes.add(nx + "," + ny);
            
            x = nx;
            y = ny;
            
            
        }
    }
    
    public String edgeToString(String p1, String p2){
        return p1.compareTo(p2) < 0 ? p1 + "-" + p2 : p2 + "-" + p1 ; 
    }
    
    public boolean isDiagonal(int arrow){
        if (arrow == 1 || arrow == 3 ||arrow == 5 || arrow == 7){
            return true;
        }
        return false;
    }

}
import java.util.*;

class Solution {

    List<List<int[]>> robotRoutes = new ArrayList<>();
    public int solution(int[][] points, int[][] routes) {
        
        int robots = routes.length;// 로봇 대수
        
        // 로봇의 대수 마다 최단 경로 구하는 함수 돌기
        for(int i = 0 ; i < robots ; i++){
            
            List<int[]> fullPath = new ArrayList<>();
            
            // 첫번째 포인트
            int[] startPoint = points[routes[i][0]-1];
            fullPath.add(new int[]{startPoint[0], startPoint[1]});
            
            // 모든 포인트를 순서대로 방문
            for(int j = 1 ; j < routes[i].length; j++){
                int[] currentPoint = points[routes[i][j-1]-1];
                int[] nextPoint = points[routes[i][j]-1];
                
                List<int[]> pathSegment = getPath(currentPoint, nextPoint);
                
                // 시작점 제외하고 추가
                for(int k = 1; k < pathSegment.size(); k++){
                    fullPath.add(pathSegment.get(k));
                }
            }
            robotRoutes.add(fullPath);
   
        }
        
        int maxTime = 0;
        for(List<int[]> robotRoute : robotRoutes){
            maxTime = Math.max(maxTime, robotRoute.size());
        }
        
         // 반복문을 돌면서 인덱스 별로 로봇들의 경로가 겹치는 경우가 발생하면 count ++를 한다
        int warn = 0;
        int time = 0; 
        while(time< maxTime){
            Map<String, Integer>currentPoints = new HashMap<>();
            
            // 로봇별로 현재 시간에 해당하는 위치 찾아서 저장
            for(int i = 0 ; i < robots; i++){
                if(time < robotRoutes.get(i).size()){
                    int[] currentPo = robotRoutes.get(i).get(time);
                    String key = currentPo[0] + "," + currentPo[1];
                    currentPoints.put(key, currentPoints.getOrDefault(key, 0) + 1);
                }
            }
            
            // 현재 같은 위치의 로봇이 있는지
            for(int value : currentPoints.values()){
                if(value > 1){
                    warn++;
                }
            }
            time++;
            
        }
        
        return warn;
        
       
        
        
    }
    
    public List<int[]> getPath(int[] start, int[] end){
        
        List<int[]> path = new ArrayList<>();
        int r = start[0], c = start[1];
        path.add(new int[]{r,c});
        
        // 우선 각 로봇 마다 목적지에 도착하는 최단 경로를 구한다 이때 경로는 [R,C] 형태로 좌표의 위치를 저장한다    
        // 최단 경로가 여러 가지일 경우, r 좌표가 변하는 이동을 c 좌표가 변하는 이동보다 먼저 합니다.
        while(r != end[0]){
            if(r < end[0]) r++;
            else r--;
            
            path.add(new int[]{r,c});
        }
        
        while(c != end[1]){
            if(c < end[1]) c++;
            else c--;
            
            path.add(new int[]{r,c});
        }
        
      return path;
    }

    
}
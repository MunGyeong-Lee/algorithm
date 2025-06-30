import java.util.*;

class Solution {
    
    boolean[] visited;
    List<Integer> prePermutation = new ArrayList<>();;
    List<List<Integer>> indexs = new ArrayList<>();
    
    public int solution(int k, int[][] dungeons) {

        // 순열로 경우의 수 다 구하기  [[0,1,2],[0,2,1],...]
        visited = new boolean[dungeons.length];
        permutation(dungeons, 0);
        
        // 경우의 수를 다 돌아서 최대 횟수 구하기
        int result = 0 ;
        for(int i = 0 ; i < indexs.size() ; i++){
            int count = play(indexs.get(i), dungeons, k);
            result = Math.max(result, count);
        }
        
        
        return result;
    }
    
    public void permutation (int[][] dungeons, int count){
        
        // 1. 기저조건
        if(count == dungeons.length){
            indexs.add(new ArrayList<>(prePermutation));
            return;
        }
        
        // 2. 완전탐색
        for(int i = 0 ; i < dungeons.length ; i++){
            
            if(!visited[i]){
                visited[i] = true;
                prePermutation.add(i);
                permutation(dungeons, count+1);
                // 제거
                prePermutation.remove(prePermutation.size()-1);
                visited[i] = false;
            }
        }
    } 
    
    public int play(List<Integer> now, int[][] dungeons, int k ){
        
        int life =k;
        int count = 0;
        
         
        for(int i = 0 ; i < now.size() ; i++){
            
            int index = now.get(i); // 던전 인텍스 번호

            // 현재 life가 던전 최소 필요 피로도 이상인 상태인지 확인
            if(life >= dungeons[index][0]){
                
                life -= dungeons[index][1];
                count++;
            }else{
                break;
            }
            
            
        }
        return count;
    }
    
    
}
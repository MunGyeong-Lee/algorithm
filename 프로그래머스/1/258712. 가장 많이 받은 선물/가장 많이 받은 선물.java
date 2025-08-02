import java.util.*;
class Solution {
    public int solution(String[] friends, String[] gifts) {

        
        // 선물지수 = 이번달까지 준 선물 수 - 받은 수
        // 이름을 리스트에 넣기 => 인덱스로 사람 구별
        // 이번달 선물 거래 int[][] 2차원 배열
        // 사람 : [준 선물, 받은 선물 , 선물 지수, 받을 선물]
        
        
        // 이번달 선물 거래 int[][] 2차원 배열
        List<String> friendsList = Arrays.asList(friends); // 친구 목록을 list 형태로 변환
        
        int len = friends.length;
        int[][] history = new int[len][len];
        for(int i = 0 ; i < len ; i++){
            Arrays.fill(history[i], 0);
        }
        
        for(String names : gifts){
            
            String[] pre = names.split(" ");
            String send = pre[0];
            String recipt = pre[1];
            
            int sendIndex = friendsList.indexOf(send);
            int reciptIndex = friendsList.indexOf(recipt);
            
            history[sendIndex][reciptIndex] ++;
            

        }
             
        // 사람 : [준 선물, 받은 선물 , 선물 지수, 받을 선물]
        Map<Integer, int[]> memo = new HashMap<>();
        for(int i = 0; i < len ; i++){
            
            int sendScore = 0; // 준 선물 개수
            for(int score : history[i]){
                sendScore+= score;
            }
            
            int reciptScore = 0; // 받은 선물 개수
            for(int j = 0 ; j < len ; j++){
                reciptScore += history[j][i];
            }
            
            int point = sendScore - reciptScore;
                        
            memo.put(i, new int[] {sendScore, reciptScore, point, 0});
            
        }
        
//        for(int key : memo.keySet()) {
//             System.out.println("Key: " + key + ", Value: " + Arrays.toString(memo.get(key)));
           
//         }
        
        // 다음달 받을 선물 구하기
        // 한명씩 다른 사람들과 비교하기
        // 두 사람이 선물을 주고받은 기록이 있다면
        // 두 사람이 선물을 주고받은 기록이 하나도 없거나 주고받은 수가 같다면
        
        for(int i = 0 ; i < len ; i++){
            for(int j = i+1 ; j < len ; j++){
                
                int send = history[i][j]; // i가 j에게 준 선물
                int recipt = history[j][i]; // j가 i에게 준 선물
                
                
                // 두 사람이 선물을 주고받은 기록이 있다면: 더 많은 선물을 준 사람이 다음 달에 선물을 하나 받습니다.
                if((send >0 || recipt >0) && send != recipt){
                    if(send > recipt){
                        memo.get(i)[3]++;
                    }else if(send < recipt){
                        memo.get(j)[3]++;
                    }
                    
                    
                } else if((send == 0 && recipt == 0) || send==recipt){
                    // 두 사람이 선물을 주고받은 기록이 하나도 없거나 주고받은 수가 같다면 : 선물 지수가 더 큰 사람이 선물 지수가 더 작은 사람에게 선물을 하나 받습니다.
                    
                    int senderPoint = memo.get(i)[2];
                    int reciptPoint = memo.get(j)[2];
                    
                    if(senderPoint > reciptPoint){
                        memo.get(i)[3]++;
                    }else if(reciptPoint > senderPoint){
                        memo.get(j)[3]++;
                    }
                    
                }
                
            }
        }
        
        
        int answer = 0;
        for(int key : memo.keySet()){
            int point = memo.get(key)[3];
            // System.out.println(point);
            answer = Math.max(answer, point);
        }
        
        return answer;
    
        
        
        
    }
}
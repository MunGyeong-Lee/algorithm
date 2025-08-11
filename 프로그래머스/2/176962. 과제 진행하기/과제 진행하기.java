import java.util.*;
class Solution {
    public String[] solution(String[][] plans) {
        
        
        // 중단된 과제들을 저장할 스택 (최근에 중단된것 부터 처리)
        Stack<int[]> stack = new Stack<>();
        
        
        // 우선순위 큐: [과목인덱스, 스타트 시간(분)]
        // 스타트 시간 기준 오름차순 정렬
        PriorityQueue<int[]>pq = new PriorityQueue<>((a,b)->{
            return Integer.compare(a[1],b[1]);
        });
        
        // 우선순위 큐 채우기
        int len = plans.length;
        for(int i = 0 ; i < len ; i++ ){
            int startTime = timeCalculator(plans[i][1]);
            int playTime = Integer.parseInt(plans[i][2]);
            pq.offer(new int[]{i, startTime, playTime});
        }
        
        
        // 반복문
        List<String> result = new ArrayList<>();
        
        while(!pq.isEmpty() || !stack.isEmpty() ){
            
            if(!pq.isEmpty()){
                
                int[] current = pq.poll();
                int idx = current[0];
                int start = current[1];
                int duration = current[2];
                
                // 다음과제 있는지 확인
                if(!pq.isEmpty()){
                    int nextStart = pq.peek()[1];
                    
                    
                    if(start + duration <= nextStart){
                        // 현재 과제 완료 가능
                        result.add(plans[idx][0]);
                        
                        
                        // 남은 시간에 중단된 과제 처리
                        int remainTime = nextStart - (start + duration);
                        
                        while(remainTime >0 && !stack.isEmpty()){
                            int[] suspended = stack.pop();
                            
                            // 처리할 시간이 되면 처리
                            if(suspended[2] <= remainTime){
                                result.add(plans[suspended[0]][0]); 
                                remainTime -= suspended[2];
                            } else{
                                suspended[2] -= remainTime;
                                stack.push(suspended);
                                break;
                                
                            }
                        }
                        
                    } else{
                        // 현재 과제를 다음 시작 시간까지만 진행
                        int workTime = nextStart - start;
                        current[2] -= workTime; // 남은 소요시간
                        stack.push(current); // 스택에 저장
                        
                    }
                } else{
                    // 마지막 과제
                    result.add(plans[idx][0]);
                    
                }
                
            } else if(!stack.isEmpty()){
                // 큐가 비어있고 스택에 과제가 남아있는 경우
                int[] suspended = stack.pop();
                result.add(plans[suspended[0]][0]);
            }

            
           
        }
        
        return result.toArray(new String[result.size()]);

        
    }
    public int timeCalculator(String baseTime){
        
        String[] timeString = baseTime.split(":");
        int hour = (Integer.parseInt(timeString[0])) * 60;
        int min = Integer.parseInt(timeString[1]);
        return hour + min;
    }
}
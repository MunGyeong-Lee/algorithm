import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        
        
        
        // while문 : 큐가 빌때까지
        //     첫번째를 poll하기
        //     이 작업이 100이상이 되는 X를 구하기  (스피드 * X)
        //     count ++ 
        //     for 반복문
        //         X를 다른 작업에도 적용시키기
        //         poll 해서 적용했는데 100 넘으면 count ++
        //         poll 해서 적용했는데 100 안넘으면 큐에 다시 넣기(적용시킨 값으로)   
        //    count 를 answer 배열에 추가하기 
        
        Queue<int[]> progressAndSpeed = new LinkedList<>();
        for(int i = 0 ; i < progresses.length ; i++){
            progressAndSpeed.offer(new int[] {progresses[i], speeds[i]});
            // System.out.println(progresses[i]+ " " + speeds[i]);
        }
        
        List<Integer> countList = new ArrayList<>();
        
        Queue<int[]> remaining = new LinkedList<>();
        while(!progressAndSpeed.isEmpty()){
            int[] current = progressAndSpeed.poll();
            int progress = current[0];
            int speed = current[1];
            
            int days = (100-progress + speed - 1)/speed; 
            System.out.println("progress: "+progress+"speed: "+speed+"days: "+days);
            
            int count = 1;

            
            while(!progressAndSpeed.isEmpty()){
                int[] next = progressAndSpeed.poll();
                int nextProgress = next[0];
                int nextSpeed = next[1];
                
                int afterDays = nextProgress+(nextSpeed*days);
                
                if(afterDays >= 100){
                    System.out.println("100일 넘음 " + "nextProgress: "+nextProgress+"nextSpeed: "+nextSpeed+"afterDays: "+afterDays);
                    // progressAndSpeed.poll();
                    count ++;
                } else {

                    remaining.offer(new int[] {nextProgress, nextSpeed});
                    System.out.println("100일 안넘음 " +"nextProgress: "+nextProgress+"nextSpeed: "+nextSpeed+"afterDays: "+afterDays);
                    while(!progressAndSpeed.isEmpty()){
                        remaining.offer(progressAndSpeed.poll());
                    }
                }
                
                
            }
            
            countList.add(count);
            
            progressAndSpeed = remaining;
            remaining = new LinkedList<>();
        }
                
        int[] answer  = countList.stream().mapToInt(i->i).toArray();    
        return answer;        
            
    }
}
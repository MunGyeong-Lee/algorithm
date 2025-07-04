import java.util.*;
class Solution {
    public int solution(int[][] jobs) {
         Arrays.sort(jobs, (a, b) -> a[0] - b[0]);
        
        List<Integer> finishTimes = new ArrayList<>();
        
        // 우선순위 : 소요시간 짧은 것 > 요청시간 빠른 것 > 작업 번호가 작은 것 
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->{
            if(a[1]!=b[1]) return a[1] - b[1];
            if(a[0]!=b[0]) return a[0] - b[0];
            return a[2]-b[2];
            
        });

        
        int time = 0; // 현재 시간
        int jobIndex = 0;
        while(jobIndex < jobs.length || !pq.isEmpty()){
            
            // 현재 시간까지 들어온 모든 요청을 큐에 추가
            while(jobIndex < jobs.length && jobs[jobIndex][0] <=time){
                pq.offer(new int[] {jobs[jobIndex][0], jobs[jobIndex][1], jobIndex});
                jobIndex++;
            }
            
            
            if(!pq.isEmpty()){
                int[] currentJob = pq.poll();
                int finishTime = time + currentJob[1];
                finishTimes.add(finishTime - currentJob[0]);
                time = finishTime;
                
            } else{
                if(jobIndex < jobs.length){
                    time = jobs[jobIndex][0];
                }
            }
        }
        
        int sum = 0 ;
        for(Integer num : finishTimes){
            sum += num;
        }
        double average = (double) sum / finishTimes.size();
        
        return (int) average;

    }
}
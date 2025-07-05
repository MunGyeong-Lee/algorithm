import java.util.*;
class Solution {
    public int[] solution(String[] operations) {
        DoublePriorityQueue<Integer> dpq = new DoublePriorityQueue<>();
        
        // dpq 채우기
        for(String operation: operations){
            String[] part = operation.split(" ");
            String command = part[0];
            int number = Integer.parseInt(part[1]);
            
            // I로 시작하면 숫자 넣기
            if(command.equals("I")){
                dpq.offer(number);
            } else if(command.equals("D")){
                // D로 시작하면 -1 : 최소값 빼기 / 1: 최대값 빼기   
                if(number == 1){
                    dpq.pollMax();
                } else if(number == -1){
                    dpq.pollMin();
                }
            }
        }
        
//        dqp가 비워져있으면 [0,0] 반환
//        그렇지 않으면 [최댓값, 최솟값] 반환
        if(dpq.isEmpty()){
            return new int[] {0,0};
        } else{
            int min = dpq.peekMin();
            int max = dpq.peekMax();
            
            return new int[] {max, min};
            
        }
        
        
        
    }
    
    
   class DoublePriorityQueue<T extends Comparable<T>>{
       private TreeSet<T> data;
       
       public DoublePriorityQueue(){
           this.data = new TreeSet<>();
       }
       
       public void offer(T element){
           data.add(element);
       }
       
       // 최소값 빼기 (= 맨 앞)
       public T pollMin(){
           return data.pollFirst();
       }
       
       // 최소값 빼기 (= 맨 뒤)
       public T pollMax(){
           return data.pollLast();
       }
       
       // 최소값 확인 (= 맨 앞)
       public T peekMin(){
           return data.isEmpty()? null: data.first();
       }
       
       // 최대값 확인 (= 맨 뒤)
       public T peekMax(){
           return data.isEmpty()? null: data.last();
       }
       
       public boolean isEmpty(){
           return data.isEmpty();
       }
       
       public int size(){
           return data.size();
       }
   }
}
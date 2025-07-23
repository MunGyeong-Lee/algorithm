class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        
        int time = 0;
        int currentHealth = health;
        int success = 0;
        int attackTurn = 0;
        
        int lastTime = attacks[attacks.length-1][0];
        while(time <= lastTime){

           if(attackTurn < attacks.length && time == attacks[attackTurn][0]) {
                // 만약 공격받을 시간이 되면 
               success = 0;
               currentHealth -= attacks[attackTurn][1];
               attackTurn++;
               
               if(currentHealth <= 0){
                   //현재 체력이 0 이하가 되면 캐릭터가 죽음
                   return -1;
               }
              
               
           }else{
                // 만약 공격받을 시간이 아니면 회복
               currentHealth += bandage[1];
               success++;
               
               if(success == bandage[0]){
                   // 연속 성공하면 추가 회복
                   currentHealth += bandage[2];
                   success = 0;
               }
               
               if(currentHealth > health){
                   currentHealth = health;
               }
               
            }
           
            System.out.println(currentHealth);
            time++; 
        }
      
        return currentHealth;
        
    }
}
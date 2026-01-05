class Solution {
    int result;
    int w_row;
    int w_len;
    int w_temp;
    int b_row; 
    int b_len; 
    int b_temp;
    boolean turn;
    public int solution(int[] wallet, int[] bill) {

         w_row = wallet[0];
         w_len = wallet[1];

         b_row = bill[0];
         b_len = bill[1];

        turn = false; 
        result = 0;

        // 1. 길이 비교
        // 지폐의 가로 세로가 지갑의 가로 세로보다 하나라도 크면 90도 회전, 지폐 회전 유무 = true
        // 지폐 회전 횟수가 true이 됐다면, 지폐 회전 false로 리셋, 반 접기
        while(Math.min(b_row, b_len) > Math.min(w_row, w_len) 
              || Math.max(b_row, b_len)> Math.max(w_row, w_len)){
            
            if(turn == false){
                foldBill();
                turn = true;
            } else{
                turnBill();  
            }
        }
        return result;
    }
    
    // 2. 지폐 회전
    public void turnBill(){
        b_temp = b_row;
        b_row = b_len;
        b_len = b_temp;
        
        turn = false;
    }

    // 3. 반 접기 : 길이가 긴 쪽을 반으로 접는다, 접는 횟수 result를 +1 한다
    public void foldBill(){
        if(b_row < b_len){
            b_len = Math.round(b_len/2);
        } else{
            b_row = Math.round(b_row/2);
        }
        
        result ++;
    }

}

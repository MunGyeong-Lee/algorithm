import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        
        // 만약 0 밖에 없으면 0으로 return
        boolean flag = true;
        for(int num : numbers){
            if(num > 0){
                flag = false;
            }
        }
        if(flag){
            String zero = "0";
            return zero;
        }
        
        // int를 String으로 변환해서 리스트에 저장
        List<String> numbersList = new ArrayList<>();
        for(int num : numbers){
            String numStr = Integer.toString(num);
            numbersList.add(numStr);
        }
        
        Collections.sort(numbersList, (a,b)->(b+a).compareTo(a+b));
        // for(String str: numbersList){
        //     System.out.println(str);
        // }
        
        String answer = "";
        for(String str: numbersList){
            answer += str;
        }
        return answer;
    }
}





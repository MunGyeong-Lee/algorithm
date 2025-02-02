import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader((new InputStreamReader(System.in)));
        Stack<String> stack  = new Stack<>();
        StringBuilder result = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        for(int i = 0; i < N; i++){
            List<String> command = Arrays.asList(br.readLine().split(" "));

            if(command.get(0).equals("push") ){
                stack.push(command.get(1));

            }else if(command.get(0).equals("pop")){
                if(stack.isEmpty()){
                    result.append(-1);
                } else{
                    result.append(stack.pop());
                }
                if(i < N-1){
                    result.append("\n");
                }

            }else if(command.get(0).equals("size")){
                result.append(stack.size());
                if(i < N-1){
                    result.append("\n");
                }

            }else if(command.get(0).equals("empty")){
                if(stack.isEmpty()){
                    result.append(1);
                }else{
                    result.append(0);
                }

                if(i < N-1){
                    result.append("\n");
                }

            }else if(command.get(0).equals("top")){
                if(stack.isEmpty()){
                    result.append(-1);
                }else{
                    result.append(stack.get(stack.size()-1));
                }

                if(i < N-1){
                    result.append("\n");
                }
            }
        }
        System.out.println(result);
    }
}

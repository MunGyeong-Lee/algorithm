import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        List<Integer> ListA = new ArrayList<>();
        List<Integer> ListB = new ArrayList<>();
        
        for(int i = 0 ; i < N ; i ++){
            ListA.add (Integer.parseInt(st.nextToken()));
        }
        
        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < N ; i++){
            ListB.add (Integer.parseInt(st.nextToken()));
        }
        
        Collections.sort(ListA);
        Collections.sort(ListB,Collections.reverseOrder());
       
        int result = 0;
        
        for(int i = 0; i < N ; i++){
            result += ListA.get(i)*ListB.get(i);
        }
        
        System.out.println(result);

    
    }
}
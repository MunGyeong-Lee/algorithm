import java.util.*;
import java.io.*;
public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        Map<String, String> passwordBook = new HashMap<>();
        
        for(int i = 0; i < n ; i++){
            st = new StringTokenizer(br.readLine());
            String address = st.nextToken();
            String pass = st.nextToken();
            passwordBook.put(address, passwordBook.getOrDefault(address, pass));
        }
        
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for(int i = 0 ; i < m ; i++ ){
            st = new StringTokenizer(br.readLine());
            String address = st.nextToken();
            String answer = passwordBook.get(address);
            bw.write(answer);
            bw.newLine();
        }
        bw.flush();
        bw.close();
        
        
    }
}
import java.io.IOException;
import java.util.Scanner;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[][] array = new String[9][9];
        for (int i = 0; i < 9; i++) {
            String[] line = br.readLine().split(" ");
            for (int j = 0; j < 9; j++) {
                array[i][j] = line[j];
            }
        }

        int result = -1;
        int x = 10;
        int y = 10;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++){
                if (result <= Integer.parseInt(array[i][j]) ){
                    result = Integer.parseInt(array[i][j]);
                    x = i+1;
                    y = j+1;
                }
            }
        }

        bw.write(String.valueOf(result)+ "\n");
        bw.write(String.valueOf(x)+ " " + String.valueOf(y));

        bw.flush();
        br.close();
        bw.close();

    }
}

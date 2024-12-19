import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int H = sc.nextInt();
        int M = sc.nextInt();


        int i = 15;
        int j = 1;
        int k = 45;

        if(M < 45){
            M += i ;
            if (H > 0){
                H -= j;
            } else{
                H = 23;
            }
        } else{
            M -= k;
        }
        System.out.println(H + " " + M);

        sc.close();
    }
}
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int A = sc.nextInt();
        int B = sc.nextInt();
        int C = sc.nextInt();

        if (A == B && B == C){
            System.out.println(10000 + (A*1000));

        }else if (A== B|| A==C || B==C){
           // 두 숫자가 같은 경우, 중복된 숫자를 출력

            int duplicate ;
            if(A == B || A == C){
                duplicate = 1000 + (A*100);
            } else {
                duplicate = 1000 + (B*100);
            }
            System.out.println(duplicate);

        } else{
            // ABC중 가장 큰값 프린트
            int max = Math.max(A, Math.max(B,C));
            System.out.println(max*100);

        }
        sc.close();
    }
}

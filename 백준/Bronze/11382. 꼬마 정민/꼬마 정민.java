import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String A = sc.nextLine();
        // 공백을 기준으로 분리하여 배열에 저장
        String[] values = A.split(" ");

        // 배열의 값 누적 합
        long sum = 0;
        for(String value : values ){

            long intValue = Long.parseLong(value);
            sum += intValue ;
        }
        System.out.println(sum);

    }
}
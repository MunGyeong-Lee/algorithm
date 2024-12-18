import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int A = Integer.parseInt(sc.nextLine());
        String B = sc.nextLine();

        for (int i = B.length() - 1; i >= 0; i--) {
            int b = B.charAt(i) - '0';
            System.out.println(b * A);
        }
        int bInt = Integer.parseInt(B);
        System.out.println(bInt * A);

    }
}
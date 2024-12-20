import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int A = sc.nextInt();

        String result = "";
        for (int i = 1; i <= A/4; i++) {

            result+= "long"+" ";
        }
        System.out.println(result+"int");

        sc.close();
    }
}

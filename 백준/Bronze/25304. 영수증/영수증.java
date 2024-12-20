import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long total= sc.nextLong();
        int count = sc.nextInt();

        long sum = 0;
        for(int i = 1; i<=count;i++){
            long price = sc.nextLong();
            int ea = sc.nextInt();
            sum += price*ea;
        }

        if(sum==total){
            System.out.println("Yes");
        } else{
            System.out.println("No");
        }

        sc.close();
    }
}

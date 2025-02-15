import java.io.*;
import java.util.*;

public class Main {

    static long M ;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] inputA = br.readLine().split(" ");
        String[] inputArray = br.readLine().split(" ");
        long N = Integer.parseInt(inputA[0]);
        M = Integer.parseInt(inputA[1]);

        ArrayList<Integer> trees = new ArrayList<>();
        for (String tree : inputArray) {
            trees.add(Integer.parseInt(tree));
        }

        long maxTree = Collections.max(trees);

        System.out.println(findMethod(0, maxTree, trees));

    }

    private static long findMethod(long start, long end, ArrayList<Integer> trees) {
        long nextStart = start;
        long nextEnd = end;
        long bestHeight = 0;
//        System.out.println(M);
//        System.out.println(trees);


//
//        System.out.println(nextStart);
//        System.out.println(nextEnd);


        while (nextStart <= nextEnd) {
            long middle = (nextStart + nextEnd) / 2;
            long result = 0;

            for (long tree : trees) {
//                System.out.println(i);
                if (tree > middle) {
//                    System.out.println(heights.get(i));
                    result += (tree - middle);
//                    System.out.println(result);
                }
            }
//            System.out.println(result);


            if (result >= M) {
                bestHeight = middle;
                nextStart = middle +1;
            } else {
                nextEnd = middle - 1;
            }

        }
        return bestHeight;

    }

}

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] inputA = br.readLine().split(" ");
        String[] inputB = br.readLine().split(" ");

        int N = Integer.parseInt(inputA[0]); // 트럭 개수
        int W = Integer.parseInt(inputA[1]); // 다리 길이
        int L = Integer.parseInt(inputA[2]); // 다리 최대 하중
        List<Integer> trucks = new ArrayList<>(); // 트럭

        for(String truck : inputB){
            trucks.add(Integer.parseInt(truck));
        }
//        System.out.println(trucks.get(0));

        Queue<Integer> bridge  = new ArrayDeque<>(); // 다리 위 트럭들
        for(int i = 0; i < W ; i++){
            bridge.add(0);
        }
//        System.out.println(bridge);


        int turn = 0;
        int time = 0; // 시간
        int currentWeight = 0; // 현재 다리 위의 총 하중

        while(turn < N || currentWeight > 0){ // 트럭이 다 도착하면 반복문 STOP

            // 다리 마지막 자리를 댕김
            int endTruck = bridge.poll();
            currentWeight -= endTruck;

            if(turn < N) {
                // 다리 위 트럭 보관 배열의 합 + 현재 순서의 트럭이 이 L 보다 작거나 같을 때
                if(currentWeight + trucks.get(turn) <= L){
                    bridge.add(trucks.get(turn));
                    currentWeight += trucks.get(turn);
                    turn ++;

                }else{
                    bridge.add(0);
                }
            } else {
                bridge.add(0);
            }

            time++;
        }
        System.out.println(time);
    }
}

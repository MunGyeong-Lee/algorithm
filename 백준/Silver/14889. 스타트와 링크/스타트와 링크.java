import javax.swing.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.io.*;

public class Main {
    // 1. 클래스 변수 선언
    static int N;
    static int[][] arr;
    static int result;

    public static void main(String[] args) throws IOException {
        // 2. BufferedReader과 BufferedWriter 작성
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        result = Integer.MAX_VALUE;
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];

        for(int i = 0; i < N; i++){
            String[] line = br.readLine().split(" ");
            for(int j = 0; j < N; j++){
                arr[i][j] = Integer.parseInt(line[j]);
            }
        }

        //숫자 리스트 생성
        List<Integer> numbers = new ArrayList<>();
        for(int i = 0; i < N; i++){
            numbers.add(i);
        }
        // 전체 조합 그룹 만들기
        // 이중 리스트
        // 리스트 내부에 또다른 리스트를 저장하는 구조, 조합과 같은 여러개의 그룹을 관리하기 유용
        List<List<Integer>> firstGroup = new ArrayList<>();
        combine(numbers, new ArrayList<>(), firstGroup, N/2, 0);

        int halfSize = firstGroup.size()/2;
        for(int i = 0; i < halfSize ; i++){
            // 첫번째 조합 그룹
            List<Integer> group1 = firstGroup.get(i);

            // 두번째 조합 그룹 생성
            List<Integer> group2 = new ArrayList<>(numbers); //numbers 를 그대로 복사
            group2.removeAll(group1); // group1 에 있는 모든 원소를 group2에서 모두 제거 >> 중복된게 없어짐

            int firstSkill = skill(group1);
            int secondSkill = skill(group2);

            result = Math.min(result, Math.abs(firstSkill-secondSkill));

        }
        bw.write(String.valueOf(result));

        bw.flush();
        br.close();
        bw.close();

    }

    // 3. combine 메서드:  조합 생성
    private static void combine(
            List<Integer> numbers,  // 조합을 생성할 숫자 리스트
            List<Integer> temp,     // 현재 생성 중인 조합
            List<List<Integer>> result, //완성된 조합들이 저장될 리스트
            int size,                   // 원하는 조합 크기
            int start                   // 조합 생성을 시작할 인덱스
            ){
        // 종료 조건: temp 크기가 원하는 size와 같아지면, 조합이 완성
        if (temp.size() == size){
            result.add(new ArrayList<>(temp));
            return;
        }
        // start 부터 numbers 리스트의 끝까지 순회하며 조합 생성
        for (int i = start; i < numbers.size(); i++){
            temp.add(numbers.get(i)); // 현재 숫자를 조합에 추가
            combine(numbers, temp, result, size, i + 1); // 재귀 호출, 다음 숫자 선택
            temp.remove(temp.size()-1); // 이전 상태로 되돌리기
        }
    }
    //4. taste 메서드: 맛 차이 계산
    private static int skill(List<Integer> combination) {
        int sum = 0;
        int len = combination.size();

        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                int a = combination.get(i);
                int b = combination.get(j);
                sum += arr[a][b] + arr[b][a];

            }
        }
        return sum;
    }
}

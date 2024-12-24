import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // N번째 종말의 수

        int count = 0; // 종말의 수 개수 카운트
        int number = 666; // 첫 번째 종말의 수 시작점

        while (true) {
            // 숫자에 "666"이 포함되어 있는지 확인
            if (String.valueOf(number).contains("666")) {
                count++; // 포함되어 있다면 카운트 증가
            }

            // N번째 종말의 수에 도달했으면 출력 후 종료
            if (count == N) {
                System.out.println(number);
                break;
            }

            number++; // 다음 숫자로 이동
        }
    }
}

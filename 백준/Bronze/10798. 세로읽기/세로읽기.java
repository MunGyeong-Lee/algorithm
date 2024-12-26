import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 다섯 줄의 입력을 배열에 저장
        String[] words = new String[5];
        for (int i = 0; i < 5; i++) {
            words[i] = scanner.nextLine();
        }

        // 세로로 읽기
        StringBuilder result = new StringBuilder();
        int maxLength = 0;

        // 최대 길이를 구합니다.
        for (String word : words) {
            maxLength = Math.max(maxLength, word.length());
        }

        // 세로로 읽기
        for (int col = 0; col < maxLength; col++) {
            for (int row = 0; row < 5; row++) {
                if (col < words[row].length()) {
                    result.append(words[row].charAt(col));
                }
            }
        }

        // 결과 출력
        System.out.println(result.toString());
    }
}

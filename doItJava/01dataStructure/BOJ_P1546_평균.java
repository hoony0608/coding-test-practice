import java.util.Scanner;

public class BOJ_P1546_평균 {
    public static void main(String[] args) {

        /**
         * 1. 과목의 개수 입력받기
         * 2. 과목의 개수만큼 점수를 배열에 저장 그리고 입력값과 최대값을 비교 후 최대값 결정
         * 3. 각 점수값 / 최대값 * 100을 계산한 값을 누적
         * 4. 누적값에 과목의 개수로 나누어 평균을 구함
         */

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] scoreArray = new int[1004];
        int max = 0;
        double answer = 0;

        for(int i = 0; i < n; i++) {
            scoreArray[i] = scanner.nextInt();
            if(max < scoreArray[i]) max = scoreArray[i];
        }

        for(int i = 0; i < n; i++) {
            answer += (double) scoreArray[i] / max * 100;
        }

        System.out.println(answer / n);
    }
}

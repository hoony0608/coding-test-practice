import java.util.Scanner;

public class BOJ_P2018_수들의합5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int answer = 0;
        int start_idx = 1, end_idx = 1, sum = 1;
        int n = scanner.nextInt();

        while(end_idx >= start_idx) {
            if(sum < n) {
                sum += ++end_idx;
            } else if (sum > n) {
                sum -= start_idx++;
            } else {
                answer++;
                sum += ++end_idx;
            }
        }

        System.out.println(answer);
    }
}

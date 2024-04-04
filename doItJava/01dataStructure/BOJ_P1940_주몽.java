import java.util.Arrays;
import java.util.Scanner;

public class BOJ_P1940_주몽 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int start_idx = 0;
        int end_idx = n - 1;
        int answer = 0;

        int[] arr = new int[15004];

        for(int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        // O(n log n)
        Arrays.sort(arr, 0, n);

        // O(n)
        while(start_idx < end_idx) {
            if(arr[start_idx] + arr[end_idx] == m) {
                answer++;
                start_idx++;
            } else if (arr[start_idx] + arr[end_idx] > m) end_idx--;
            else start_idx++;
        }

        System.out.println(answer);

    }
}

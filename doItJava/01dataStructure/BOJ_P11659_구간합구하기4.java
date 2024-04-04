import java.util.Scanner;

public class BOJ_P11659_구간합구하기4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int m = scanner.nextInt();

        int[] arr = new int[n + 4];
        int[] sArr = new int[n + 4];

        arr[0] = 0;
        sArr[0] = 0;

        for(int i = 1; i <= n; i++) {
            arr[i] = scanner.nextInt();
            sArr[i] = sArr[i - 1] + arr[i];
        }

        while(m-- != 0) {
            int i = scanner.nextInt();
            int j = scanner.nextInt();

            System.out.println(sArr[j] - sArr[i - 1] );
        }
    }
}
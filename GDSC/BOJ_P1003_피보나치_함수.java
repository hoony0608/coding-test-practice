import java.util.Scanner;

public class BOJ_P1003_피보나치_함수 {

    static int[] ansArr = new int[2];
    static int[][] arr = new int[44][2];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m;
        arr[0] = new int[]{1, 0};
        arr[1] = new int[]{0, 1};
        for(int i = 0; i < n; i++) {
            m = sc.nextInt();
            ansArr = fibonacci(m);

            System.out.println(ansArr[0] + " " + ansArr[1]);
            ansArr = new int[]{0, 0};
        }
    }

    static int[] fibonacci(int n) {
        if(n == 0 || n == 1) return arr[n];
        else {
            if(arr[n][0] == 0 && arr[n][1] == 0) {
                arr[n][0] = fibonacci(n - 1)[0] + fibonacci(n - 2)[0];
                arr[n][1] = fibonacci(n - 1)[1] + fibonacci(n - 2)[1];
            }
            return arr[n];
        }
    }

}

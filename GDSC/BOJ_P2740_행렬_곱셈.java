import java.util.Scanner;

public class BOJ_P2740_행렬_곱셈 {

    public static void main(String[] args) {

        int sum = 0;

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int[][] a = new int[104][104];

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                a[i][j] = sc.nextInt();
            }
        }

        m = sc.nextInt();
        int l = sc.nextInt();
        int[][] b = new int [104][104];

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < l; j++) {
                b[i][j] = sc.nextInt();
            }
        }

        int[][] c = new int[104][104];

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < l; j++) {
                for (int k = 0; k < m; k++) {
                    sum += a[i][k] * b[k][j];
                }
                c[i][j] = sum;
                sum = 0;
            }
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < l; j++) {
                System.out.print(c[i][j] + " ");
            }
            System.out.println();
        }

    }
}

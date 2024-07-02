import java.util.Scanner;

public class BOJ_P1922_네트워크_연결 {
    static int n, m, y, x, min, my, mx, sum;
    static int[][] _graph = new int[100004][100004];
    static int[][] _ans_graph = new int[1004][1004];
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();

        for(int i = 0; i < m; i++) {
            y = scanner.nextInt();
            x = scanner.nextInt();
            _graph[y][x] = scanner.nextInt();
            if(min > _graph[y][x]) {
                my = y;
                mx = x;
                min = _graph[y][x];
            }
        }

        sum += min;




    }
}

import java.util.Scanner;

public class BOJ_P11403_경로_찾기 {

    static int n;
    static int[][] _map = new int[104][104];
    static int[][] visited = new int[104][104];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                _map[i][j] = sc.nextInt();
            }
        }

        for(int i = 0; i < n; i++) {
            go(i, i);
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                System.out.print(visited[i][j] + " ");
            }
            System.out.println();
        }

    }

    public static void go(int x, int y) {
        for(int i = 0; i < n; i++) {
            if(_map[x][i] == 0 || visited[y][i] == 1) continue;
            visited[y][i] = 1;
            go(i, y);
        }
    }
}

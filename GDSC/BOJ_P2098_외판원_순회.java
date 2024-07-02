import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_P2098_외판원_순회 {
    static int _max = 1000004;
    static int n;
    static int[][] _map = new int[_max][_max];
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                _map[i][j] = scanner.nextInt();
            }
        }

        Queue<int[][]> q = new LinkedList<>();


    }
}

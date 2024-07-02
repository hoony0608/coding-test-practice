package _0X08_BFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_P2178_미로_탐색 {
    static int[][] board = new int[104][104];
    static int[][] vis = new int[104][104];

    static int[] dy = {1, 0, -1, 0};
    static int[] dx = {0, 1, 0, -1};

    static int n, m;
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        String str;
        for(int i = 0; i < n; i++) {
            str = scanner.next();
            char[] c = str.toCharArray();
            for(int j = 0; j < m; j++) {
                board[i][j] = (int) c[j] - '0';
            }
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(0, 0));
        vis[0][0] = 1;

        while(!q.isEmpty()) {
            Pair cur = new Pair(q.peek().y, q.peek().x);
            q.remove();

            for(int i = 0; i < 4; i++) {
                int ny = cur.y + dy[i];
                int nx = cur.x + dx[i];

                if(nx < 0 || nx >= m || ny < 0 || ny >= n) continue;
                if(vis[ny][nx] != 0 || board[ny][nx] == 0) continue;
                vis[ny][nx] = vis[cur.y][cur.x] + 1;
                q.add(new Pair(ny, nx));
            }

        }

        System.out.println(vis[n - 1][m - 1]);

    }

    static class Pair {
        int x;
        int y;

        public Pair(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}

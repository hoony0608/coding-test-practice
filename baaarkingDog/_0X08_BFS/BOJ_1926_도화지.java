package _0X08_BFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_1926_도화지 {

    static int[] dy = {1, 0, -1, 0};
    static int[] dx = {0, 1, 0, -1};

    static int[][] board = new int[504][504];
    static int[][] vis = new int[504][504];

    static int n, m;
    static int pic_num = 0, pic_size = 0;


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        n = scanner.nextInt();
        m = scanner.nextInt();

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                board[i][j] = scanner.nextInt();
            }
        }

        int max_size = 0;

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(board[i][j] != 1 || vis[i][j] != 0) continue;
                bfs(i, j);
                max_size = Math.max(max_size, pic_size);
            }
        }

        System.out.println(pic_num);
        System.out.println(max_size);
    }

    static void bfs(int y, int x) {
        pic_size = 0;
        pic_num++;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(y, x));
        vis[y][x] = 1;

        while(!q.isEmpty()) {
            Pair cur = new Pair(q.peek().y, q.peek().x);
            q.remove();
            pic_size++;

            for(int i = 0; i < 4; i++) {
                int ny = cur.y + dy[i];
                int nx = cur.x + dx[i];

                if(ny >= n || ny < 0 || nx >= m || nx < 0) continue;
                if(vis[ny][nx] > 0 || board[ny][nx] != 1) continue;
                vis[ny][nx] = 1;
                q.add(new Pair(ny, nx));
            }
        }
    }

    static class Pair {
        int y;
        int x;
        public Pair(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}

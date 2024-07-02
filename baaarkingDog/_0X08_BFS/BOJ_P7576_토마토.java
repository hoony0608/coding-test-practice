package _0X08_BFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_P7576_토마토 {

    static Queue<Pair> q = new LinkedList<>();

    static int[][] board = new int[1004][1004];
    static int[][] dist = new int[1004][1004];
    static int[] dy = {1, 0, -1, 0};
    static int[] dx = {0, 1, 0, -1};
    static int n, m;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        m = sc.nextInt();
        n = sc.nextInt();

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                board[i][j] = sc.nextInt();
                if(board[i][j] == 1) q.add(new Pair(i, j));
                if(board[i][j] == 0) dist[i][j] = -1;
            }
        }

        while(!q.isEmpty()) {
            Pair cur = new Pair(q.peek().y, q.peek().x);
            q.remove();

            for(int i = 0; i < 4; i++) {
                int ny = cur.y + dy[i];
                int nx = cur.x + dx[i];

                if(ny < 0 || ny >= n || nx < 0 || nx >= m) continue;
                if(dist[ny][nx] != -1) continue;
                dist[ny][nx] = dist[cur.y][cur.x] + 1;
                q.add(new Pair(ny, nx));
            }
        }
        int answer = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                answer = Math.max(answer, dist[i][j]);
                if(dist[i][j] == -1) {
                    System.out.println(-1);
                    System.exit(0);
                }
            }
        }

        System.out.println(answer);

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

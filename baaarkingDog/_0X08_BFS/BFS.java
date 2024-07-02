package _0X08_BFS;

import java.util.LinkedList;
import java.util.Queue;

public class BFS {
    static int[][] board = {
            {1,1,1,0,1,0,0,0,0,0},
            {1,0,0,0,1,0,0,0,0,0},
            {1,1,1,0,1,0,0,0,0,0},
            {1,1,0,0,1,0,0,0,0,0},
            {0,1,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0}
    };
    static int[][] vis = new int[502][502];
    static int n = 7, m = 10;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) {
        int num = 0;
        Queue<Pair> q = new LinkedList<>();
        vis[0][0] = 1;

        q.add(new Pair(0, 0));

        while(!q.isEmpty()) {
            num++;
            Pair cur = new Pair();
            cur.setX(q.peek().getX());
            cur.setY(q.peek().getY());
            q.remove();

            for(int i = 0; i < 4; i++) {
                int ny = cur.getY() + dy[i];
                int nx = cur.getX() + dx[i];

                if(ny < 0 || ny >= n || nx < 0 || nx >= m) continue;
                if(vis[ny][nx] == 1 || board[ny][nx] != 1) continue;
                vis[ny][nx] = 1;
                q.add(new Pair(nx, ny));
            }

            System.out.println(num);
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                System.out.print(board[i][j]);
            }
            System.out.println();
        }

        System.out.println();

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                System.out.print(vis[i][j]);
            }
            System.out.println();
        }
    }

    static class Pair {
        private int x;
        private int y;

        public Pair() {}

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public void setX(int x) {
            this.x = x;
        }

        public void setY(int y) {
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }
    }
}

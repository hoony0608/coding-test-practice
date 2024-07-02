package _0X09_DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_P10026_적록색약 {

    static char[][] board = new char[104][104];
    static int[][] visit = new int[104][104];
    static int[] dy = {1, 0, -1, 0};
    static int[] dx = {0, 1, 0, -1};
    static int n, ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());


        for (int i = 0; i < n; i++) {
            char[] temp = br.readLine().toCharArray();
            for (int j = 0; j < n; j++) {
                board[i][j] = temp[j];
            }
        }

        Stack<Pair> s = new Stack<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(visit[i][j] == 0) {
                    ans++;
                    s.push(new Pair(i, j));
                    visit[i][j]++;

                    while(!s.isEmpty()) {
                        Pair cur = new Pair(s.peek().y, s.peek().x);
                        s.pop();

                        for(int k = 0; k < 4; k++) {
                            int ny = cur.y + dy[k];
                            int nx = cur.x + dx[k];

                            if(ny >= n || ny < 0 || nx >= n || nx < 0) continue;
                            if(board[ny][nx] != board[cur.y][cur.x] || visit[ny][nx] == 1) continue;

                            visit[ny][nx]++;
                            s.push(new Pair(ny, nx));
                        }
                    }
                }
            }
        }
        System.out.println(ans);
        ans = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(board[i][j] == 'G') board[i][j] = 'R';
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(visit[i][j] == 1) {
                    ans++;
                    s.push(new Pair(i, j));
                    visit[i][j]++;

                    while(!s.isEmpty()) {
                        Pair cur = new Pair(s.peek().y, s.peek().x);
                        s.pop();

                        for(int k = 0; k < 4; k++) {
                            int ny = cur.y + dy[k];
                            int nx = cur.x + dx[k];

                            if(ny >= n || ny < 0 || nx >= n || nx < 0) continue;
                            if(board[ny][nx] != board[cur.y][cur.x] || visit[ny][nx] == 2) continue;

                            visit[ny][nx]++;
                            s.push(new Pair(ny, nx));
                        }
                    }
                }
            }
        }
        System.out.println(ans);
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

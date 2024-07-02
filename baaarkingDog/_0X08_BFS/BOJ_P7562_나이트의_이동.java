package _0X08_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_P7562_나이트의_이동 {
    static int[][] board;
    static int[][] visit;
    static int[] dy = {2, 1, 2, 1, -2, -1, -2, -1};
    static int[] dx = {1, 2, -1, -2, 1, 2, -1, -2};
    static int t, n, y, x;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        t = Integer.parseInt(br.readLine());
        Queue<Pair> q;

        StringTokenizer st;

        while(t-- > 0) {
            board = new int[304][304];
            visit = new int[304][304];
            q = new LinkedList<>();
            n = Integer.parseInt(br.readLine());

            st = new StringTokenizer(br.readLine());
            y = Integer.parseInt(st.nextToken());
            x = Integer.parseInt(st.nextToken());
            visit[y][x] = 1;
            q.add(new Pair(y, x));

            st = new StringTokenizer(br.readLine());
            y = Integer.parseInt(st.nextToken());
            x = Integer.parseInt(st.nextToken());
            board[y][x] = 1;


            while(!q.isEmpty()) {
                Pair cur = new Pair(q.peek().y, q.peek().x);
                q.remove();
                if(board[cur.y][cur.x] == 1) {
                    System.out.println(visit[cur.y][cur.x] - 1);
                    break;
                }
                for(int i = 0; i < 8; i++) {
                    int ny = cur.y + dy[i];
                    int nx = cur.x + dx[i];

                    if(ny >= n || ny < 0 || nx >= n || nx < 0) continue;
                    if(visit[ny][nx] > 0) continue;
                    visit[ny][nx] += visit[cur.y][cur.x] + 1;
                    q.add(new Pair(ny, nx));
                }
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

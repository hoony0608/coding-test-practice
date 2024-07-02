package _0X08_BFS;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_P4179_불 {

    static int[] dy = {1, 0, -1, 0};
    static int[] dx = {0, 1, 0, -1};
    static char[][] board = new char[1004][1004];
    static int[][] fVisit = new int[1004][1004];
    static int[][] jVisit = new int[1004][1004];
    static int jx, jy, fx, fy;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        ArrayList<Pair> fArr = new ArrayList<>();
        Queue<Pair> q = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            char[] cArr = br.readLine().toCharArray();
            for(int j = 0; j < m; j++) {
               board[i][j] = cArr[j];

               if(cArr[j] == 'J') {
                   jy = i;
                   jx = j;
               } else if(cArr[j] == 'F') {
                   fy = i;
                   fx = j;
                   q.add(new Pair(i, j));
                   fVisit[i][j] = 1;
               }
            }
        }

        while(!q.isEmpty()) {
            Pair cur = new Pair(q.peek().y, q.peek().x);
            q.remove();

            for(int i = 0; i < 4; i++) {
                int ny = cur.y + dy[i];
                int nx = cur.x + dx[i];
                
                if(ny >= n || ny < 0 || nx >= m || nx < 0) continue;
                if(board[ny][nx] == '#' || fVisit[ny][nx] > 0) continue;
                fVisit[ny][nx] = fVisit[cur.y][cur.x] + 1;
                q.add(new Pair(ny, nx));
            }
        }
        
        q.add(new Pair(jy, jx));
        jVisit[jy][jx] = 1;
        
        while(!q.isEmpty()) {
            Pair cur = new Pair(q.peek().y, q.peek().x);
            q.remove();

            for(int i = 0; i < 4; i++) {
                int ny = cur.y + dy[i];
                int nx = cur.x + dx[i];

                if(ny >= n || ny < 0 || nx >= m || nx < 0) {
                    System.out.println(jVisit[cur.y][cur.x]);
                    System.exit(0);
                }
                if(board[ny][nx] == '#' || jVisit[ny][nx] > 0) continue;
                if(fVisit[ny][nx] != 0 && fVisit[ny][nx] <= jVisit[cur.y][cur.x] + 1) continue;
                jVisit[ny][nx] = jVisit[cur.y][cur.x] + 1;
                q.add(new Pair(ny, nx));
            }
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                System.out.print(jVisit[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();

        System.out.println("IMPOSSIBLE");
    }

    static class Pair {
        int y;
        int x;

        public Pair() {}

        public Pair(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}

package 알고리즘_2차;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_P11403_경로_찾기 {

    static int[][] board = new int[104][104];
    static int[][] visit = new int[104][104];
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        StringTokenizer st;
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i < n; i++) {
            go(i, i);
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                System.out.print(visit[i][j] + " ");
            }
            System.out.println();
        }
    }

    static void go(int a, int b) {
        for(int i = 0; i < n; i++) {
            if(board[a][i] == 0 || visit[b][i] == 1) continue;
            visit[b][i] = 1;
            go(i, b);
        }
    }
}

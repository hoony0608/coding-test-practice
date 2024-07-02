package 알고리즘_3차;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_S2_P18111_마인크래프트 {

    static int n, m;
    static long b;
    static int[][] board = new int[504][504];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        b = Long.parseLong(st.nextToken());

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int answerHeight = 0, spendTime, answerTime = 128000000;
        long nowB;

        for(int h = 0; h <= 256; h++) {
            spendTime = 0;
            nowB = b;
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < m; j++) {
                    if(h > board[i][j]) {
                        spendTime += h - board[i][j];
                        nowB -= h - board[i][j];
                    } else if(h < board[i][j]) {
                        spendTime += (board[i][j] - h) * 2;
                        nowB += board[i][j] - h;
                    }
                }
            }
            if(nowB < 0) continue;
            if(answerTime >= spendTime) {
                answerTime = spendTime;
                answerHeight = h;
            }
        }

        System.out.println(answerTime + " " + answerHeight);
    }
}

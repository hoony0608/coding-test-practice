package 알고리즘_5차;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BOJ_S4_P2578_빙고 {
    static boolean[][] bingo_board = new boolean[5][5];
    static Map<Integer, Pair> m = new HashMap<>();
    static int totalLineNum;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for(int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 5; j++) {
                m.put(Integer.parseInt(st.nextToken()), new Pair(i, j));
            }
        }

        int cnt = 0, answer = 0;

        for(int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 5; j++) {
                if(answer != 0) break;
                cnt++;
                Pair p = m.get(Integer.parseInt(st.nextToken()));
                bingo_board[p.y][p.x] = true;
                totalLineNum += check(p.y, p.x);
                if(totalLineNum >= 3) answer = cnt;
            }
            if(answer != 0) break;
        }

        System.out.println(answer);
    }

    static int check(int a, int b) {
        int line = 4;

        for(int i = 0; i < 5; i++) {
            if(!bingo_board[a][i]) {
                line--;
                break;
            }
        }

        for(int i = 0; i < 5; i++) {
            if(!bingo_board[i][b]) {
                line--;
                break;
            }
        }

        if(a == b) {
            for(int i = 0; i < 5; i++) {
                if(!bingo_board[i][i]) {
                    line--;
                    break;
                }
            }
        } else line--;

        if(a + b == 4) {
            for(int i = 0; i < 5; i++) {
                if(!bingo_board[i][4-i]) {
                    line--;
                    break;
                }
            }
        } else line--;

        return line;
    }

    static class Pair {
        int y, x;

        public Pair(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}

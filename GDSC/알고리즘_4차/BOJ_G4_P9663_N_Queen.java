package 알고리즘_4차;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_G4_P9663_N_Queen {
    static boolean[] vertical = new boolean[15];
    static boolean[] diagonal1 = new boolean[30];
    static boolean[] diagonal2  = new boolean[30];
    static int n, cnt;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        go(0);
        System.out.println(cnt);
    }

    static void go(int a) {
        if(a == n) {
            cnt++;
            return;
        }

        for(int i = 0; i < n; i++) {
            if(vertical[i] || diagonal1[i + a] || diagonal2[a - i + n - 1]) continue;
            vertical[i] = true;
            diagonal1[i + a] = true;
            diagonal2[a - i + n - 1] = true;
            go(a + 1);
            vertical[i] = false;
            diagonal1[i + a] = false;
            diagonal2[a - i + n - 1] = false;
        }
    }
}

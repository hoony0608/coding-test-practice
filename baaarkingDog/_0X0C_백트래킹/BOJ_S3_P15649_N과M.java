package _0X0C_백트래킹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_S3_P15649_N과M {
    static boolean[] visited = new boolean[12];
    static int[] arr = new int[12];
    static int n, m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        go(0);
    }

    static void go(int x) {
        if(x == m) {
            for(int i = 0; i < m; i++) System.out.print(arr[i] + " ");
            System.out.println();
            return;
        }

        for(int i = 1; i <= n; i++) {
            if(visited[i]) continue;
            visited[i] = true;
            arr[x] = i;
            go(x + 1);
            visited[i] = false;
        }
    }
}

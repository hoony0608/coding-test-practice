package _0X08_BFS;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_P1697_숨바꼭질 {
    static int[] visit = new int[100004];
    static int[] d = {1, -1, 2};

    static int n, m, ans;
    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        visit[n] = 1;
        Queue<Integer> q = new LinkedList<>();
        q.add(n);

        while(!q.isEmpty()) {
            if(ans != 0) break;
            int cur = q.peek();
            q.remove();

            int nx = 0;
            for(int i = 0; i < 3; i++) {

                if(i == 2) nx = cur * d[i];
                else nx = cur + d[i];

                if(nx < 0 || nx > 100000) continue;
                if(visit[nx] > 0) continue;

                if(nx == m) ans = visit[cur];
                visit[nx] = visit[cur] + 1;
                q.add(nx);
            }
        }
        System.out.println(ans);
    }
}

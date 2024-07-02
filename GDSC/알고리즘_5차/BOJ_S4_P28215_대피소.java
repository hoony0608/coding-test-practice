package 알고리즘_5차;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_S4_P28215_대피소 {

    static int[][] arr = new int[54][2];
    static int n, k;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        int min_dist = Integer.MAX_VALUE;

        if (k == 1) {
            for(int i = 0; i < n; i++) {
                min_dist = Math.min(min_dist, func(i, i, i));
            }
        } else if (k == 2) {
            for(int i = 0; i < n - 1; i++) {
                for(int j = i + 1; j < n; j++) {
                    min_dist = Math.min(min_dist, func(i, i, j));
                }
            }
        } else {
            for(int i = 0; i < n - 2; i++) {
                for(int j = i + 1; j < n - 1; j++) {
                    for(int k = j + 1; k < n; k++) {
                        min_dist = Math.min(min_dist, func(i, j, k));
                    }
                }
            }
        }

        System.out.println(min_dist);
    }

    static int func(int a, int b, int c) {
        int dist = 0;

        for (int i = 0; i < n; i++) {
            int dist_a = Math.abs(arr[a][0] - arr[i][0]) + Math.abs(arr[a][1] - arr[i][1]);
            int dist_b = Math.abs(arr[b][0] - arr[i][0]) + Math.abs(arr[b][1] - arr[i][1]);
            int dist_c = Math.abs(arr[c][0] - arr[i][0]) + Math.abs(arr[c][1] - arr[i][1]);

            dist = Math.max(dist, Math.min(dist_c, Math.min(dist_b, dist_a)));
        }

        return dist;
    }
}

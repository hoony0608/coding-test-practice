package 알고리즘_2차;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_P9095_123_더하기 {

    static int[] arr = new int[14];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        arr[1] = 1;
        arr[2] = 2;
        arr[3] = 4;

        while(t-- != 0) {
            int n = Integer.parseInt(br.readLine());
            System.out.println(func(n));
        }
    }

    static int func(int x) {
        if(arr[x] == 0) {
            arr[x] = func(x - 1) + arr[x - 2] + arr[x - 3];
        }

        return arr[x];
    }

}

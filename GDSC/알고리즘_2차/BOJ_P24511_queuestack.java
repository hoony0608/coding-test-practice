package 알고리즘_2차;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_P24511_queuestack {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] arr = new int[100004];
        Queue<Integer> q = new LinkedList<>();
        Stack<Integer> s = new Stack<>();

        int n = Integer.parseInt(br.readLine());
        int temp;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            temp = Integer.parseInt(st.nextToken());
            if(arr[i] == 0) {
                s.push(temp);
            }
        }

        while(!s.isEmpty()) {
            q.add(s.pop());
        }

        int m = Integer.parseInt(br.readLine());
        StringBuilder ans = new StringBuilder();
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < m; i++) {
            temp = Integer.parseInt(st.nextToken());
            q.add(temp);
            ans.append(q.remove()).append(" ");
        }

        System.out.println(ans);
    }
}

package 알고리즘_1차;


import java.io.*;
import java.util.Objects;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BOJ_P18258_큐2 {

    static int[] q = new int[2000004];
    static int head = 0, tail = 0;
    static StringBuilder sb = new StringBuilder();

    static void push(int temp) {
        q[tail++] = temp;
    }

    static void pop() {
        head++;
    }

    static void front() {
        sb.append(q[head]).append("\n");
    }

    static void back() {
        sb.append(q[tail - 1]).append("\n");
    }

    static int size() {
        return tail - head;
    }

    static int empty() {
        return (tail == head) ? 1 : 0;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        String cmd;

        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            cmd = st.nextToken();
            if(Objects.equals(cmd, "push")) {
                push(Integer.parseInt(st.nextToken()));
            } else if(Objects.equals(cmd, "pop")) {
                if(empty() == 1) sb.append(-1).append("\n");
                else {
                    front();
                    pop();
                }
            } else if(Objects.equals(cmd, "size")) {
                sb.append(size()).append("\n");
            } else if(Objects.equals(cmd, "empty")) {
                sb.append(empty()).append("\n");
            } else if(Objects.equals(cmd, "front")) {
                if(empty() == 1) sb.append(-1).append("\n");
                else front();
            } else if(Objects.equals(cmd, "back")) {
                if(empty() == 1) sb.append(-1 ).append("\n");
                else back();
            }
        }
        System.out.println(sb);
    }

}

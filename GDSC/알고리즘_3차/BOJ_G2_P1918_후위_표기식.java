package 알고리즘_3차;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class BOJ_G2_P1918_후위_표기식 {
    static Map<Character, Integer> op = new HashMap<>();
    static Stack<Character> s = new Stack<>();
    public static void main(String[] args) throws IOException {
        op.put('(', 1);
        op.put('+', 2);
        op.put('-', 2);
        op.put('*', 3);
        op.put('/', 3);

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] cArr = br.readLine().toCharArray();
        StringBuilder sb = new StringBuilder();

        for(char c: cArr) {
            if(c == '\n' || c == ' ') continue;
            if (c - 'A' < 0 || c - 'Z' > 0) {
                if(s.isEmpty() || c == '(') s.push(c);
                else {
                    if(c == ')') {
                        while(s.peek() != '(') {
                            sb.append(s.pop());
                        }
                        s.pop();
                    } else {
                        if(op.get(c) <= op.get(s.peek())) {
                            while(!s.isEmpty() && op.get(c) <= op.get(s.peek()) && s.peek() != '(') {
                                sb.append(s.pop());
                            }
                        }
                        s.push(c);
                    }
                }
            }
            else sb.append(c);
        }

        while(!s.isEmpty()) {
            sb.append(s.pop());
        }

        System.out.println(sb);
    }
}

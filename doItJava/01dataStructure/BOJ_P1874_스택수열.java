import java.io.*;
import java.util.Scanner;
import java.util.Stack;

public class BOJ_P1874_스택수열 {
    static Stack<Integer> S = new Stack<>();
    static int n, m, stkNum = 0;
    static StringBuffer bf = new StringBuffer();
    static boolean flag = false;
    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);

        n = scanner.nextInt();

        S.push(stkNum++);

        for(int i = 0; i < n; i++) {
            m = scanner.nextInt();

            while(stkNum <= m) {
                S.push(stkNum++);
                bf.append("+\n");
            }

            if(S.peek() != m) {
                flag = true;
                break;
            }

            S.pop();
            bf.append("-\n");
        }


        if(flag) System.out.println("NO\n");
        else System.out.println(bf.toString());
    }
}

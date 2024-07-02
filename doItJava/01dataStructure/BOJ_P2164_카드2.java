import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class BOJ_P2164_카드2 {
    public static void main(String[] args) {
        Queue<Integer> que = new LinkedList<>();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

            for(int i = 1; i <= n; i++) que.add(i);

            while(que.size() != 1) {
                que.remove();
                que.add(que.peek());
                que.remove();
            }

            System.out.println(que.peek());

    }
}

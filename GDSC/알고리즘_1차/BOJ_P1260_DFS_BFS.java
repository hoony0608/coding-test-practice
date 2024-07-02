package 알고리즘_1차;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_P1260_DFS_BFS {

    static int n, m, start_point, y, x;

    static int[][] board = new int[1004][1004];
    static int[] dfsVisited = new int[1004];
    static int[] bfsVisited = new int[1004];

    static Queue<Integer> dfsQ = new LinkedList<>();
    static Queue<Integer> bfsQ = new LinkedList<>();

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        start_point = sc.nextInt();

        for(int i = 0; i < m; i++) {
            y = sc.nextInt();
            x = sc.nextInt();
            board[y][x] = 1;
            board[x][y] = 1;
        }

        dfs(start_point);
        bfs(start_point);

        while(!dfsQ.isEmpty()) {
            System.out.print(dfsQ.peek() + " ");
            dfsQ.remove();
        }

        System.out.println();

        while(!bfsQ.isEmpty()) {
            System.out.print(bfsQ.peek() + " ");
            bfsQ.remove();
        }

    }

    static void dfs(int start) {
        dfsVisited[start] = 1;
        dfsQ.add(start);

        for(int i = 1; i <= n; i++) {
            if(dfsVisited[i] == 1) continue;
            if(board[start][i] == 0 || board[i][start] == 0) continue;

            dfs(i);
        }
    }

    static void bfs(int start) {
        bfsVisited[start]= 1;

        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        bfsQ.add(start);

        while(!q.isEmpty()) {

            int cur = q.peek();
            q.remove();

            for(int i = 1; i <= n; i++) {
                if(bfsVisited[i] == 1) continue;
                if(board[cur][i] == 0 || board[i][cur] == 0) continue;

                q.add(i);
                bfsQ.add(i);
                bfsVisited[i] = 1;
            }
        }
    }

}

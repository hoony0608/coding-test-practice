package 알고리즘_4차;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Prim_Impl_Practice {
    static List<Edge>[] list = new ArrayList[6];
    static boolean[] visited = new boolean[6];
    static int sum = 0;
    public static void main(String[] args) throws IOException {
        for(int i = 0; i < 6; i++) {
            list[i] = new ArrayList<>();
        }

        int t = 10;
        int a, b, fee;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        while(t-- > 0) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            fee = Integer.parseInt(st.nextToken());

            list[a].add(new Edge(fee, b));
            list[b].add(new Edge(fee, a));
        }
        prim();
        System.out.println(sum);

    }

    static void prim() {
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.add(new Edge(0, 0));

        while(!pq.isEmpty()) {
            Edge edge = pq.poll();
            int node = edge.node;
            int fee = edge.fee;

            if(visited[node]) continue;
            visited[node] = true;
            sum += fee;

            for(Edge next: list[node]) {
                if(visited[next.node]) continue;
                pq.add(next);
            }
        }
    }

    static class Edge implements Comparable<Edge>{
        int fee, node;

        Edge(int fee, int node) {
            this.fee = fee;
            this.node = node;
        }


        @Override
        public int compareTo(Edge o) {
            return this.fee - o.fee;
        }
    }
}

package 알고리즘_4차;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_G4_P1647_도시_분할_계획_프림 {
    static List<Edge>[] list;
    static boolean[] visited;
    static long sum, remove = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        list = new List[v + 4];
        visited = new boolean[v + 4];

        for(int i = 1; i <= v; i++) {
            list[i] = new ArrayList<>();
        }
        int a, b, fee;
        while(e-- > 0) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            fee = Integer.parseInt(st.nextToken());
            list[a].add(new Edge(fee, b));
            list[b].add(new Edge(fee, a));
        }
        prim();
        System.out.println(sum - remove);
    }

    static void prim() {
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.add(new Edge(0, 1));

        while(!pq.isEmpty()) {
            Edge edge = pq.poll();
            int fee = edge.fee;
            int node = edge.node;

            if (visited[node]) continue;
            System.out.println("방문한 노드: " + node);
            System.out.println("가중치: " + fee);
            System.out.println();
            visited[node] = true;
            sum += fee;
            remove = Math.max(remove, fee);

            for(Edge next: list[node]) {
                if (visited[next.node]) continue;
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

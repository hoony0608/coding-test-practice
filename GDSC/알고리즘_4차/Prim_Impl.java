package 알고리즘_4차;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Prim_Impl {
    static List<Pair>[] list = new ArrayList[10];
    static boolean[] visited = new boolean[6];
    static int sum;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        

        int t = 10;
        int a, b, fee;
        
        for(int i = 0; i < 10; i++) {
            list[i] = new ArrayList<>();
        }
        
        while(t-- != 0) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            fee = Integer.parseInt(st.nextToken());

            list[a].add(new Pair(fee, b));
            list[b].add(new Pair(fee, a));
        }
        prim();
        System.out.println(sum);
    }

    static void prim() {
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(0, 0));
        while(!pq.isEmpty()) {
            Pair p = pq.poll();
            int fee = p.fee;
            int a = p.a;

            if(visited[a]) continue;
            visited[a] = true;
            sum += fee;
            
            for(Pair next: list[a]) {
                if(visited[next.a]) continue;
                pq.add(next);
            }
        }
    }

    static class Pair implements Comparable<Pair> {
        int fee, a;

        Pair(int fee, int a) {
            this.fee = fee;
            this.a = a;
        }


        @Override
        public int compareTo(Pair o) {
            return this.fee - o.fee;
        }
    }
}

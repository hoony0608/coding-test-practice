package 알고리즘_4차;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_G4_P1647_도시_분할_계획_크루스칼 {
    static int[] parent = new int[100004];
    static ArrayList<Edge> arr = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        long answer = 0, remove = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        for(int i = 1; i <= n; i++) parent[i] = i;

        int a, b, fee;
        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            fee = Integer.parseInt(st.nextToken());

            arr.add(new Edge(a, b, fee));
        }

        arr.sort((o1, o2) -> o1.fee - o2.fee);

        for(int i = 0; i < arr.size(); i++) {
            a = arr.get(i).a;
            b = arr.get(i).b;
            fee = arr.get(i).fee;
            if(!findParent(a, b)) {
                answer += fee;
                unionParent(a, b);
                remove = fee;
            }
        }

        System.out.println(answer - remove);
    }

    static int getParent(int x) {
        if(parent[x] == x) return x;
        else return parent[x] = getParent(parent[x]);
    }

    static boolean findParent(int a, int b) {
        a = getParent(a);
        b = getParent(b);

        return a == b;
    }

    static void unionParent(int a, int b) {
        a = getParent(a);
        b = getParent(b);
        if(a < b) parent[b] = a;
        else parent[a] = b;
    }

    static class Edge {
        int a, b, fee;

        public Edge(int a, int b, int fee) {
            this.a = a;
            this.b = b;
            this.fee = fee;
        }
    }

}

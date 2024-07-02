package 알고리즘_4차;

import java.util.ArrayList;

public class Kruskal_Impl_practice {
    static ArrayList<Edge> arr = new ArrayList<>();
    static int[] parent = new int [6];
    public static void main(String[] args) {
        int answer = 0;
        for(int i = 0; i < 6; i++) parent[i] = i;

        arr.add(new Edge(0, 1, 16));
        arr.add(new Edge(0, 2, 21));
        arr.add(new Edge(0, 4, 19));
        arr.add(new Edge(1, 2, 11));
        arr.add(new Edge(1, 3, 5));
        arr.add(new Edge(1, 5, 6));
        arr.add(new Edge(2, 4, 33));
        arr.add(new Edge(2, 5, 14));
        arr.add(new Edge(3, 5, 10));
        arr.add(new Edge(4, 5, 18));

        arr.sort((o1, o2) -> o1.fee - o2.fee);
        int a, b, fee;
        for(int i = 0; i < arr.size(); i++) {
            a = arr.get(i).a;
            b = arr.get(i).b;
            fee = arr.get(i).fee;

            if(!findParent(a, b)) {
                unionParent(a, b);
                answer += fee;
            }
        }

        System.out.println(answer);
    }

    static int getParent(int x) {
        if(parent[x] == x) return x;
        else return parent[x] = getParent(parent[x]);
    }

    static void unionParent(int a, int b) {
        a = getParent(a);
        b = getParent(b);
        if(a < b) parent[b] = a;
        else parent[a] = b;
    }

    static boolean findParent(int a, int b) {
        a = getParent(a);
        b = getParent(b);
        return a == b;
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

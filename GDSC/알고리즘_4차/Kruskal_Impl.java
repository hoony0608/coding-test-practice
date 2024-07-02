package 알고리즘_4차;

import java.util.ArrayList;
import java.util.Comparator;

import static java.util.Arrays.sort;

public class Kruskal_Impl {

    static ArrayList<Edge> arr = new ArrayList<>();
    static int answer;
    static int[] parent = new int[6];
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

        // 간선을 가중치 기준 오름차순으로 정렬
        arr.sort((o1, o2) -> o1.fee - o2.fee);

        System.out.println("사용된 간선");

        // 모든 간선을 가중치가 낮은 순서대로 검사
        for(int i = 0; i < arr.size(); i++) {
            int a = arr.get(i).a;
            int b = arr.get(i).b;
            int fee = arr.get(i).fee;
            if(!findParent(a, b)) {
                answer += fee;
                unionParent(a, b);
                System.out.println("가중치: " + fee);
                System.out.println("a: " + a + ", b: " + b);
            }
        }

        System.out.println(answer);
    }

    // 정점에 연결된 부모 정점을 반환
    static int getParent(int x) {
        if (parent[x] == x) return x;
        // 연결되어있는 부모 정점을 반환하는 동시에,
        // 연결되어있는 정점들의 부모 정점을 갱신
        else return parent[x] = getParent(parent[x]);
    }

    // 두 정점을 연결
    static void unionParent(int a, int b) {
        a = getParent(a);
        b = getParent(b);
        if(a < b) parent[b] = a;
        else parent[a] = b;
    }

    static boolean findParent(int a, int b) {
        a = getParent(a);
        b = getParent(b);
        return (a == b);
    }


    static class Edge{
        int a, b, fee;

        public Edge(int a, int b, int fee) {
            this.a = a;
            this.b = b;
            this.fee = fee;
        }
    }
}

package 알고리즘_5차;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_S2_P11279_최대_힙 {

    static int[] maxHeapTree = new int[100004];
    static int n, tail;

    public static void main(String[] args) throws IOException {
        ArrayList<Integer> answer = new ArrayList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());

        while(n-- > 0) {
            st = new StringTokenizer(br.readLine());
            int input = Integer.parseInt(st.nextToken());
            if(input == 0) {
                if(tail == 0) answer.add(0);
                else {
                    answer.add(maxHeapTree[0]);
                    remove();
                }
            } else add(input);
            System.out.println("input: " + input);
            for(int i = 0; i < tail; i++) {
                System.out.print(i + ": " + maxHeapTree[i]);
                if(i >= 1) System.out.print(", parent: " + ((i + 1) / 2 - 1) + ": " + maxHeapTree[(i + 1) / 2 - 1]);
                System.out.println();
            }
            System.out.println();
        }

        for(int i: answer) System.out.println(i);

    }

    static void add(int a) {
        maxHeapTree[tail++] = a;
        bottomUpSort();
    }

    static void remove() {
        int temp = maxHeapTree[tail - 1];
        maxHeapTree[tail - 1] = maxHeapTree[0];
        maxHeapTree[0] = temp;
        tail--;
        topDownSort();
    }

    private static void topDownSort() {
        for(int i = 0; i < tail - 1;) {
            int child = (i + 1) * 2 - 1;
            if(tail <= child) break;
            if(tail > child + 1 && maxHeapTree[child] < maxHeapTree[child + 1]) child++;
            if(maxHeapTree[i] < maxHeapTree[child]) {
                int temp = maxHeapTree[i];
                maxHeapTree[i] = maxHeapTree[child];
                maxHeapTree[child] = temp;
            }
            i = child;
        }
    }

    static void bottomUpSort() {
       for(int i = tail - 1; i > 0;) {
           if(i % 2 == 0) {
               if(maxHeapTree[i] < maxHeapTree[i - 1]) i = i - 1;
           } else if(i + 2 < tail && maxHeapTree[i] < maxHeapTree[i + 1]) {
               i = i + 1;
           }
           int parent = (i + 1) / 2 - 1;

           if(maxHeapTree[i] > maxHeapTree[parent]) {
               int temp = maxHeapTree[i];
               maxHeapTree[i] = maxHeapTree[parent];
               maxHeapTree[parent] = temp;
           }

           i = parent;
       }
    }
}

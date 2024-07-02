package PriorityQueue_0x17;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_S2_P1927_최소_힙 {

    static int[] heap = new int[100005];
    static int sz = 0, temp; // heap에 들어있는 원소의 수
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        while(t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            if(n == 0) {
                if(sz == 0) System.out.println(0);
                else {
                    System.out.println(top());
                    pop();
                }
            } else {
                push(n);
            }
        }
    }

    static void push(int x) {
        heap[++sz] = x;
        int idx = sz;

        while(idx > 1) {
            int par = idx / 2;
            if (heap[idx] < heap[par]) {
                temp = heap[idx];
                heap[idx] = heap[par];
                heap[par] = temp;
            }
            idx = par;
        }
    }
    static int top() {
        return heap[1];
    }

    static void pop() {
        heap[1] = heap[sz--];

        int idx = 1;
        while(idx * 2 <= sz) {
            int lc = idx * 2, rc = idx * 2 + 1;
            int minChild = lc;
            if(rc <= sz && heap[lc] > heap[rc]) minChild = rc;
            if(heap[idx] < heap[minChild]) break;
            temp = heap[idx];
            heap[idx] = heap[minChild];
            heap[minChild] = temp;
            idx = minChild;
        }
    }
}

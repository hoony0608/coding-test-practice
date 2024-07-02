package PriorityQueue_0x17;

public class Priority_Queue_Impl {

    static int[] heap = new int[100005];
    static int sz = 0, temp; // heap에 들어있는 원소의 수
    public static void main(String[] args) {
        test();
    }

    static void push(int x) {
        heap[++sz] = x;
        int idx = sz;
        while(idx != 1) {
            int par = idx / 2;
            if(heap[par] <= heap[idx]) break;
            temp = heap[par];
            heap[par] = heap[idx];
            heap[idx] = temp;
            idx = par;
        }
    }
    static int top() {
        return heap[1];
    }

    static void pop() {
       heap[1] = heap[sz--];
       int idx = 1;

       while(2 * idx <= sz) {
           int lc = 2 * idx;
           int rc = 2 * idx + 1;

           int min_child = lc;

           if (rc <= sz && heap[rc] < heap[lc]) {
               min_child = rc;
           }
           if (heap[idx] <= heap[min_child]) break;
           temp = heap[min_child];
           heap[min_child] = heap[idx];
           heap[idx] = temp;
           idx = min_child;
       }
    }


    static void test() {
        push(8);
        push(12);
        push(13);
        push(16);
        push(16);
        push(21);
        push(23);
        push(18);
        push(19);
        push(30);
        push(22);
        push(31);
        push(25);
        push(24);
        push(52);
        pop();
        System.out.println(top());
        pop();
        System.out.println(top());
    }
}

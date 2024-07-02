package 알고리즘_4차;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.StringTokenizer;

public class BOJ_S1_P1991_트리_순회 {
    static Map<String, Tree> treeMap = new HashMap<>();
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;
        String a, b, c;
        while(t-- != 0) {
            st = new StringTokenizer(br.readLine());
            a = st.nextToken();
            b = st.nextToken();
            c = st.nextToken();

            Tree tree = new Tree();
            tree.setTree(b, c);

            treeMap.put(a, tree);
        }


        sb = new StringBuilder();
        preOrder("A");
        System.out.println(sb);

        sb = new StringBuilder();
        inOrder("A");
        System.out.println(sb);

        sb = new StringBuilder();
        postOrder("A");
        System.out.println(sb);
    }

    static void preOrder(String node) {
        sb.append(node);
        if(treeMap.get(node) == null) return;
        if(!Objects.equals(treeMap.get(node).left, "."))
            preOrder(treeMap.get(node).left);
        if(!Objects.equals(treeMap.get(node).right, "."))
            preOrder(treeMap.get(node).right);
    }

    static void inOrder(String node) {

        if(treeMap.get(node) != null && !Objects.equals(treeMap.get(node).left, "."))
            inOrder(treeMap.get(node).left);
        sb.append(node);
        if(treeMap.get(node) != null && !Objects.equals(treeMap.get(node).right, "."))
            inOrder(treeMap.get(node).right);
    }

    static void postOrder(String node) {
        if(treeMap.get(node) != null) {
            if(!Objects.equals(treeMap.get(node).left, "."))
                postOrder(treeMap.get(node).left);
            if(!Objects.equals(treeMap.get(node).right, "."))
                postOrder(treeMap.get(node).right);
        }
        sb.append(node);
    }

    static class Tree {
        String left = ".", right = ".";

        void setTree(String left, String right) {
            this.left = left;
            this.right = right;
        }
    }
}

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_P12865_평범한_배낭 {

    static int n;
    static int k;
    static int maxValue = 0;
    static int[][] things = new int[104][104];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        k = sc.nextInt();

        for(int i = 0; i < n; i++) {
            things[i][0] = sc.nextInt();
            things[i][1] = sc.nextInt();
        }

//        Arrays.sort(things, 0, n, (ele1, ele2) -> {
//            if(ele1[0] == ele2[0]) return Integer.compare(ele2[1], ele1[1]);
//            else return Integer.compare(ele1[0], ele2[0]);
//        });

        func(0, 0, 0);

        System.out.println(maxValue);

    }


    static void func(int wSum, int vSum, int count) {

        if(wSum > k) return;
        if(count == n) {
            if(vSum > maxValue) maxValue = vSum;
            return;
        }

        func(wSum, vSum, count + 1);
        wSum += things[count][0];
        vSum += things[count][1];
        func(wSum, vSum, count + 1);
    }

}

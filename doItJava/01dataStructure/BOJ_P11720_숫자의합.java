import java.util.Scanner;

public class BOJ_P11720_숫자의합 {
    public static void main(String[] args) {
    /**
     * 1. 입력 숫자의 갯수를 int 형으로 저장
     * 2. 입력 숫자를 String 형으로 저장
     * 3. String 형을 toCharArray를 사용해 char 배열로 변환
     * 4. char 배열에서 하나씩 꺼내 int 형으로 변환 후 합을 구함
     *
     */

    int sum = 0;
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    String sNum = sc.next();
    char[] cNum = sNum.toCharArray();

    for(int i = 0; i < cNum.length; i++) {
        sum += (cNum[i] - '0');
    }

    System.out.println(sum);

    }
}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_P12891_비밀번호 {

    static int[] checkArr;
    static int[] myArr;
    static int checkSecret = 0;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 전체 문자열 길이와 부분 문자열 길이 받기
        int n = Integer.parseInt(st.nextToken());
        int length = Integer.parseInt(st.nextToken());

        checkArr = new int[4];
        myArr = new int[4];
        char[] A = new char[n];
        int answer = 0;

        // 전체 문자열 받기
        A = br.readLine().toCharArray();
        st = new StringTokenizer(br.readLine());


        for(int i = 0; i < 4; i++) {
            checkArr[i] = Integer.parseInt(st.nextToken());
            if(checkArr[i] == 0) {
                checkSecret++;
            }
        }

        // 부분문자열 처음 받을 때
        for(int i = 0; i < length; i++) {
            Add(A[i]);
        }

        if(checkSecret == 4) answer++;

        for(int i = length; i < n; i++) {
            int j = i - length;
            Remove(A[j]);
            Add(A[i]);
            if(checkSecret == 4) answer++;
        }

        System.out.println(answer);
    }

    private static void Remove(char c) {
        int numDna = -1;
        if(c == 'A') {
            numDna = 0;
        } else if (c == 'C') {
            numDna = 1;
        } else if (c == 'G') {
            numDna = 2;
        } else  {
            numDna = 3;
        }
        myArr[numDna]--;
        if(checkArr[numDna] - myArr[numDna] == 1) checkSecret--;
    }

    private static void Add(char c) {
        int numDna = -1;
        if(c == 'A') {
            numDna = 0;
        } else if (c == 'C') {
            numDna = 1;
        } else if (c == 'G') {
            numDna = 2;
        } else  {
            numDna = 3;
        }
        myArr[numDna]++;
        if(myArr[numDna] == checkArr[numDna]) checkSecret++;
    }
}

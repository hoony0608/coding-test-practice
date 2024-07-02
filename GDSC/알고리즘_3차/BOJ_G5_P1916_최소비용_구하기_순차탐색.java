package 알고리즘_3차;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 순차 탐색
public class BOJ_G5_P1916_최소비용_구하기_순차탐색 {
    static int [][] board = new int[1004][1004];
    static int [] dist = new int[1004];
    static int [] visit = new int[1004];
    static int n, m, s, e, y, x;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        // 경로를 -1로 초기화
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= n; j++) {
                board[i][j] = -1;
            }
        }

        // 비용을 최대로 초기화
        for(int i = 1; i <= n; i++) {
            dist[i] = 100000000;
        }

        StringTokenizer st;
        int temp = 0;
        for(int i = 0; i < m; i++) {
            // 해당 경로가 입력된 적 없거나 같은 경로인데 비용이 적으면 저장
            st = new StringTokenizer(br.readLine());
            y = Integer.parseInt(st.nextToken());
            x = Integer.parseInt(st.nextToken());
            temp = Integer.parseInt(st.nextToken());
            if(board[y][x] == -1 || board[y][x] > temp) board[y][x] = temp;
        }

        st = new StringTokenizer(br.readLine());
        s = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());

        // 출발점의 비용을 0, 방문했음을 나타냄
        dist[s] = 0;
        visit[s] = 1;
        int minDist;

        // 도착점에 방문할 떄까지 반복
        while (visit[e] != 1) {
            // 최소 비용으로 비교할 값을 최대로 설정 ( 1000 * 100,000)
            minDist = 100000000;
            // 노드를 순환
            for(int i = 1; i <= n; i++) {
                // 방문했다면 건너뛰기
                if (visit[i] == 1) continue;
                // 시작점에서 지정한 노드까지 경로가 존재하면 실행
                if (board[s][i] != -1) {
                    // 테이블에 저장된 비용과 출발점에서 시작점까지의 비용 + 시작점에서 지정한 노드까지의 비용을 비교
                    dist[i] = Math.min(dist[i], board[s][i] + dist[s]);
                }
                // 순환한 노드 중 최소 비용인 노드를 지정
                if (minDist > dist[i]) {
                    minDist = dist[i];
                    temp = i;
                }
            }
            // 최소 비용인 노드를 방문하고, 다음 순환의 시작점을 해당 노드로 지정
            visit[temp] = 1;
            s = temp;
        }

        System.out.println(dist[e]);
    }
}

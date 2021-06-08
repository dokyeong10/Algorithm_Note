package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_1966_프린터큐 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb =new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int test_case = 1; test_case <= T; test_case++) {
            st = new StringTokenizer(br.readLine(), " ");
            int N = Integer.parseInt(st.nextToken()); // 문서의 개수
            int M = Integer.parseInt(st.nextToken()); // 궁금한 문서 위치
            Queue<word> q = new LinkedList<>();
            PriorityQueue<word> pq = new PriorityQueue<>();
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                int impor = Integer.parseInt(st.nextToken());  // 중요도
                pq.offer(new word(i, impor)); //시간 중요도
                q.offer(new word(i, impor));
            }
            int cnt = 0;
            while (q.size() > 0) {
                word tmp; // 임시
                if (q.peek().impor == pq.peek().impor) {
                    tmp = q.poll();
                    pq.poll();
                    cnt++;
                    if (tmp.idx == M) {
                        sb.append(cnt).append('\n');
                    }
                } else {
                    tmp = q.poll();
                    q.offer(tmp);
                }
            }
        } // end of TC
        System.out.println(sb);
    } // end of main
} // end of class

class word implements Comparable<word> {
    int idx; // 시간
    int impor; // 중요도

    public word(int idx, int impor) {
        this.idx = idx;
        this.impor = impor;
    }

    @Override
    public int compareTo(word o) {
        return -(this.impor - o.impor); // 내림 차순
    }
}
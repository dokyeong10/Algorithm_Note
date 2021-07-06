package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_나무자르기_2805 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken()); // 나무 수
        int M = Integer.parseInt(st.nextToken()); // 나무 높이 필요
        int tree[] = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            tree[i] = Integer.parseInt(st.nextToken());
        } // 입력 받기 완료
        int low = 0;
        int high = 2000000000;
        int mid = 0;
        int result = 0;
        while (low <= high) {
            long sum = 0;
            mid = (high + low) / 2;
            for (int i = 0; i < N; i++) {
                if (tree[i] > mid) {
                    sum += tree[i] - mid;
                }
            }
            if (sum < M) {
                high = mid - 1;
            } else if (sum >= M) {
                result = Math.max(mid, result);
                low = mid + 1;
            }
        }
        System.out.println(result);

    } // end of main

} // end of class

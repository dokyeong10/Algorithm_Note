package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1654_랜선자르기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int K = Integer.parseInt(st.nextToken()); // 가진 랜선 개수
        int N = Integer.parseInt(st.nextToken()); // 필요 랜선 개수
        long len[] = new long[K];
        long max = -1;
        for (int i = 0; i < K; i++) {
            len[i] = Integer.parseInt(br.readLine());
            max = Math.max(len[i], max);
        } /// 입력 받기 완료
        long low = 1;
        long high = max;
        long mid = 0;
        long result = 0;
        while (low <= high) {
            long sum = 0;
            mid = (low + high) / 2;
            for (int i = 0; i < K; i++) {
                if (len[i] >= mid && mid != 0) {
                    sum += len[i] / mid;
                }
            }
            if (sum < N) {
                high = mid - 1;
            } else if (sum >= N) {
                low = mid + 1;
                result = Math.max(result, mid);
            }
        }
        System.out.println(result);

    } // end of main
} // end of class

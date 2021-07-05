package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_1920_수찾기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int Arr[] = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            Arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(Arr);

        int M = Integer.parseInt(br.readLine());
        int mid = 0;
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < M; i++) {
            int left = 0;
            int right = N - 1;
            int Marr = Integer.parseInt(st.nextToken());
            while (left <= right) {
                mid = (left + right) / 2;
                if (Marr == Arr[mid]) {
                    sb.append(1).append("\n");
                    break;
                } else if (Marr < Arr[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            if (Marr != Arr[mid]) {
                sb.append(0).append("\n");
            }
        }
        System.out.println(sb);

    } // end of main
    //1 3 5 7 9 11 13 15 17
    //


} // end of class

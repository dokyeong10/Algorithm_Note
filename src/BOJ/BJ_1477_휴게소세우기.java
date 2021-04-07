package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_1477_휴게소세우기 {
    static int N, M, L;
    static int[] rest;
    static int left, right;
    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken()); //휴게소 개수
        M = Integer.parseInt(st.nextToken()); //지을라는 휴게소 개수
        L = Integer.parseInt(st.nextToken()); //고속도로 길이
        rest = new int[N + 2];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i <= N; i++) {
            rest[i] = Integer.parseInt(st.nextToken());
        } //// 휴게소의 위치 입력 받기 완료 ///////

        rest[0] = 0; //도로의 처음
        rest[N + 1] = L; //도로의 끝
        Arrays.sort(rest); //휴게소 위치 정렬

        binarySearch(); //이분 탐색
        System.out.println(left);

    } // end of main
    // 0 82 201 411 555 622 755 800
    //  mid = 휴게소 설치 후 거리중 최대값

    private static void binarySearch() {
        left = 0;
        right = L;

        while (left <= right) {
            int mid = (left + right) / 2;
            int sum = 0;
            for (int i = 1; i < N + 2; i++) {
                // 휴게소 사이 거리가 mid라고 했을때 현재 세워진 휴게소 사이에 새로 끼워 넣을 수 있는 휴게소
                sum += (rest[i] - rest[i - 1] - 1) / mid;
            } //사이 공백 반 합
            //현재 mid의 거리 차이가 가능하다면 => 최대값을 찾기 위해 더 넓은 범위 탐색
            if (sum > M) left = mid + 1;
                //더 적게 세워야하면 간격 줄임
            else right = mid - 1;
        }
    }
} // end of class

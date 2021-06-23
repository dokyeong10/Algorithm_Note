package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;
/*
* 문제 요약
* 정해진 시간 있음
* 최대한 많은 회의 하도록 -> 최대 회의수는?
*
* 문제 아이디어
* 끝나는 시간순으로 오름차순 정렬
* time이 시작보다 작으면 횟수 +1,
* time = 끝나는 시간 이 됨.
*
* */
public class BJ_1931_회의실배정_3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int room[][] = new int[N][2];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int fir = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            room[i][0] = fir;
            room[i][1] = end;
        }
        // 끝나는 시간 순으로 정렬하기
        Arrays.sort(room, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1] == o2[1]) {
                    return o1[0] - o2[0];
                }
                return o1[1] - o2[0];
            }
        });
        int time = 0;
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            if (time <= room[i][0]) {
                time = room[i][1];
                cnt++;
            }
        }
        System.out.println(cnt);

    } // end of main 
} // end of class 

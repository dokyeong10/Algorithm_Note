package BOJ;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class BJ_1931_회의실배정 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] room = new int[N][2];

        for (int i = 0; i < N; i++) {
            room[i][0] = sc.nextInt(); //시작
            room[i][1] = sc.nextInt(); //종료
        }

        //끝나는 시간 기준 정렬

        Arrays.sort(room, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                //종료시간이 같으면 시작시간이 빠른순으로

                if (o1[1] == o2[1]) {
                    return o1[0] - o2[0];
                }
                return o1[1] - o2[1];
            }
        });

        int cnt = 0;
        int time = 0;

        for (int i = 0; i < N; i++) {
            //직전 종료시간이 다음 회의 시작시간보다 작거나 같다면 갱신
            if (time <= room[i][0]) {
                time = room[i][1];
                cnt++;
            }
        }
        System.out.println(cnt);

    } // end of main


}// end of class

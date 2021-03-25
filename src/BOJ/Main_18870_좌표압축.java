package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_18870_좌표압축 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int num[] = new int[N];
        int save[] = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            num[i] = Integer.parseInt(st.nextToken());
            save[i] = num[i]; // no sorting array
        } // 입력 받기 완료

        HashMap<Integer, Integer> map = new HashMap<>();
        Arrays.sort(num); //한개만 정렬해줌
        //  0   1 2 3 4
        // -10 -9 2 4 4

        // 2 1 2 1 2 1
        // 1 1 1 2 2 2
        // {1,0},{2,1}
        int cur = Integer.MAX_VALUE;
        int idx = 0; //번호 부여
        for (int i = 0; i < N; i++) { //중복 체크
            if (cur != num[i]) {
                map.put(num[i], idx++);
                cur = num[i];
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) sb.append(map.get(save[i])).append(" "); //순서는 원래 배열로
        System.out.println(sb);
    } // end of main
} // end of class

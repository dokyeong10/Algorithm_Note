package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ_3020_개똥벌레 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken()); // 동물 길이
        int H = Integer.parseInt(st.nextToken()); // 동물 높이
        int down[] = new int[H + 1];
        int up[] = new int[H + 1];
        for (int i = 0; i < N; i++) {
            int stone = Integer.parseInt(br.readLine());
            if (i % 2 == 1) up[stone]++;
            else down[stone]++;
        }
        for (int i = H - 1; i > 0; i--) {
            up[i] += up[i + 1];
            down[i] += down[i + 1];
        }
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 1; i <= H; i++) {
            list.add(up[i] + down[H - i + 1]);
        }
        Collections.sort(list);
        int min = list.get(0);
        int cnt = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == min) cnt++;
            else break;
        }
        System.out.println(min + " " + cnt);


    } // end of main
} // end of class

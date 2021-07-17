package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_10815_숫자찾기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cardN = Integer.parseInt(br.readLine());
        int card[] = new int[cardN];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < cardN; i++) {
            card[i] = Integer.parseInt(st.nextToken());
        } // 갖고 있는 카드 번호
        int findM = Integer.parseInt(br.readLine());
        int find[] = new int[findM];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < findM; i++) {
            find[i] = Integer.parseInt(st.nextToken());
        } // 찾아야하는 카드 번호
        int answer[] = new int[findM];
        Arrays.sort(card);
        for (int i = 0; i < findM; i++) {
            int high = cardN - 1;
            int low = 0;
            int mid = 0;
            while (high >= low) {
                mid = (high + low) / 2;
                if (find[i] == card[mid]) {
                    answer[i] = 1;
                    break;
                } else if (find[i] < card[mid]) {
                    high = mid - 1;
                } else if (find[i] > card[mid]) {
                    low = mid + 1;
                }
            }
            if (find[i] != card[mid]) {
                answer[i] = 0;
            }
        }
        for (int i = 0; i < findM; i++) {
            System.out.print(answer[i] + " ");
        }
    } // end of main
} // end of class


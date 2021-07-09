package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BJ_9375_패션왕신해빈 {
    static int num, cnt;
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int TC = Integer.parseInt(br.readLine());
        for (int test_case = 1; test_case <= TC; test_case++) {
            HashMap<String, Integer> map = new HashMap<>();
            cnt = 0;
            num = Integer.parseInt(br.readLine());
            for (int i = 0; i < num; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                String name = st.nextToken();
                String type = st.nextToken();
                if (map.containsKey(type)) {
                    map.put(type, map.get(type) + 1);
                } else {
                    map.put(type, 1);
                }
            } /// 입력 완료
            int answer = 1;
            for (Integer value : map.values()) {
                answer *= value + 1;
            }
            System.out.println(answer - 1);
        } // end of tc
    } // end of main
} // end of class

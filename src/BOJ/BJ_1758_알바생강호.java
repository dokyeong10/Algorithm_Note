package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_1758_알바생강호 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N =Integer.parseInt(br.readLine());
        int tip[]= new int[N];
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
             st  = new StringTokenizer(br.readLine()," ");
            tip[i]=Integer.parseInt(st.nextToken());
        }
        Arrays.sort(tip);
        long result =0;
        int order=1;
        for (int i = N-1; i >=0 ; i--) {
            if(tip[i]-(order-1)<0) {
                result += 0;
                order++;
            }else {
                result += (long)tip[i] - (order - 1);
                order++; //
            }
        }
        System.out.println(result);
    } // end of main
} // end of class

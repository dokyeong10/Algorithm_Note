package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BJ_1931_회의실배정2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int cnt = 0;
        int room [][] =new int[N][2];
        for (int i = 0; i < N; i++) {
            StringTokenizer st =new StringTokenizer(br.readLine()," ");
            room[i][0]=Integer.parseInt(st.nextToken()); // 시작
            room[i][1]=Integer.parseInt(st.nextToken()); /// 끝
        }
       Arrays.sort(room, new Comparator<int[]>(){

           @Override
           public int compare(int[] o1, int[] o2) {
               if (o1[1]==o2[1]){
                   return o1[0]-o2[0];
               }
               return o1[1]-o2[1];
           }
       });
        int time =0;
        for (int i = 0; i < N; i++) {
            if(time<=room[i][0]){
                time =room[i][1];
                cnt++;
            }
        }
        System.out.println(cnt);




    } // end of main
} // end of class


package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_2458_키순서 {
    static int N,M,map[][];
    static int Max =100000;

    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =new StringTokenizer(br.readLine()," ");

        N=Integer.parseInt(st.nextToken()); // 학생수
        M=Integer.parseInt(st.nextToken()); // 비교 횟수
        map = new int [N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j]=Max;
            }
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine()," ");
            int num1 =Integer.parseInt(st.nextToken())-1;
            int num2 =Integer.parseInt(st.nextToken())-1;
            map[num1][num2]=1;
        }

        for (int k = 0; k < N; k++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    map[i][j]=Math.min(map[i][j],map[i][k]+map[k][j]);
                }
            }
        }
        int cnt =0;
        for (int i = 0; i < N; i++) {
            map[i][i]=0;
            boolean chk =true;
            for (int j = 0; j < N; j++) {
                if(Math.min(map[i][j],map[j][i])==Max){
                    chk =false;
                    break;
                }
            }
            if(chk)cnt++;
        }
        System.out.println(cnt);


    }// end of main

} // end of class

package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_17135_캐슬디펜스 {
    static int N, M ,D;
    static int map[][];


    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =new StringTokenizer(br.readLine()," ");
        N =Integer.parseInt(st.nextToken()); //행
        M=Integer.parseInt(st.nextToken());  //열
        D=Integer.parseInt(st.nextToken());  //거리 제한

        for (int i = 0; i < N; i++) {
            st =new StringTokenizer(st.nextToken());
            for (int j = 0; j < M; j++) {
                map[i][j]=Integer.parseInt(st.nextToken());
            }
        } //입력받기 완료 / / /



    } //end of main
}// end of class

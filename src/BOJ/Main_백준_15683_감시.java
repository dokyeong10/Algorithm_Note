package BOJ;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class Main_백준_15683_감시 {
    static int N,M,office[][];

    static int dr[]={-1,1,0,0};
    static int dc[]={0,0,-1,1}; //상하좌우
    static ArrayList<int[]>list = new ArrayList<>();
    // list 0 , r1,c1
    // list.add , r2,c2


    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
         N=sc.nextInt(); // 행
         M=sc.nextInt(); // 열

        office =new int [N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                office[i][j]=sc.nextInt();
            }
        } // 입력 받기 완료

        dfs(0);
    } //end of main

    static void dfs(int depth){
        for(int dir=0;dir<4;dir++ ){
            cctv(depth,dir);
            dfs(depth+1);
        }
    }

    static void cctv(int cctv,int dir){ // cctv의 종류, 방향
        int[] loc = new int[2]; // r,c;
        loc = list.get(cctv);
        int type = office[loc[0]][loc[1]];


    }
} // end of class

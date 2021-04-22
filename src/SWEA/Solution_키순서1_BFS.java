package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_키순서1_BFS {
    static int N,M,adj[][];

    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        int TC =Integer.parseInt(br.readLine());
        for (int test_case = 1; test_case <=TC ; test_case++) {
            N=Integer.parseInt(br.readLine());
            M=Integer.parseInt(br.readLine());
            adj=new int[N][N];

            StringTokenizer st =null;
            int i,j;
            for (int m = 0; m < M; m++) {
                st =new StringTokenizer(br.readLine()," ");
                i=Integer.parseInt(st.nextToken());
                j=Integer.parseInt(st.nextToken());
                 adj[i][j]=1; //i는 j 보다 키가 작다

            } // 친구 키 관계로 인접 행렬 대입

        }

    }// end of main

  //  private static void gtBFS(int )



} // end of class

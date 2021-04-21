package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_SWEA_5643_키순서_오도경 {

    static int N,M, student[][];
    static int Max =100000;


    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        int TC =Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <=TC ; test_case++) {
            N=Integer.parseInt(br.readLine());
            M=Integer.parseInt(br.readLine());
            student =new int [N][N];
            int count =0;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    student[i][j]=Max;
                }
            }

            for (int i = 0; i < M; i++) {
                StringTokenizer st =new StringTokenizer(br.readLine()," ");
                int num1 =Integer.parseInt(st.nextToken())-1;
                int num2=Integer.parseInt(st.nextToken())-1;
                student[num1][num2]=1;
            }

            for (int k = 0; k < N; k++) { //경유지
                for (int i = 0; i < N; i++) { //출발
                    for (int j = 0; j < N; j++) { // 도착
                        student[i][j]=Math.min(student[i][j],student[i][k]+student[k][j]);
                    }
                }
            }
//
//            for (int i = 0; i < N; i++) {
//                for(int j=0;j<N;j++){
//                    if(student[i][j] == Max)System.out.print(-1 + " ");
//                    else System.out.print(student[i][j] + " ");
//                }
//                System.out.println();
//            }

            for (int i = 0; i < N; i++) {
                student[i][i]=0;
                boolean check =true;
                for (int j = 0; j < N; j++) {
                    if(student[i][j]==Max&&student[j][i]==Max){
                        check =false;
                        break;
                    }
                }
                if(check) count++;
            }

            System.out.println("#"+test_case+" "+count);
            
            
        } // end of tc 

    } // end of main 
} // end of class 

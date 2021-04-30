package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_1208_Flatten {
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));

        for (int test_case = 1; test_case <=10 ; test_case++) {

            int count =Integer.parseInt(br.readLine());
            int box[] =new int [100];
            StringTokenizer st= new StringTokenizer(br.readLine()," ");
            for (int i = 0; i < 100; i++) {
                box[i] = Integer.parseInt(st.nextToken());

            }
            Arrays.sort(box);
            for (int i = 0; i < count; i++) {
                Arrays.sort(box);
                box[0]+=1;
                box[99]-=1;
            }
            Arrays.sort(box);
            System.out.println("#"+test_case+" "+(box[99]-box[0]));


        } // end of tc


    }// end of main
} // end of class

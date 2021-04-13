package BOJ;

import java.util.Arrays;
import java.util.Scanner;

public class BJ_15654_N과M5 {
    static int N,R;
    static int [] input;
    static int [] numbers;
    static boolean[] isSelected;
    static StringBuilder sb =new StringBuilder();

    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        N=sc.nextInt();// N개중
        R=sc.nextInt(); // R개 뽑기
        input=new int[N];
        numbers =new int[R];
        isSelected =new boolean[N];

        for (int i = 0; i < N; i++) {
            input[i]=sc.nextInt();
        }
        Arrays.sort(input);

        permutation(0);
        System.out.println(sb);
    }

    private static void permutation(int cnt) {

        if(cnt==R){
            for (int i = 0; i <cnt ; i++) {
                sb.append(numbers[i]+" ");
            }
            sb.append('\n');
            return;
        }
        for (int i = 0; i < N; i++) {
            if(isSelected[i]) continue;
            numbers[cnt]=input[i];
            isSelected[i]=true;
            permutation(cnt+1);
            isSelected[i]=false;
        }

    }
}

package SWEA;

import java.util.Scanner;

public class Solution_SWEA_4008_숫자만들기 {
	private static int N;
	private static int oper1;
	private static int oper2;
	private static int oper3;
	private static int oper4;
	private static int[] num;
	private static int min;
	private static int max;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt(); // 테케수
		for (int TC = 1; TC <= T; TC++) {
			 N = sc.nextInt(); // 숫자 개수
			 oper1 = sc.nextInt(); // +
			oper2 = sc.nextInt(); // -
			 oper3 = sc.nextInt(); // *
			oper4 = sc.nextInt(); // /

			 num = new int[N]; // 숫자 입력
			for (int i = 0; i < N; i++) {
				num[i] = sc.nextInt();
			}
			
			 max =Integer.MIN_VALUE;
			 min = Integer.MAX_VALUE;
			
			def(1,N,num[0],oper1,oper2,oper3,oper4);
			
			int result =max-min;
		System.out.println("#"+TC+" "+result);	
		}

	}

	static void def(int n, int k,int r, int op1, int op2, int op3, int op4) {
		if(n==k) {
			if(max<r) {
				max=r;
			}
			if(min>r) {
				min=r;
			}
			
		}else{
			if(op1>0) {
				def(n+1, k,r+num[n] , op1-1, op2, op3, op4);
				
			}if(op2>0) {

				def(n+1, k,r-num[n] , op1, op2-1, op3, op4);
			}if(op3>0) {

				def(n+1, k,r*num[n] , op1, op2, op3-1, op4);
			}if(op4>0) {

				def(n+1, k,r/num[n] , op1, op2, op3, op4-1);
			}
			
			
		}
		
		
	}

}

package BOJ;

import java.util.Scanner;

public class Main_백준_1244_스위치 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N =sc.nextInt()+1; // 스위치 개수
		int p[]=new int[N];
	
		for (int i = 1; i < N; i++) {
			p[i]=sc.nextInt();
		}// 배열 입력받기 //
		
		int num =sc.nextInt(); //  학생수 
		for (int i = 1; i <= num; i++) {
			int sx =sc.nextInt();//성별
			int ber =sc.nextInt(); //번호 
			
			if(sx==1) {
				for (int j = ber; j < N; j+=ber) {
					p[j]^=1;
				}
			}else if(sx==2) {
				int Lber =ber-1;
				int Rber =ber+1;
				while(true) {
					if(Lber<1||Rber>=N) 
						break;
					if(p[Lber]!=p[Rber]) {break;
					}Lber--;
					Rber++;
				}
				Lber++;
				Rber--;
				for (int j = Lber; j <=Rber; j++) {
					p[j]^=1;
				}
			}
		}
			for (int j = 1; j < N; j++) {
				System.out.print(p[j]+" ");
				if(j%20==0) {
					System.out.println();
				}
			}
		

	}// end of main
}// end of class

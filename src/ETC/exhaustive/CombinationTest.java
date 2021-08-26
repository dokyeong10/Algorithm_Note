package exhaustive;

import java.util.Arrays;
/**
 * @author THKim
 */
//nCr
public class CombinationTest {
	
	static int[] numbers;
	static int N=4, R=2; //N개 중에 R개 뽑는 경우의 수
	
	public static void main(String[] args) {
		numbers = new int[R];
		combination(0, 1);
	}
	
	static void combination(int cnt,int start){
		// cnt : 현재까지 뽑은 조합 원소 개수
		// start : 조합 시도할 원소의 시작 인덱스
		if(cnt == R) {
			System.out.println(Arrays.toString(numbers));
			return;
		}
		for (int i=start; i <=N; i++) { // i:시도하는 수
			numbers[cnt] = i;
			combination(cnt+1,i+1);
 		}
		
	}

}

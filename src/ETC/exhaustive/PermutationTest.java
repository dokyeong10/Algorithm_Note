package exhaustive;

import java.util.Arrays;
/**
 * @author THKim
 */
// nPn
public class PermutationTest {

	static int[] numbers;
	static int N = 4;
	static boolean[] isSelected;
	
	public static void main(String[] args) {
		numbers = new int[N];
		isSelected = new boolean[N+1];
		
		permutation(0);
	}
	
	static void permutation(int cnt) {
		if(cnt==N) {
			System.out.println(Arrays.toString(numbers));
			return;
		}
		for (int i = 1; i <= N; i++) { // i:시도하는 숫자
			if(isSelected[i]) continue;
			
			numbers[cnt] = i;
			isSelected[i] = true;
			
			permutation(cnt+1);
			isSelected[i] = false;
			
		}
	}

}








package exhaustive;
/**
 * @author THKim
 */
public class A1_ArraySearchTest {

	static int[][] arr = {
		{1,2,3,4},
		{5,6,7,8},
		{9,10,11,12},
		{13,14,15,16}
	};
	static int ROW,COL;
	public static void main(String[] args) {
		ROW = arr.length;
		COL = arr[0].length;
		
		System.out.println("지그재그 탐색");
		searchByZigzag0();
		searchByZigzag();
	}

	public static void searchByZigzag0() {
		for(int i=0; i<ROW; ++i) {
			if(i%2==0) {
				for(int j=0; j<COL; ++j) {
					System.out.print(arr[i][j]+"\t");
				}
			}else {
				for(int j=COL-1; j>=0; --j) {
					System.out.print(arr[i][j]+"\t");
				}				
			}
			System.out.println();
		}
	}

	public static void searchByZigzag() {
		int temp=0;
		for(int i=0; i<ROW; ++i) {
			for(int j=0; j<COL; ++j) {
				temp = j+(COL-1-2*j)*(i%2); 
				System.out.print(arr[i][temp]+"\t");
			}
			System.out.println();
		}
	}
}

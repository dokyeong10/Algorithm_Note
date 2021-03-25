package BOJ;

import java.io.*;

public class Main1024re {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		// 등차수열 공식 이용 S=(a+a+(n-1)*d)*n/2    a=첫항, d는 등차, n은 항의개수

		String[] arr = br.readLine().split(" "); // 띄어쓰기로 구분
		int N = Integer.parseInt(arr[0]); // 합
		int L = Integer.parseInt(arr[1]); // 최소 개수
		boolean flag = true;
		for (int i = L; i <= 100 && flag; i++) {
			if ((2 * N >= i * (i - 1)) && (2 * N - i * (i - 1)) % (2 * i) == 0) {
				int a = ((2 * N - i * (i - 1)) / (2 * i));
				for (int j = 0; j < i; j++) {
					bw.write((a + j) + " ");
				}
				bw.write("\n");
				flag = false;
			}
		}

		if (flag)
			bw.write("-1 \n");
		bw.close();
	}

}

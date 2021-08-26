import java.util.Arrays;
/*
* 알고리즘 응용 dp
* 동전 거스름돈
*
* DP=> 점화식=>이전 차수와의 관계식
*
* 완탐 재귀함수 (점화식)=>재귀함수 메모이제이션 => dp
*
* 추가적으로 고려해야할 사항:
* 1. 동전의 개수와 금액이 유동적일 수 있음
* 2. 거슬러줄수 없는 경우에 대한 처리
**
*
* 0-1 (항목이 유일한가/ 여러개있는가)
* 쪼갤수있는 (항목이 유일한가 / 여러개 있는가 )
*
*
* */

public class 동전거스름돈_DP {
    public static void main(String[] args) {
        System.out.println(f(8));
    }// end of main

    public static int f(int n) {
        int[] C = new int[n + 1]; //거스름돈의 최소 동전 개수 (최적의 해)
        //1차원 배열만 만들어서 업데이트 하면서 사용해보자
        //1원 짜리 동전만 고려
        for (int i = 1; i < C.length; i++) {
            C[i] = i;
        }

        System.out.println(Arrays.toString(C));


        //1,4원 짜리 동전 고려
        for (int i = 4; i < C.length; i++) {
            if (C[i] > C[i - 4] + 1) { //4원짜리 동전을 고려한 경우 동전개수가 더 작다면 업데이트
                C[i] = C[i - 4] + 1;
            }
        }
        System.out.println(Arrays.toString(C));

        // 1,4,6원 짜리 동전 고려
        for (int i = 6; i < C.length; i++) {
            if (C[i] > C[i - 6] + 1) { //4원짜리 동전을 고려한 경우 동전개수가 더 작다면 업데이트
                C[i] = C[i - 6] + 1;
            }
        }
        System.out.println(Arrays.toString(C));
        return C[n];


    }
} // end of class

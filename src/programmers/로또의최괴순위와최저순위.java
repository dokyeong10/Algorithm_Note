package programmers;
import java.util.*;
public class 로또의최괴순위와최저순위 { //
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int [2];
        int zerocnt = 0;
        int cnt =0;
        Arrays.sort(lottos);
        Arrays.sort(win_nums);
        for(int i=0; i<6;i++){
            if(lottos[i]==0){
                zerocnt++;
            }else{
                for(int j=0; j<6;j++){
                    if(lottos[i]==win_nums[j]){
                        cnt++;
                        break;
                    }
                }
            }
        }
        if(zerocnt==0){
            if(cnt>1){
                answer[0]=Math.abs(cnt-7);
                answer[1]=Math.abs(cnt-7);
            }else{
                answer[0]=6;
                answer[1]=6;
            }
        }else{
            if(cnt>1){
                answer[0]=Math.abs(cnt-7+zerocnt);
                answer[1]=Math.abs(cnt-7);
            }else{
                answer[0]=Math.abs(cnt+zerocnt-7);
                answer[1]=6;
            }
        }
        return answer;
    }
}

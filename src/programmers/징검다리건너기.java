package programmers;
import java.util.*;
public class 징검다리건너기 {
    public int solution(int[] stones, int k) {
        int answer = 0;
        int low =1;
        int high = 200000000;
        int mid =0;

        while(low<=high){
            mid = (low+high)/2;
            if(!cross(k,stones,mid)){
                high = mid-1;
            }else{
                low = mid+1;
                answer = Math.max(answer,mid);
            }
        }
        return answer;
    }
    static boolean cross(int k, int stones[],int mid){
        int cnt= 0;
        for(int i =0; i<stones.length;i++){
            if(stones[i]-mid<0){
                cnt++;
                if(cnt>=k){
                    return false;
                }
            }else {
                cnt=0;
            }
        }
        return true;
    }
}

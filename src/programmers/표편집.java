package programmers;
import java.util.*;
public class 표편집 {
    public String solution(int n, int k, String[] cmd) {

        int curnum = 0;
        Stack<Integer> remove_order = new Stack<Integer>();
        int table_size = n;

        for(int i=0; i<cmd.length; i++){
            //System.out.println(main);
            char current = cmd[i].charAt(0);
            if(current=='U'){
                curnum = Integer.valueOf(cmd[i].substring(2)); //숫자
                k -= curnum;
            }else if(current =='D'){
                curnum = Integer.valueOf(cmd[i].substring(2)); //숫자
                k += curnum;
            }else if(current =='C'){
                table_size--;
                remove_order.add(k);
                if(k==table_size)
                    k--;
            }else if(current == 'Z'){
                if(remove_order.pop()<=k)
                    k++;
                table_size++;
            }
        }
        StringBuilder builder = new StringBuilder();
        for(int i=0; i<table_size; i++)
            builder.append("O");
        while(!remove_order.isEmpty())
            builder.insert(remove_order.pop().intValue(), "X");
        String answer=builder.toString();

        return answer;


    } // end of main
}

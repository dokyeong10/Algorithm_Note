package programmers;

import java.util.*;
import java.io.*;

public class 오픈채팅방 {
    public String[] solution(String[] record) {
        StringBuilder sb = new StringBuilder();
        HashMap<String, String> map = new HashMap<>();
        ArrayList<String[]> list = new ArrayList<>();
        for (int i = 0; i < record.length; i++) {
            String rel[] = record[i].split(" ");
            if (rel[0].equals("Enter")) {
                map.put(rel[1], rel[2]);
                String arr[] = new String[2];
                arr[0] = rel[1];
                arr[1] = "님이 들어왔습니다.";
                list.add(arr);
            } else if (rel[0].equals("Leave")) {
                map.get(rel[1]);
                String arr[] = new String[2];
                arr[0] = rel[1];
                arr[1] = "님이 나갔습니다.";
                list.add(arr);
            } else if (rel[0].equals("Change")) {
                map.put(rel[1], rel[2]);
            }
        }
        String[] answer = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = map.get(list.get(i)[0]) + list.get(i)[1];
        }
        return answer;
        !sb.equals()
    }
}

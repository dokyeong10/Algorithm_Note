//package ETC1;
//
//import com.google.gson
//        .JsonObject;
//import com.google.gson.JsonParser;
//
//import java.io.*;
//import java.net.HttpURLConnection;
//import java.net.URL;
//
//public class 스무고개_with_REST {
//    public static void main(String[] args) throws Exception {
//        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
//        String next, a;
//        System.out.println("Q1 : 5기 여러분들이 싸피와 함께한지도 벌써 6개월이 되었는데요. 싸피 5기의 입학식은 1월 OO일 이였습니다. 여기서 OO에 들어갈 숫자는 ?");
//        next = "alpha";
//        String tmp;
//        int ans_num = 20;
//        while (ans_num > 0) {
//            System.out.print("answer : ");
//            a = bf.readLine();
//            tmp = sendPostJson(next, a);
//            if (tmp != "") {
//                next = tmp;
//                ans_num--;
//            }
//        }
//    }
//
//    public static String sendPostJson(String code, String answer) throws Exception {
//        URL url = new URL("http://13.125.222.176/quiz/" + code);
//        HttpURLConnection con = (HttpURLConnection) url.openConnection();
//        con.setRequestMethod("POST");
//        con.setRequestProperty("Content-Type", "application/json");
//        con.setRequestProperty("Accept", "application/json");
//        con.setDoOutput(true);
//        String jsonInputString = "{\"nickname\": \"서울 4반 오도경\", \"yourAnswer\" : \"" + answer + "\"}";
//        try (OutputStream os = con.getOutputStream()) {
//            byte[] input = jsonInputString.getBytes("utf-8");
//            os.write(input, 0, input.length);
//        }
//        try (BufferedReader br = new BufferedReader(
//                new InputStreamReader(con.getInputStream(), "utf-8"))) {
//            StringBuilder response = new StringBuilder();
//            String responseLine = null;
//            while ((responseLine = br.readLine()) != null) {
//                response.append(responseLine.trim());
//            }
//            JsonParser jp = new JsonParser();
//            JsonObject jo = (JsonObject) jp.parse(response.toString());
//            String responseCode = jo.get("code").toString();
//            if (responseCode.equals("600")) {
//                System.out.println("틀렸습니다.");
//                return "";
//            } else {
//                System.out.println(jo.get("question"));
//                StringBuilder last = new StringBuilder(jo.get("nextUrl").toString());
//                last.deleteCharAt(last.length() - 1);
//                last.deleteCharAt(0);
//                return last.toString();
//            }
//        }
//    }
//}
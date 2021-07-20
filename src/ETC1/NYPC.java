package ETC1;

import java.util.Scanner;

public class NYPC {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int potato_1 = sc.nextInt();
        int carrot_1 = sc.nextInt();
        int onion_1 = sc.nextInt();
        int potato_me = sc.nextInt();
        int carrot_me = sc.nextInt();
        int onion_me = sc.nextInt();

        int min = Integer.MAX_VALUE;
        int potato_make = potato_me / potato_1;
        int carrot_make = carrot_me / carrot_1;
        int onion_make = onion_me / onion_1;
        if (potato_make < min) {
            min = potato_make;
        }
        if (carrot_make < min) {
            min = carrot_make;
        }
        if(onion_make<min){
            min =onion_make;
        }
        System.out.println(min);

    }
}

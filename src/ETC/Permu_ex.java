package ETC1;

public class Permu_ex {
    static char arr[] ={'a','b','c','d','e'};
    static char copy[];
    static boolean check[];

    public static void main(String[] args) {
        copy = new char[5];
        check =new  boolean[5];
        permu(0);
    } // end of main

    private static void permu(int num) {
        if(num==arr.length){
            for (int i = 0; i < arr.length; i++) {
                System.out.print(copy[i]);
            }
            System.out.println();
        }
        for (int i = 0; i < arr.length; i++) {
            if(!check[i]) {
                copy[num] = arr[i];
                check[i]=true;
                permu(num + 1);
                check[i]=false;
            }
        }



    }
} // end of class

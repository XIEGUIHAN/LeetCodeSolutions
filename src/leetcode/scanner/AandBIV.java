package leetcode.scanner;

import java.util.Scanner;

public class AandBIV {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()){
            int x = sc.nextInt();
            if(x != 0){
                int[] array = new int[x];
                int result = 0;
                for (int i = 0; i < x; i++) {
                    array[i] = sc.nextInt();
                }
                for (int i = 0; i < x; i++) {
                    result += array[i];
                }
                System.out.println(result);
            }else {
                break;
            }
        }
    }
}

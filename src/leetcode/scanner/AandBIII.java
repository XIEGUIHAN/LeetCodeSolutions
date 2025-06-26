package leetcode.scanner;

import java.util.Scanner;

public class AandBIII {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()){
            int a = sc.nextInt();
            int b = sc.nextInt();
            if (a==0 && b==0){
                return;
            }
            System.out.println(a+b);
        }
    }
}

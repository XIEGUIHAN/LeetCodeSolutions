package leetcode.scanner;

import java.util.Scanner;

public class stringwithblank {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int cycle = in.nextInt();

        for(int i = 0; i < cycle; i++) {
            int number = in.nextInt();
            char[] charArray = new char[number];
            in.nextLine();
            String line = in.nextLine();

            for (int j = 0; j < number; j++) {
                charArray[j] = line.charAt(j);
            }
            for (int k = 0; k < number; k++) {
                System.out.print(charArray[k]);
            }
        }



    }
}

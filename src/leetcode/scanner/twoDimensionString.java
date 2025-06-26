package leetcode.scanner;

import javax.annotation.Resource;
import java.util.Scanner;

public class twoDimensionString {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int row = in.nextInt();
        int column = in.nextInt();

        char[][] charArray = new char[row][column];
        for(int i = 0; i < row; i++) {
            String line = in.next();
            for (int j = 0; j < column; j++) {
                charArray[i][j] = line.charAt(j);
            }
        }

        for(int i = row-1; i >= 0; i--) {
            for (int j = column-1; j >= 0; j--) {
                System.out.print(charArray[i][j]);
            }
            System.out.println();
        }
    }
}

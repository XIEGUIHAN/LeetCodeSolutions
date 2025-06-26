package leetcode.scanner;
import java.util.Scanner;

public class twoDimensionArray {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int row = in.nextInt();
        int column = in.nextInt();
        long sum = 0;
        int[][] array = new int[row][column];
        // 注意 hasNext 和 hasNextLine 的区别
        for(int i=0; i<row; i++){
            for(int j=0; j<column; j++){
                array[i][j] = in.nextInt();
                sum += array[i][j];
            }
        }
        System.out.println(sum);
    }
}

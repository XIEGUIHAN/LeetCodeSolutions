package leetcode.matrix;

// 74.搜索二维矩阵---标准二分搜索

public class searchMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;

        int left = 0, right = m*n-1;

        while ( left <= right){
            int mid = (right-left)/2+left;
            int midNumber = trans(matrix, mid);
            if (midNumber == target){
                return true;
            }
            if (midNumber < target){
                left = mid+1;
            }
            if (midNumber > target){
                right = mid-1;
            }
        }
        return false;
    }

    public int trans(int[][] matrix, int index) {
        int m = matrix.length;
        int n = matrix[0].length;

        int row = index/n;
        int column = index % n;

        int res = matrix[row][column];
        return res;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        int target = 3;
        searchMatrix se = new searchMatrix();
        boolean res = se.searchMatrix(matrix, target);
        System.out.println(res);
    }

}

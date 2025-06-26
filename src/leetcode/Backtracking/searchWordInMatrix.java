package leetcode.Backtracking;

public class searchWordInMatrix {
    boolean isExist = false;
    public boolean exist(char[][] board, String word) {
        int wordLen = word.length();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                int[][] flag = new int[board.length][board[0].length];
                DFS(board, word, flag, i ,j, 0, wordLen);
            }
        }
        return isExist;
    }
    void DFS(char[][] board, String word, int[][] flag, int i, int j, int index, int wordLen){
        if (!isOver(board, i, j)){
            return;
        }
        flag[i][j] = 1;
        if (index < wordLen && board[i][j] == word.charAt(index)){
            if (index == wordLen-1){
                isExist = true;
            }
            if (i+1 < board.length && flag[i+1][j] == 0){
                DFS(board, word, flag, i+1 ,j, index+1, wordLen);
            }
            if (i-1 >= 0 && flag[i-1][j] == 0){
                DFS(board, word, flag, i-1 ,j, index+1, wordLen);
            }
            if (j+1 < board[0].length && flag[i][j+1] == 0){
                DFS(board, word, flag, i ,j+1, index+1, wordLen);
            }
            if (j-1 >= 0 && flag[i][j-1] == 0){
                DFS(board, word, flag, i ,j-1, index+1, wordLen);
            }
        }
        // 回溯：清空路径上的1
        flag[i][j] = 0;

    }

    boolean isOver( char[][] grid, int row, int column ){
        if ( row<0 || row>= grid.length || column<0 || column>=grid[0].length){
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        String word = "ABCCED";
//        char[][] board = {{'A','B','C','E'},{'S','F','E','S'},{'A','D','E','E'}};
//        String word = "ABCESEEEFS";

        searchWordInMatrix searchWordInMatrix = new searchWordInMatrix();
        boolean exist = searchWordInMatrix.exist(board, word);
        System.out.println(exist);
    }
}

package leetcode.editor.en;

public class SudokuSolver_37 {
    public static void main(String[] args) {
        Solution solution = new SudokuSolver_37().new Solution();


    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void solveSudoku(char[][] board) {
            help(board);
        }

        private boolean help(char[][] board) {
            for(int i = 0; i<9; i++){
                for(int j = 0; j<9; j++){

                    if(board[i][j] == '.'){
                        for(char n='1'; n<='9'; n++){ // 注意這一行，學到了，原來也可以這樣用char for loop
                            if(isValid(board,i,j,n)){
                                board[i][j] = n;
                                if(help(board))
                                    return true;
                                board[i][j] = '.';
                            }
                        }
                        return false;
                    }

                }
            }
            return true;
        }

        private boolean isValid(char[][] board, int row, int column, int num) {
            for(int i = 0; i<9; i++){
                if(board[row][i]==num) return false;
                if(board[i][column]==num) return false;
            }

            int rowBox = row/3;
            int columnBox = column/3;
            for(int i = rowBox*3; i< (rowBox+1)*3; i++){
                for(int j = columnBox*3; j<(columnBox+1)*3; j++){
                    if(board[i][j]==num) return false;
                }

            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
}

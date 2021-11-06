package leetcode.editor.en;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NQueens_51 {
    public static void main(String[] args) {
        Solution solution = new NQueens_51().new Solution();


    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<List<String>> res = new ArrayList<>();
        public List<List<String>> solveNQueens(int n) {
            placeQueen(new int[n][n], 0, new HashSet<>(), new HashSet<>(), new HashSet<>());
            return res;
        }

        private void placeQueen(int[][] board, int i, Set<Integer> diagonal1, Set<Integer> diagonal2, Set<Integer> vertical) {
            if(i==board.length){
                addToList(board);
                return;
            }
            for(int j = 0; j<board.length; j++){
                if(!diagonal1.contains(i+j) && !diagonal2.contains(i-j) && !vertical.contains(j)){
                    board[i][j] = 1;
                    diagonal1.add(i+j);
                    diagonal2.add(i-j);
                    vertical.add(j);
                    placeQueen(board,i+1, diagonal1,diagonal2,vertical);
                    board[i][j] = 0;
                    diagonal1.remove(i+j);
                    diagonal2.remove(i-j);
                    vertical.remove(j);
                }
            }

        }

        private void addToList(int[][] board) {
            List<String> list = new ArrayList<>();
            for(int i = 0; i<board.length; i++){
                String tempStr = "";
                for(int j = 0; j<board.length; j++){
                    if(board[i][j] == 0)
                        tempStr+=".";
                    else
                        tempStr+="Q";
                }
                list.add(tempStr);
            }
            res.add(list);
        }


    }
//leetcode submit region end(Prohibit modification and deletion)}





}
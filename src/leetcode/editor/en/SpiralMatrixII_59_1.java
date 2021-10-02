package leetcode.editor.en;

public class SpiralMatrixII_59_1 {
    public static void main(String[] args) {
        Solution solution = new SpiralMatrixII_59_1().new Solution();
        int n = 2;
        int[][] intArr = solution.generateMatrix(n);
        System.out.println(intArr);

    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /*
            输入：n = 3
            输出：2D Array -> [[1,2,3],[8,9,4],[7,6,5]]

            0,0  0,1  0,2
            1,0  1,1  1,2
            2,0  2,1  2,2

            1 2 3
            8 9 4
            7 6 5

            0,0 0,1
            1,0 1,1

            1 2
            4 3


         */
        public int[][] generateMatrix(int n) { // 3

            int[][] intArr = new int[n][n];
            int columnStart = 0;
            int columnEnd = n-1;
            int rowStart = 0;
            int rowEnd = n-1;
            int counter = 1;

            while(columnStart<=columnEnd&&rowStart<=rowEnd){

                // 中心點
                if(columnStart==columnEnd&&rowStart==rowEnd){
                    intArr[columnStart][rowStart] = counter;
                    return intArr;
                }


                for(int i = columnStart; i<=columnEnd; i++){
                    intArr[rowStart][i] = counter;
                    if(counter==n*n) // 放進去的那個數字 = 最後的那個數字 n*n = 放完了 return;
                        return intArr;
                    counter++;

                }
                rowStart++;

                // 右線
                for(int i = rowStart; i<=rowEnd; i++){
                    intArr[i][columnEnd] = counter;
                    if(counter==n*n)
                        return intArr;
                    counter++;

                }
                columnEnd--;

                // 下線 2,0  2,1  2,2
                for(int i = columnEnd; i>=columnStart; i--){
                    intArr[rowEnd][i] = counter;
                    if(counter==n*n)
                        return intArr;
                    counter++;

                }
                rowEnd--;

                // 左線
                for(int i = rowEnd; i>=rowStart; i--){
                    intArr[i][columnStart] = counter;
                    if(counter==n*n)
                        return intArr;
                    counter++;

                }
                columnStart++;

            }



            return null;
        }



    }
//leetcode submit region end(Prohibit modification and deletion)
}





















package leetcode.editor.en;

public class SpiralMatrixII_59 {
    public static void main(String[] args) {
        Solution solution = new SpiralMatrixII_59().new Solution();
        int n = 5;
        int[][] intArr = solution.generateMatrix(n);
        System.out.println(intArr);

    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /*
            0,0  0,1  0,2
            1,0  1,1  1,2
            2,0  2,1  2,2
         */
        public int[][] generateMatrix(int n) { // 3

            int[][] intArr = new int[n][n];
            int columnStart = 0;
            int columnEnd = n-1; // 2
            int rowStart = 0;
            int rowEnd = n-1; // 2

            int counter = 1;
            while(columnStart<=columnEnd&&rowStart<=rowEnd){

                if(columnStart==columnEnd&&rowStart==rowEnd){
                    intArr[rowStart][columnStart] = counter;
                    return intArr;
                }

                // first line
                for(int i = columnStart; i<=columnEnd; i++){
                    intArr[columnStart][i] = counter;
                    if(counter==n*n)
                        return intArr;
                    counter++;
                }
                rowStart++;

                // second line
                for(int i = rowStart; i<=rowEnd; i++){
                    intArr[i][columnEnd] = counter;
                    if(counter==n*n)
                        return intArr;
                    counter++;
                }
                columnEnd--;

                // third line
                for(int i = columnEnd; i>=columnStart; i--){
                    intArr[rowEnd][i] = counter;
                    if(counter==n*n)
                        return intArr;
                    counter++;
                }
                rowEnd--;

                // fourth line
                for(int i = rowEnd; i>=rowStart; i--){
                    intArr[i][columnStart] = counter;
                    if(counter==n*n)
                        return intArr;
                    counter++;
                }
                columnStart++;
            }

            return intArr;
        }



    }
//leetcode submit region end(Prohibit modification and deletion)
}





















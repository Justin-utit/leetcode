package leetcode.editor.en;

public class SpiralMatrixII_59_3 {
    public static void main(String[] args) {
        Solution solution = new SpiralMatrixII_59_3().new Solution();
        int n = 3;
        int[][] intArr = solution.generateMatrix(n);
        System.out.println(intArr);

    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int[][] generateMatrix(int n) { // 3

            int[][] intArr = new int[n][n];
            int columnStart = 0;
            int columnEnd = n-1;
            int rowStart = 0;
            int rowEnd = n-1;
            int counter = 1;

            while(columnStart<=columnEnd&&rowStart<=rowEnd){

                // 4線交會
                if(columnStart==columnEnd&&rowStart==rowEnd){
                    intArr[columnStart][rowStart] = counter;
                    return intArr;
                }

                // 上線 01 02 03
                for(int i = columnStart; i<=columnEnd ;i++){
                    intArr[rowStart][i] = counter;
                    if(counter==n*n)
                        return intArr;
                    counter++;
                }
                rowStart++;

                // 右線
                for(int i = rowStart; i<=rowEnd ; i++){
                    intArr[i][columnEnd] = counter;
                    if(counter==n*n)
                        return intArr;
                    counter++;
                }
                columnEnd--;

                // 下線
                for(int i = columnEnd; i>=columnStart ; i--){
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





















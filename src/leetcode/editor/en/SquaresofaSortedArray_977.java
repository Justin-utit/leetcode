package leetcode.editor.en;

import java.util.Arrays;

public class SquaresofaSortedArray_977 {
    public static void main(String[] args) {
        Solution solution = new SquaresofaSortedArray_977().new Solution();
        int[] nums = {-7,-3,2,3,11};
        int[] result = solution.sortedSquares(nums);
        System.out.println(result);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] sortedSquares(int[] nums) {

            for(int i = 0; i<nums.length; i++){
                int num = nums[i];
                nums[i] = Math.abs(num*num);
            }
            Arrays.sort(nums);

            return nums;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

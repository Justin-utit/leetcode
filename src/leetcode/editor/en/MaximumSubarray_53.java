package leetcode.editor.en;

public class MaximumSubarray_53 {
    public static void main(String[] args) {
        Solution solution = new MaximumSubarray_53().new Solution();
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        int res = solution.maxSubArray(nums);
        System.out.println(res);

    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxSubArray(int[] nums) {
            int max = nums[0];
            int currSum = 0;
            for(int i : nums){
                if(currSum<0)
                    currSum = 0;
                currSum+= i;
                max = Math.max(max,currSum);
            }

            return max;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
}

package leetcode.editor.en;

public class MinimumSizeSubarraySum_209 {
    public static void main(String[] args) {
        Solution solution = new MinimumSizeSubarraySum_209().new Solution();
        // 找出该数组中满足其和 ≥ target 的长度最小的 连续子数组，并返回其长度
//        int[] nums = {2,3,1,2,4,3}; // 6
//        int target = 7; // 可以很大很大的數字
        int[] nums = {1,1,1,1,1,1,1,1}; // 6
        int target = 11; // 可以很大很大的數字
        int result = solution.minSubArrayLen(target,nums);
        System.out.println(result);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /*
            int[] nums = {2,3,1,2,4,3}; // 6
            int target = 7; // 可以是很大的數字
         */
        public int minSubArrayLen(int target, int[] nums) {
            int result = Integer.MAX_VALUE;
            int left = 0;
            int sum = 0;

            for(int i = 0; i<nums.length; i++){
                sum+=nums[i];
                while (sum>=target){ // 超過就進來
                    result = Integer.min(result,i+1 - left);
                    sum-=nums[left]; // 7
                    left++; // 4
                }
            }



            return result==Integer.MAX_VALUE? 0 : result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}












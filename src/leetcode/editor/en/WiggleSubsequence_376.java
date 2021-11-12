package leetcode.editor.en;

public class WiggleSubsequence_376 {
    public static void main(String[] args) {
        Solution solution = new WiggleSubsequence_376().new Solution();
        int[] nums = {1,17,5,10,13,15,10,5,16,8};
//        int[] nums = {3,3,3,2,5};
        int res = solution.wiggleMaxLength(nums);
        System.out.println(res); // 應拿到3

    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int wiggleMaxLength(int[] nums) {
            if(nums==null || nums.length==0)
                return 0;
            if(nums.length==1)
                return 1;

            int up = 1;
            int down = 1;
            for(int i = 0; i<nums.length-1; i++){
                if(nums[i+1]>nums[i]){
                    up = down+1;
                } else if(nums[i+1]<nums[i]) {
                    down = up +1;
                }
            }

            return Math.max(up,down);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
}

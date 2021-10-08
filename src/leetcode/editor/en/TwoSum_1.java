package leetcode.editor.en;

public class TwoSum_1 {

    public static void main(String[] args) {
        Solution solution = new TwoSum_1().new Solution();
//        int[] intArr = {2,7,11,15};
//        int target = 9;
        int[] intArr = {3,2,4};
        int target = 6;
        int[] result = solution.twoSum(intArr,target);
        System.out.println(result);

    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] twoSum(int[] nums, int target) {
            int[] result = new int[2];
            for(int i = 0; i<nums.length; i++){
                for(int j = i+1; j<nums.length; j++){
                    int sum = nums[i]+nums[j];
                    if(sum==target){
                        result[0] = i;
                        result[1] = j;
                        return result;
                    }

                }
            }

            return null;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

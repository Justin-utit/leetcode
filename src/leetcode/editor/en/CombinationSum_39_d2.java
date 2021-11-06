package leetcode.editor.en;

import java.lang.annotation.Target;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class CombinationSum_39_d2 {

    public static void main(String[] args) {
        Solution solution = new CombinationSum_39_d2().new Solution();
        int[] candidates = {2,3,6,7};
        int target = 7;
        solution.combinationSum(candidates,target);

    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /*
        TC
            n的 target/min次方

            2367 -> 4

            2367  -> 4

            2367 -> 4

            2367 -> 4


        SC
            n* target/min

            4 * 4 = 16

            2 3 6 7

            7-2
            5-2
            3-2
            1-2

         */
        /*
            int[] candidates = {2,3,6,7};
            int target = 7;

            Input: candidates = [2,3,6,7], target = 7
            Output: [[2,2,3],[7]]
         */
        List<List<Integer>> res = new LinkedList<>();
        int[] nums = null;
        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            Arrays.sort(candidates);
            nums = candidates;

            dfs(new LinkedList<>(), target, 0);

            return res;
        }
        // Target - n -> 7-2 = 5 , 5-2 = 3, 3-3 = 0
        private void dfs(List<Integer> currentList, int target, int index) {
            if(target==0){
                res.add(new LinkedList<>(currentList));
            } else {
                for(int i = index; i<nums.length; i++){ // 2 3 6 7
                    if(nums[i]> target)
                        break;

                    // Target - nums[]
                    currentList.add(nums[i]);
                    dfs(currentList, target-nums[i], i);
                    // 回復
                    currentList.remove(currentList.size()-1);
                }
            }
        }

    }
//leetcode submit region end(Prohibit modification and deletion)
}
















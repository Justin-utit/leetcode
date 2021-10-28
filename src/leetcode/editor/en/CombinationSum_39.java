package leetcode.editor.en;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class CombinationSum_39 {

    public static void main(String[] args) {
        Solution solution = new CombinationSum_39().new Solution();
        int[] candidates = {2,3,6,7};
        int target = 7;
        solution.combinationSum(candidates,target);

    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        List<List<Integer>> res = new LinkedList<>();
        int[] nums = null;
        int target = 0;

        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            Arrays.sort(candidates);
            this.nums = candidates;
            this.target = target;
            dfs(new LinkedList<>(), 0);
            return res;
        }

        private void dfs(List<Integer> currentList, int index) {
            if(target==0){ // 減至零時
                res.add(new LinkedList<>(currentList));
            }else {
                for(int i = index; i<nums.length; i++){ // 0, 1, 2, 3
                    if(nums[i]>target)
                        break;
                    target = target - nums[i];
                    currentList.add(nums[i]);
                    dfs(currentList,i); // 0, 1, 2, 3
                    currentList.remove(currentList.size()-1);
                    target += nums[i];
                }
            }
        }


    }
//leetcode submit region end(Prohibit modification and deletion)
}
















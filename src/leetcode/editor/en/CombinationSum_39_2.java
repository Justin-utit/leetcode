package leetcode.editor.en;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class CombinationSum_39_2 {

    public static void main(String[] args) {
        Solution solution = new CombinationSum_39_2().new Solution();
        int[] candidates = {2,3,6,7};
        int target = 7;
        solution.combinationSum(candidates,target);

    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        List<List<Integer>> res = new LinkedList<>();
        int[] nums = null;

        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            Arrays.sort(candidates);
            this.nums = candidates;
            dfs(new LinkedList<>(), 0, target);
            return res;
        }

        private void dfs(List<Integer> currentList, int index, int target) {
            if(target==0){ // 減至零時
                res.add(new LinkedList<>(currentList));
            }else {
                for(int i = index; i<nums.length; i++){ // 0, 1, 2, 3
                    if(nums[i]>target) // 減完後小於零就break loop(超過base case，之後就不必做了)
                        break;
                    currentList.add(nums[i]);
                    dfs(currentList,i,target - nums[i]); // target-當前的數，進入下一層
                    currentList.remove(currentList.size()-1);
                }
            }
        }


    }
//leetcode submit region end(Prohibit modification and deletion)
}
















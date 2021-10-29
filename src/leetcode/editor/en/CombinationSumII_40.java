package leetcode.editor.en;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class CombinationSumII_40 {

    public static void main(String[] args) {

        Solution solution = new CombinationSumII_40().new Solution();
//        int[] candidates = {10,1,2,7,6,1,5};
//        int target = 8;
        int[] candidates = {1,3,2,1};
        int target = 3;
        solution.combinationSum2(candidates,target);

    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        List<List<Integer>> res = new LinkedList<>();
        int[] nums = null;

        public List<List<Integer>> combinationSum2(int[] candidates, int target) {
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
                    // Each number in candidates may only be used once in the combination. (故+1)
                    dfs(currentList,i+1,target - nums[i]); // target-當前的數，進入下一層
                    currentList.remove(currentList.size()-1);
                    while (i+1<nums.length && nums[i]==nums[i+1])
                        i++;
                }
            }
        }


    }
//leetcode submit region end(Prohibit modification and deletion)
}

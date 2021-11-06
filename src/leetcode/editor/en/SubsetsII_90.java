package leetcode.editor.en;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class SubsetsII_90 {

    public static void main(String[] args) {
        Solution solution = new SubsetsII_90().new Solution();
        int[] nums = {1,2,2};
        solution.subsetsWithDup(nums);

    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<List<Integer>> res = new LinkedList<>();
        public List<List<Integer>> subsetsWithDup(int[] nums) {
            Arrays.sort(nums);
            dfs(nums, new LinkedList<>(), 0);

            return res;
        }

        private void dfs(int[] nums, List<Integer> currList, int index) {
            res.add(new LinkedList<>(currList));
            for(int i = index; i<nums.length; i++){
                currList.add(nums[i]);
                dfs(nums,currList,i+1);
                currList.remove(currList.size()-1);
                while(i+1<nums.length&&nums[i+1]==nums[i]){
                    i++;
                }
            }
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}

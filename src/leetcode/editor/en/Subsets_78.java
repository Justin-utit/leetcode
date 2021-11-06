package leetcode.editor.en;

import java.util.LinkedList;
import java.util.List;

public class Subsets_78 {
    public static void main(String[] args) {
        Solution solution = new Subsets_78().new Solution();
        int[] nums = {1,2,3};
        solution.subsets(nums);

    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<List<Integer>> res = new LinkedList<>();
        public List<List<Integer>> subsets(int[] nums) {
            // 先自己寫寫看, 才會知道問題點在那裡，再看別人解，才知道看點在那裡
            dfs(nums,new LinkedList<>(), 0);
            return res;
        }

        private void dfs(int[] nums, List<Integer> currList, int index) {

                res.add(new LinkedList<>(currList));
                for(int i = index; i<nums.length; i++){
                    currList.add(nums[i]);
                    dfs(nums, currList, i+1);
                    currList.remove(currList.size()-1);
                }

        }
    }
//leetcode submit region end(Prohibit modification and deletion)
}







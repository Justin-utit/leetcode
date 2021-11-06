package leetcode.editor.en;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class IncreasingSubsequences_491 {

    public static void main(String[] args) {
        Solution solution = new IncreasingSubsequences_491().new Solution();


    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        Set<List<Integer>> set = new HashSet<>();

        public List<List<Integer>> findSubsequences(int[] nums) {


            dfs(nums, new LinkedList<>(), 0);

            return new LinkedList<>(set);
        }

        private void dfs(int[] nums, List<Integer> currList, int index) {
            if (currList.size() > 1) {
                set.add(new LinkedList<>(currList));
            }
            for (int i = index; i < nums.length; i++) {
                if (currList.size() == 0 || nums[i] >= currList.get(currList.size() - 1)) {
                    currList.add(nums[i]);
                    dfs(nums, currList, i + 1);
                    currList.remove(currList.size() - 1);
                }
            }

        }
    }
//leetcode submit region end(Prohibit modification and deletion)
}

package leetcode.editor.en;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class Permutations_46_2 {
    public static void main(String[] args) {
        Solution solution = new Permutations_46_2().new Solution();
        int[] nums = {1,2,3};
        solution.permute(nums);
    }



    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<List<Integer>> res = new LinkedList<>(); // 觸底時，記錄該permutation
        int[] nums; // 固定數組 (每次進入的轉數)
        public List<List<Integer>> permute(int[] nums) {

            if(nums==null||nums.length==0)
                return res;

            this.nums = nums;

            dfs(new LinkedList<Integer>(), new HashSet<Integer>());

            return res;
        }

        private void dfs(List<Integer> cList, HashSet<Integer> set) {
            if(cList.size()==nums.length)
                res.add(new LinkedList<Integer>(cList));
            else {

                for(int i = 0; i<nums.length; i++){ // 每次都必轉 1 2 3
                    if(!set.contains(nums[i])){ // 沒用過的數字
                        cList.add(nums[i]);
                        int last = cList.size()-1;
                        set.add(nums[i]); // 用過的數字

                        dfs(cList, set);

                        set.remove(nums[i]);
                        cList.remove(last);
                    }
                }

            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
}

package leetcode.editor.en;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class PermutationsII_47 {
    public static void main(String[] args) {
        PermutationsII_47.Solution solution = new PermutationsII_47().new Solution();
        int[] nums = {1,1,2};
//        int[] nums = {1,2,3};
        solution.permuteUnique(nums);
    }



    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

//        int[] nums; // 固定數組 (每次進入的轉數)

        public List<List<Integer>> permuteUnique(int[] nums) {
            List<List<Integer>> res = new LinkedList<>(); // 觸底時，記錄該permutation
            if(nums==null||nums.length==0)
                return res;

            Arrays.sort(nums);

            dfs(res, new LinkedList<>(), nums, new boolean[nums.length]);

            return res;
        }

//        int preNum = Integer.MIN_VALUE;
        private void dfs(List<List<Integer>> res, List<Integer> cList, int[] nums, boolean[] used) {
            if(cList.size()==nums.length)
                res.add(new LinkedList<>(cList));
            else {

                for(int i = 0; i<nums.length; i++){ // 每次都必轉 1 2 3

                    // 1 this若為用過的數 -> 跳過
                    // 2 this若跟前一個數重複 且 前一個數沒被用過
                    if(used[i]) //  || (i>0 && nums[i]==nums[i-1] && !used[i-1])
                        continue;

                    cList.add(nums[i]);
                    used[i] = true;
                    dfs(res, cList,nums,used);
                    used[i] = false;
                    cList.remove(cList.size()-1);

                    while (i+1<nums.length&&nums[i]==nums[i+1])
                        i++;
                }

            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

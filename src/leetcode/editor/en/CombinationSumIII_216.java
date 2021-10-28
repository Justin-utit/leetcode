package leetcode.editor.en;

import java.util.LinkedList;
import java.util.List;

public class CombinationSumIII_216 {

    public static void main(String[] args) {
        Solution solution = new CombinationSumIII_216().new Solution();
        int k = 3;
        int n = 9;
        solution.combinationSum3(k,n);

    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        List<List<Integer>> res = new LinkedList<>();
        int[] nums = {1,2,3,4,5,6,7,8,9};
//        int[] nums = {1,2,3,4}; // 24種排列組合
        int k = 0;
        int sum = 0;
        public List<List<Integer>> combinationSum3(int k, int n) {
            this.k = k;
            this.sum = n;

            dfs(new LinkedList<>(), new boolean[nums.length], -1);

            return res;
        }

        private void dfs(List<Integer> currentList, boolean[] used, int j) {
            if(currentList.size()==k){
                int total = 0;
                for(Integer i : currentList)
                    total+=i;
                if(total==sum){
                    res.add(new LinkedList<>(currentList));
                }

            } else {
                for(int i = 0; i<nums.length; i++){

                    // skip cases
                    if(used[i] == true)
                        continue;
                    if(i<=j)
                        continue;

                    // save state
                    currentList.add(nums[i]);
                    used[i] = true;
                    j = i;

                    // dfs
                    dfs(currentList,used, i);

                    // restore state
                    currentList.remove(currentList.size()-1);
                    used[i] = false;
                }

            }
        }


    }
//leetcode submit region end(Prohibit modification and deletion)

}

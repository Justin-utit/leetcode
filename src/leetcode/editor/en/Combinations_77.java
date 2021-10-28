package leetcode.editor.en;

import java.util.LinkedList;
import java.util.List;

public class Combinations_77 {
    public static void main(String[] args) {
        Solution solution = new Combinations_77().new Solution();
        int n = 4;
        int k = 2;
        solution.combine(n,k);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<List<Integer>> res = new LinkedList<>();
        int[] nums;
        int k = 0;
        public List<List<Integer>> combine(int n, int k) {
            this.k = k;
            nums = new int[n];
            for(int i = 1; i<=n; i++){
                nums[i-1] = i;
            }

            dfs(new LinkedList<>(), new boolean[n], -1);

            return res;
        }

        private void dfs(List<Integer> currentList, boolean[] used, int j) {
            // base case
            if(currentList.size()==k){
                res.add(new LinkedList<>(currentList));
            } else {
                for(int i = 0; i<nums.length; i++){

                    if(used[i]==true)
                        continue;
                    if(i<=j)
                        continue;

                    // save state
                    currentList.add(nums[i]);
                    used[i] = true;
                    j = i;
                    // dfs
                    dfs(currentList,used,j);
                    // restore state
                    currentList.remove(currentList.size()-1);
                    used[i] = false;
                }
            }
        }


    }
//leetcode submit region end(Prohibit modification and deletion)
}














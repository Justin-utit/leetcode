package leetcode.editor.en;

import java.util.LinkedList;
import java.util.List;

public class Permutations_46 {
    public static void main(String[] args) {
        Solution solution = new Permutations_46().new Solution();
        int[] nums = {1,2,3};
        solution.permute(nums);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<List<Integer>> res = new LinkedList<>();
        public List<List<Integer>> permute(int[] nums) {
            List<Integer> dt = new LinkedList<>();
            for(int i : nums){
                dt.add(i);
            }
            dfs(new LinkedList<>(), dt);
            return res;
        }

        private void dfs(List<Integer> permutation, List<Integer> dt) {
            if(dt.size()==0){
                res.add(permutation);
                return;
            }

            for(Integer i : dt){
                List<Integer> listTemp = new LinkedList<>(permutation);
                List<Integer> poolTemp = new LinkedList<>(dt);
                listTemp.add(i);
                poolTemp.remove(i);
                dfs(listTemp,poolTemp);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
}
